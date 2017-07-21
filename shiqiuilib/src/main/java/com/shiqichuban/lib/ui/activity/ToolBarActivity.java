package com.shiqichuban.lib.ui.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.shiqichuban.lib.ui.R;
import com.shiqichuban.lib.ui.view.CustomToolBar;
import com.shiqichuban.lib.ui.view.TextViewClick;
import com.zhy.autolayout.AutoFrameLayout;

import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class ToolBarActivity extends BaseAppActivity implements View.OnClickListener {

    protected TextViewClick tvc_top_back;
    protected TextViewClick tvc_top_certer;
    protected TextViewClick tvc_top_right1;
    protected TextViewClick tvc_top_right2;
    protected TextViewClick tvc_top_right3;

    protected CustomToolBar  customToolbar;
      protected    AutoFrameLayout afl_contains;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        customToolbar= (CustomToolBar) findViewById(R.id.customToolbar);
        afl_contains= (AutoFrameLayout) findViewById(R.id.afl_contains);

    }

    protected void addSelfContentView(int layout){
        addSelfContentView(getLayoutInflater().inflate(layout,null));
    }
    protected void addSelfContentView(View layout){
        if(layout!=null){
            afl_contains.addView(layout);
            initToolbar(customToolbar);
        }
    }
    protected void initToolbar(Toolbar toolbar) {
        if (toolbar != null && toolbar instanceof CustomToolBar) {
            toolbar.setVisibility(View.VISIBLE);
            setSupportActionBar(toolbar);
            tvc_top_back = (TextViewClick) toolbar.findViewById(R.id.tvc_top_back);
            tvc_top_certer = (TextViewClick) toolbar.findViewById(R.id.tvc_top_certer);
            tvc_top_right1 = (TextViewClick) toolbar.findViewById(R.id.tvc_top_right1);
            tvc_top_right2 = (TextViewClick) toolbar.findViewById(R.id.tvc_top_right2);
            tvc_top_right3 = (TextViewClick) toolbar.findViewById(R.id.tvc_top_right3);

            tvc_top_back.setOnClickListener(this);
            tvc_top_certer.setOnClickListener(this);
            tvc_top_right1.setOnClickListener(this);
            tvc_top_right2.setOnClickListener(this);
            tvc_top_right3.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.tvc_top_back) {
            clickBack();
        } else if (id == R.id.tvc_top_certer) {
            clickCenter();
        } else if (id == R.id.tvc_top_right1) {
            clickRight1();
        } else if (id == R.id.tvc_top_right2) {
            clickRight2();
        } else if (id == R.id.tvc_top_right3) {
            clickRight3();
        }

    }

    protected void setBackBackgroud(int res) {
        if (tvc_top_back != null) {
            tvc_top_back.setBackgroundResource(res);
        }
    }

    protected void setBackText(String text) {
        if (tvc_top_back != null) {
            tvc_top_back.setText(text);
        }
    }

    protected void setBackTextColor(int color) {
        if (tvc_top_back != null) {
            tvc_top_back.setTextColor(color);
        }
    }


    protected void setCenterBackgroud(int res) {
        if (tvc_top_certer != null) {
            tvc_top_certer.setBackgroundResource(res);
        }
    }

    protected void setCenterText(String text) {
        if (tvc_top_certer != null) {
            tvc_top_certer.setText(text);
        }
    }

    protected void setCenterTextColor(int color) {
        if (tvc_top_certer != null) {
            tvc_top_certer.setTextColor(color);
        }
    }


    protected void setRight1Backgroud(int res) {
        if (tvc_top_right1 != null) {
            tvc_top_right1.setBackgroundResource(res);
        }
    }

    protected void setRight1Text(String text) {
        if (tvc_top_right1 != null) {
            tvc_top_right1.setText(text);
        }
    }

    protected void setRight1TextColor(int color) {
        if (tvc_top_right1 != null) {
            tvc_top_right1.setTextColor(color);
        }
    }


    protected void setRight2Backgroud(int res) {
        if (tvc_top_right2 != null) {
            tvc_top_right2.setBackgroundResource(res);
        }
    }

    protected void setRight2Text(String text) {
        if (tvc_top_right2 != null) {
            tvc_top_right2.setText(text);
        }
    }

    protected void setRight2TextColor(int color) {
        if (tvc_top_right2 != null) {
            tvc_top_right2.setTextColor(color);
        }
    }


    protected void setRight3Backgroud(int res) {
        if (tvc_top_right3 != null) {
            tvc_top_right3.setBackgroundResource(res);
        }
    }

    protected void setRight3Text(String text) {
        if (tvc_top_right3 != null) {
            tvc_top_right3.setText(text);
        }
    }

    protected void setRight3TextColor(int color) {
        if (tvc_top_right3 != null) {
            tvc_top_right3.setTextColor(color);
        }
    }


    protected void clickBack() {
        finish();
    }

    protected void clickCenter() {
    }

    protected void clickRight1() {
    }

    protected void clickRight2() {
    }

    protected void clickRight3() {
    }

}
