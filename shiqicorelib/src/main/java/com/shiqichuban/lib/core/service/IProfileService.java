package com.shiqichuban.lib.core.service;/**
 * Created by shiqichuban on 17/4/15.
 */

import com.shiqichuban.lib.core.entity.AppVersion;
import com.shiqichuban.lib.core.entity.RequestEntity;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-15
 * Time: 15:25
 * Company: 拾柒网络
 * description:
 */
public interface IProfileService {
     void checkVersion( RequestEntity requestEntity);
     /**登录*/
     void login(String account, String password, String openID, String accessToken, String code, String uid, RequestEntity requestEntity);

     /**获取个人信息*/
     void getProfile( RequestEntity requestEntity);
}
