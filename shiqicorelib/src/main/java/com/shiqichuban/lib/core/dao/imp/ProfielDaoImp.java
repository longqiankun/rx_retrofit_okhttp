package com.shiqichuban.lib.core.dao.imp;/**
 * Created by shiqichuban on 17/4/15.
 */

import com.shiqichuban.lib.core.dao.ICallable;
import com.shiqichuban.lib.core.dao.IProfileDao;
import com.shiqichuban.lib.core.entity.RequestEntity;
import com.trello.rxlifecycle.LifecycleProvider;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-15
 * Time: 14:27
 * Company: 拾柒网络
 * description:
 */
public class ProfielDaoImp extends BaseDaoImp implements IProfileDao{
    public ProfielDaoImp(LifecycleProvider lifecycleProvider, ICallable iCallable) {
        super(lifecycleProvider, iCallable);
    }

    @Override
    public void checkVersion( RequestEntity requestEntity) {
        request(api.checkVersion(),requestEntity);

    }

    @Override
    public void login(String account, String password, String openID, String accessToken, String code, String uid, RequestEntity requestEntity) {
        request(api.login(account, password, openID, accessToken, code, uid),requestEntity);
    }

    @Override
    public void getProfile(RequestEntity requestEntity) {
        request(api.getProfile(),requestEntity);
    }
}
