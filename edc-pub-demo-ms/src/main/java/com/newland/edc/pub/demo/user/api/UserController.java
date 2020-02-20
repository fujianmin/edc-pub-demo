package com.newland.edc.pub.demo.user.api;

import com.newland.edc.pub.demo.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
@RestController
@RequestMapping("${cmcc.web.servlet-path}/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
}

