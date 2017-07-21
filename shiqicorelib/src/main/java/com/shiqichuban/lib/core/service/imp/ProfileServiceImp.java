package com.shiqichuban.lib.core.service.imp;/**
 * Created by shiqichuban on 17/4/15.
 */


import com.shiqichuban.lib.core.dao.ICallable;
import com.shiqichuban.lib.core.dao.IProfileDao;
import com.shiqichuban.lib.core.dao.imp.ProfielDaoImp;
import com.shiqichuban.lib.core.entity.RequestEntity;
import com.shiqichuban.lib.core.service.IProfileService;
import com.trello.rxlifecycle.LifecycleProvider;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-15
 * Time: 15:26
 * Company: 拾柒网络
 * description:
 */
public class ProfileServiceImp extends BaseServiceImp implements IProfileService {
    IProfileDao iDao;
    public ProfileServiceImp(LifecycleProvider lifecycleProvider, ICallable iCallable) {
        super(lifecycleProvider, iCallable);
        iDao=new ProfielDaoImp(lifecycleProvider,iCallable);
    }

    @Override
    public void checkVersion( RequestEntity requestEntity) {
         iDao.checkVersion(requestEntity);
    }

    @Override
    public void login(String account, String password, String openID, String accessToken, String code, String uid, RequestEntity requestEntity) {
        iDao.login(account, password, openID, accessToken, code, uid, requestEntity);
    }

    @Override
    public void getProfile(RequestEntity requestEntity) {
        iDao.getProfile(requestEntity);
    }
}
