package com.shiqichuban.lib.core.other;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

/**
 * Created by shiqichuban on 17/5/9.
 */

public abstract class BaseProgress extends Dialog {
    public BaseProgress(@NonNull Context context) {
        super(context);
    }

    public BaseProgress(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public abstract void showDialog(String text);
}
