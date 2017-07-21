package com.shiqichuban.lib.ui.utils;/**
 * Created by shiqichuban on 17/5/3.
 */

import android.support.v4.content.res.ResourcesCompat;
import android.text.TextUtils;
import android.view.View;

import com.lqk.framework.util.ToastUtils;
import com.shiqichuban.lib.core.dao.ICallable;
import com.shiqichuban.lib.core.entity.RequestEntity;
import com.shiqichuban.lib.core.entity.ResultEntity;
import com.shiqichuban.lib.core.utils.AppHelper;
import com.shiqichuban.lib.core.utils.LG;
import com.shiqichuban.lib.ui.activity.BaseAppActivity;
import com.shiqichuban.lib.ui.view.AlertDialog;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-05-03
 * Time: 10:14
 * Company: 拾 网络
 * description:
 */
public abstract class PromptCallable<T> extends ICallable<T> {

    @Override
    public void onSuccess(T callable) {
        prompt(callable);
    }

    @Override
    public void onFail(T callable) {
        prompt(callable);
    }

    private void prompt(T callable) {
        if (callable != null && callable instanceof ResultEntity) {
            ResultEntity resultEntity = (ResultEntity) callable;
            RequestEntity requestEntity = resultEntity.requestEntity;
            if (requestEntity == null)
                return;

            if (resultEntity.err_code == 0) {
                //成功时提示
                if (requestEntity.successRes > 0) {
                    ToastUtils.showToast(AppHelper.getContext(), AppHelper.getContext().getString(requestEntity.successRes));
                }
            } else {
                //失败时提示
                String promptText = resultEntity.err_msg;
                if (TextUtils.isEmpty(promptText)) {
                    if (requestEntity.failRes > 0) {
                        promptText = AppHelper.getContext().getString(requestEntity.failRes);
                    }
                }

                if (TextUtils.isEmpty(promptText))
                    return;
                if (requestEntity.promptStyle == RequestEntity.TOAST) {
                    ToastUtils.showToast(AppHelper.getContext(), promptText);
                } else {
                    if (requestEntity.lifecycleProvider == null || !(requestEntity.lifecycleProvider instanceof BaseAppActivity))
                        return;
                    BaseAppActivity baseAppActivity = ((BaseAppActivity) requestEntity.lifecycleProvider);
                    if (baseAppActivity == null || !baseAppActivity.isShow)
                        return;
                    AlertDialog alertDialog = new AlertDialog(baseAppActivity).builder()
                            .setTitle("提示")
                            .setMsg(promptText)
                            .setPositiveButton("我知道了", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            });
                    alertDialog.show();

                }
            }

        }
    }
}
