package com.shiqichuban.lib.core.dao;/**
 * Created by shiqichuban on 17/4/14.
 */

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-14
 * Time: 18:42
 * Company: 拾柒网络
 * description:
 */
public abstract class ICallable<T> {
    /**
     * 回调开始
     * @param tag
     */
    public  void onStart(int tag){};

    /**
     * 成功后回调方法
     * @param t
     */
    public abstract void onSuccess(T t);
    /**
     * 回调方法失败
     * @param t
     */
    public abstract void onFail(T t);

    /**
     *
     * @param tag
     */
    public  void onCancel(int tag){};


}
