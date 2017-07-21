package com.shiqichuban.lib.core.service.imp;/**
 * Created by shiqichuban on 17/4/14.
 */

import com.shiqichuban.lib.core.dao.ICallable;
import com.shiqichuban.lib.core.service.IBaseService;
import com.trello.rxlifecycle.LifecycleProvider;


/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-14
 * Time: 18:02
 * Company: 拾柒网络
 * description:
 */
public abstract class BaseServiceImp implements IBaseService {

    private LifecycleProvider lifecycleProvider;
    private ICallable iCallable;

    public BaseServiceImp(LifecycleProvider lifecycleProvider, ICallable iCallable) {
        this.lifecycleProvider = lifecycleProvider;
        this.iCallable = iCallable;
    }
}
