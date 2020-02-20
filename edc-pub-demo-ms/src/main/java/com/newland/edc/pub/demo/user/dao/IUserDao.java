package com.newland.edc.pub.demo.user.dao;

import com.newland.bd.ms.core.model.RespInfo;
import com.newland.edc.pub.demo.user.model.UserBean;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
public interface IUserDao {
    /**
     * 查询用户信息
     *
     * @param userBean 请求BEAN
     * @return 返回对象
     */
    RespInfo qryUserInfo(UserBean userBean);
}
