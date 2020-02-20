package com.newland.edc.pub.demo.user.dao;

import com.newland.bd.ms.core.model.RespInfo;
import com.newland.edc.pub.demo.user.model.UserBean;

import java.util.List;

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

    /**
     * 新增用户
     *
     * @param userBean
     */
    void addUser(UserBean userBean);

    /**
     * 修改用户
     *
     * @param userBean
     */
    void modifyUser(UserBean userBean);

    /**
     * 删除用户
     *
     * @param userBean
     */
    void deleteUser(List<UserBean> userBeanList);
}
