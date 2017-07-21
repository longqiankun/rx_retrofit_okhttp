package com.shiqichuban.lib.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by shiqi on 16/8/4.
 */
public class TextViewClick extends AppCompatTextView {
    public TextViewClick(Context context) {
        super(context);
        setClickable(true);
    }
    public TextViewClick(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Drawable drawable= getBackground();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(drawable!=null)drawable.setAlpha(80);
                break;
            default:
                if(drawable!=null)drawable.setAlpha(255);
                break;
        }
        return super.onTouchEvent(event);
    }
}
