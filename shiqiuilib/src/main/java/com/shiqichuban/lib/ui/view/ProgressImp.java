package com.shiqichuban.lib.ui.view;

import android.app.Activity;
import android.app.Dialog;

import com.shiqichuban.lib.core.other.BaseProgress;
import com.shiqichuban.lib.core.other.IProgress;
import com.shiqichuban.lib.core.utils.AppHelper;

/**
 * Created by shiqichuban on 17/5/9.
 */

public class ProgressImp implements IProgress {
    @Override
    public BaseProgress getDialog(Activity activity) {
        if(activity !=null){
            return new CustomProgress(activity);
        }else {
            return null;
        }
    }
}
