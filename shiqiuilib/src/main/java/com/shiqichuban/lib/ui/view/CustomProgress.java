package com.shiqichuban.lib.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.shiqichuban.lib.core.other.BaseProgress;
import com.shiqichuban.lib.core.utils.LG;
import com.shiqichuban.lib.ui.R;

public class CustomProgress extends BaseProgress {
    FrameAnimation    mFrameAnimation;
    public CustomProgress(Context context) {
        this(context, R.style.Custom_Progress);
    }  
  
    public CustomProgress(Context context, int theme) {  
        super(context, theme);
        init();
    }  

    private void init(){
        setTitle("");
        setContentView(R.layout.progress_dialog);
        // 设置居中
       getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp =getWindow().getAttributes();
        // 设置背景层透明度
        lp.dimAmount = 0.2f;
       getWindow().setAttributes(lp);
        // dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
    }


    /** 
     * 当窗口焦点改变时调用 
     */  
    public void onWindowFocusChanged(boolean hasFocus) {
        LG.e("TAG","--------onWindowFocusChanged");
        ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
        imageView.setImageResource(R.drawable.progress_anim);
        // 获取ImageView上的动画背景  
        AnimationDrawable spinner = (AnimationDrawable) imageView.getDrawable();
        spinner.setOneShot(false);
        // 开始动画  
        spinner.start();
          /*  mFrameAnimation = (FrameAnimation) findViewById(R.id.spinnerImageView);
        int[] srcId={
                R.drawable.loading1,
                R.drawable.loading2,
                R.drawable.loading3,
                R.drawable.loading4,
                R.drawable.loading5,
                R.drawable.loading6,
                R.drawable.loading7,
                R.drawable.loading8,
                R.drawable.loading9,
                R.drawable.loading10,
                R.drawable.loading11,
                R.drawable.loading12,
        };
        mFrameAnimation.setBitmapResoursID(srcId);
        //设置单张图片展示时长
        mFrameAnimation.setGapTime(150);
        mFrameAnimation.start();*/
    }  
  
    /** 
     * 给Dialog设置提示信息 
     *  
     * @param message 
     */  
    public void setMessage(CharSequence message) {  
        if (message != null && message.length() > 0) {  
            findViewById(R.id.message).setVisibility(View.VISIBLE);
            TextView txt = (TextView) findViewById(R.id.message);
            txt.setText(message);  
            txt.invalidate();  
        }  
    }
    public void  showDialog(){
        showDialog("");
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if(mFrameAnimation!=null){
            mFrameAnimation.stop();
        }
    }

    /**
     * 弹出自定义ProgressDialog
     *            上下文
     * @param message
     * @return 
     */



    @Override
    public void showDialog(String message) {
        if (message == null || message.length() == 0) {
            findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView)findViewById(R.id.message);
            txt.setText(message);
        }
        show();
    }
}