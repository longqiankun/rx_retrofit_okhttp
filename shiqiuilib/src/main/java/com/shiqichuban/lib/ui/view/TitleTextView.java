package com.shiqichuban.lib.ui.view;

import android.content.Context;
import android.util.AttributeSet;

import com.lqk.framework.util.Handler_System;
import com.shiqichuban.lib.ui.R;

/**
 * Created by shiqichuban on 17/5/8.
 */

public class TitleTextView extends TextViewClick {
    public TitleTextView(Context context) {
        super(context);
    }

    public TitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        setTextSize(getResources().getDimension(R.dimen.s_title));
        setTextColor(getResources().getColor(R.color.s_title));
    }
}
