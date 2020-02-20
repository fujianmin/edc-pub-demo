package com.newland.edc.pub.demo.user.service;

import com.newland.bd.ms.core.model.RespInfo;
import com.newland.edc.pub.demo.user.dao.UserFacadeDao;
import com.newland.edc.pub.demo.user.model.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFacadeDao userFacadeDao;

    /**
     * 查询用户信息
     *
     * @param userBean 请求BEAN
     * @return 返回对象
     */
    public RespInfo qryUserInfo(UserBean userBean) {
        return this.userFacadeDao.getBaseDao().qryUserInfo(userBean);
    }
}
