package com.newland.edc.pub.demo.user.service;

import com.newland.bd.ms.core.model.RespInfo;
import com.newland.bd.ms.core.utils.RespJsonUtils;
import com.newland.edc.pub.demo.common.dao.CommonFacadeDao;
import com.newland.edc.pub.demo.exception.PubDemoException;
import com.newland.edc.pub.demo.exception.PubDemoExceptionCode;
import com.newland.edc.pub.demo.user.dao.UserFacadeDao;
import com.newland.edc.pub.demo.user.model.UserBean;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
@Service
public class UserService {
    @Autowired
    private UserFacadeDao userFacadeDao;

    @Autowired
    private CommonFacadeDao commonFacadeDao;

    /**
     * 查询用户信息
     *
     * @param userBean 请求BEAN
     * @return 返回对象
     */
    public RespInfo qryUserInfo(UserBean userBean) {
        return this.userFacadeDao.getBaseDao().qryUserInfo(userBean);
    }

    /**
     * 新增用户
     *
     * @param userBean 请求BEAN
     * @return 返回对象
     */
    @Transactional(rollbackFor = Exception.class)
    public RespInfo addUser(UserBean userBean) {
        /**
         * 业务校验
         */
        // 如：校验别名是否重复
        if (StringUtils.isNoneBlank(userBean.getNickName())) {
            UserBean checkBean = new UserBean();
            checkBean.setNickName(userBean.getNickName());
            RespInfo respInfo = this.userFacadeDao.getBaseDao().qryUserInfo(checkBean);
            List<UserBean> userBeanList = RespJsonUtils.parseArray(respInfo.getRespData(), UserBean.class);
            if (CollectionUtils.isNotEmpty(userBeanList)) {
                throw new PubDemoException("已存在相同别名[" + userBean.getNickName() + "]的工号，请修改别名！", PubDemoExceptionCode.BUS_HANDLE_FAIL);
            }
        }

        /**
         * 数据入库
         */
        String userId = this.commonFacadeDao.getBaseDao().getNextVal("sm2_user");
        userBean.setUserId(userId);
        this.userFacadeDao.getBaseDao().addUser(userBean);

        return new RespInfo(userId);
    }

    /**
     * 修改用户
     *
     * @param userBean 请求BEAN
     * @return 返回对象
     */
    @Transactional(rollbackFor = Exception.class)
    public RespInfo modifyUser(UserBean userBean) {
        if (StringUtils.isBlank(userBean.getUserId())) {
            throw new PubDemoException("用户工号不能为空", PubDemoExceptionCode.PARAM_IS_BLANK);
        }

        this.userFacadeDao.getBaseDao().modifyUser(userBean);
        return new RespInfo();
    }

    /**
     * 删除用户
     *
     * @param userBeanList 请求BEAN列表
     * @return 返回对象
     */
    @Transactional(rollbackFor = Exception.class)
    public RespInfo deleteUser(List<UserBean> userBeanList) {
        if (CollectionUtils.isNotEmpty(userBeanList)) {
            for (UserBean userBean : userBeanList) {
                if (StringUtils.isBlank(userBean.getUserId())) {
                    throw new PubDemoException("用户工号不能为空", PubDemoExceptionCode.PARAM_IS_BLANK);
                }
            }
        }

        this.userFacadeDao.getBaseDao().deleteUser(userBeanList);
        return new RespInfo();
    }
}
