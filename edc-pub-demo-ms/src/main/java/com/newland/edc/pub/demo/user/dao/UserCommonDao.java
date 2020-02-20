package com.newland.edc.pub.demo.user.dao;

import com.newland.edc.pub.demo.user.model.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
@Repository
public abstract class UserCommonDao implements IUserDao {
    @Override
    public List<UserBean> qryUserInfo(UserBean userBean) {
        return null;
    }
}
