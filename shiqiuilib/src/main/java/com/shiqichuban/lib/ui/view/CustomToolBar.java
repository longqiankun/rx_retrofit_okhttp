package com.shiqichuban.lib.ui.view;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.shiqichuban.lib.ui.R;

/**
 * Created by shiqichuban on 17/5/9.
 */

public class CustomToolBar extends Toolbar {
    public CustomToolBar(Context context) {
        super(context);
        init();
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        View.inflate(getContext(), R.layout.toolbar, this);
    }
}
