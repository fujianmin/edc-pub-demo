package com.newland.edc.pub.demo.user.api;

import com.newland.bd.ms.core.model.RespInfo;
import com.newland.edc.pub.demo.user.model.UserBean;
import com.newland.edc.pub.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
@RestController
@RequestMapping("${cmcc.web.servlet-path}/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     *
     * @param userBean 请求BEAN
     * @return 返回对象
     */
    @PostMapping(value = "/qryUserInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespInfo qryUserInfo(@RequestBody UserBean userBean) {
        return userService.qryUserInfo(userBean);
    }

    /**
     * 新增用户
     *
     * @param userBean 请求BEAN
     * @return 返回对象
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RespInfo addUser(@Validated @RequestBody UserBean userBean) {
        // 新增时直接根据校验框架校验校验参数
        return userService.addUser(userBean);
    }

    /**
     * 修改用户
     *
     * @param userBean 请求BEAN
     * @return 返回对象
     */
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RespInfo modifyUser(@RequestBody UserBean userBean) {
        return userService.modifyUser(userBean);
    }

    /**
     * 删除用户
     *
     * @param userBeanList 请求BEAN列表
     * @return 返回对象
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RespInfo deleteUser(@RequestBody List<UserBean> userBeanList) {
        return userService.deleteUser(userBeanList);
    }
}

