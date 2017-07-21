package com.shiqichuban.lib.core.http.converter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.shiqichuban.lib.core.entity.ResultEntity;
import com.shiqichuban.lib.core.utils.LG;

import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class CustomConverterFactory<T> extends Converter
        .Factory {
  /**
   * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
   * decoding from JSON (when no charset is specified by a header) will use UTF-8.
   */
  public static CustomConverterFactory create() {
    return create(new Gson());
  }

  /**
   * Create an instance using {@code gson} for conversion. Encoding to JSON and
   * decoding from JSON (when no charset is specified by a header) will use UTF-8.
   */
  public static CustomConverterFactory create(Gson gson) {
    return new CustomConverterFactory(gson);
  }

  private final Gson gson;

  private CustomConverterFactory(Gson gson) {
    if (gson == null) throw new NullPointerException("gson == null");
    this.gson = gson;
  }

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(final Type type, Annotation[] annotations,
                                                          Retrofit retrofit) {
    return new Converter<ResponseBody, ResultEntity<T>>() {
      @Override
      public ResultEntity<T> convert(ResponseBody value) throws IOException {
        LG.e("TAG","-----type="+type.toString());
       /* TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        try {
          T result2= adapter.read(jsonReader);
        } finally {
          value.close();
        }*/



      String result=  value.string();
       ResultEntity<T> re= gson.fromJson(result,type);
        try{
        /*Field field= re.getClass().getField("data");
        Class<?> clazz=  field.getType();*/
          Field[] aa=re.getClass().getFields();
          for (int i=0;i<aa.length;i++){
            LG.e("TAG","-----type2="+aa[i].getType());
          }
        String ss= re.getClass().getFields().toString();

        }catch (Exception E){E.printStackTrace();}


        ResultEntity<T> resultEntity=  gson.fromJson(result,ResultEntity.class);
      T t=  resultEntity.getData();
//        resultEntity.setData(gson.fromJson(result,t.getClass()));
        if(resultEntity==null){
          resultEntity=new ResultEntity();
        }
        if(!TextUtils.isEmpty(result)){
          try {
            JSONObject jsonObject = new JSONObject(result);
            if (resultEntity.getData()==null) {
//            resultEntity.setData();
            }
          }catch (Exception e){e.printStackTrace();}
        }
        return resultEntity;
      }
    };
  }

  @Override
  public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                        Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
    TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
    return new GsonRequestBodyConverter<>(gson, adapter);
  }


  final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private  final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private  final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    GsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
      this.gson = gson;
      this.adapter = adapter;
    }

    @Override public RequestBody convert(T value) throws IOException {
      Buffer buffer = new Buffer();
      Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
      JsonWriter jsonWriter = gson.newJsonWriter(writer);
      adapter.write(jsonWriter, value);
      jsonWriter.close();
      return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }
  }
}