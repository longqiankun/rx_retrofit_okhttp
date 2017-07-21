package com.lqk.framework;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lqk.framework.util.DateUtil;
import com.lqk.framework.util.ToastUtils;
import com.shiqichuban.lib.core.dao.ICallable;
import com.shiqichuban.lib.core.entity.Proflie;
import com.shiqichuban.lib.core.entity.RequestEntity;
import com.shiqichuban.lib.core.entity.ResultEntity;
import com.shiqichuban.lib.core.http.exception.RetryWhenNetworkException;
import com.shiqichuban.lib.core.http.interceptors.LoggingInterceptor;
import com.shiqichuban.lib.core.service.IProfileService;
import com.shiqichuban.lib.core.service.imp.ProfileServiceImp;
import com.shiqichuban.lib.core.http.converter.ToStringConverterFactory;
import com.shiqichuban.lib.core.utils.AppHelper;
import com.shiqichuban.lib.core.utils.LG;
import com.shiqichuban.lib.ui.activity.BaseAppActivity;
import com.shiqichuban.lib.ui.activity.ToolBarActivity;
import com.shiqichuban.lib.ui.utils.GuideUtil;
import com.shiqichuban.lib.ui.utils.PromptCallable;
import com.shiqichuban.lib.ui.view.AlertDialog;
import com.shiqichuban.lib.ui.view.TextViewClick;
import com.shiqichuban.lib.ui.view.TitleTextView;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends ToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSelfContentView(R.layout.activity_main);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(new ReycleAdapter());

        netWork();


    }



    @Override
    protected void clickBack() {
    super.clickBack();
    }

    private void netWork() {
        IProfileService iProfileService=new ProfileServiceImp(this, new PromptCallable<ResultEntity>() {
            @Override
            public void onStart(int resultEntity) {
                super.onStart(resultEntity);
            }

            @Override
            public void onSuccess(ResultEntity resultEntity) {
                super.onSuccess(resultEntity);
                ((TitleTextView)findViewById(R.id.title)).setText(resultEntity.request_code+"ok"+ DateUtil.currentDatetime());
            }

            @Override
            public void onFail(ResultEntity resultEntity) {
                super.onFail(resultEntity);
                ((TitleTextView)findViewById(R.id.title)).setText(resultEntity.request_code+"ok"+ DateUtil.currentDatetime());
            }

            @Override
            public void onCancel(int resultEntity) {
                super.onCancel(resultEntity);
            }
        });
        RequestEntity requestEntity= new RequestEntity(true,5);
        requestEntity.successRes= R.string.login_success;
        requestEntity.failRes=R.string.login_fail;
        requestEntity.promptStyle= RequestEntity.TOAST;
        requestEntity.lifecycleProvider=this;
        requestEntity.progressText="登录中...";
        iProfileService.login("17080155612","111111",null,null,null,null,requestEntity);
//        iProfileService.checkVersion(new RequestEntity(true,22));

        RequestEntity requestEntity2= new RequestEntity(true,23);
        requestEntity2.successRes=R.string.version_fail;
        requestEntity2.failRes=R.string.version_fail;
        requestEntity2.promptStyle= RequestEntity.TOAST;
        requestEntity2.lifecycleProvider=this;
//        iProfileService.getProfile(requestEntity2);
    }

    public void testClick(View view){


        Snackbar.make(view, "Snackbar comes out", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                MainActivity.this,
                                "Toast comes out",
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();


        final List<String> list=new ArrayList<>();
        for (int i=0;i<2;i++){
            list.add("束带结发"+i);
        }

    /*    AlertDialog alertDialog=new AlertDialog(this).builder()
                .setTitle("我知道了")
//                .setCenterMessage("我知道了")
                .setSelectLisnter(list, "", "", 1, true, new AlertDialog.OnSelectListener() {
                    @Override
                    public void onSelect(Set<Integer> selected) {
                        StringBuffer sb=new StringBuffer();
                        for (int i=0;i<list.size();i++){
                            if(selected.contains(i)){
                                sb.append(list.get(i)+"   ");
                            }
                        }
                        ToastUtils.showToast(MainActivity.this,sb.toString());
                    }
                });

               alertDialog .show();*/

    }


    private class ReycleAdapter extends RecyclerView.Adapter{
        public ReycleAdapter() {
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            TextViewClick textViewClick=new TextViewClick(MainActivity.this);
            textViewClick.setPadding(30,30,30,30);
            return new Vholder(textViewClick);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((Vholder)holder).textViewClick.setText("列表数据"+position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class Vholder extends RecyclerView.ViewHolder{
            TextViewClick textViewClick;
            public Vholder(View itemView) {
                super(itemView);
                textViewClick=(TextViewClick) itemView;
            }
        }
    }



}
