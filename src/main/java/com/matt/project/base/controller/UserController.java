package com.matt.project.base.controller;

import com.matt.project.base.dataobject.UserDO;
import com.matt.project.base.mapper.UserDOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author matt
 * @create 2020-12-19 21:37
 */
@RestController
public class UserController {

    @Autowired
    private UserDOMapper userDOMapper;



    @GetMapping("/user/list")
    public List<UserDO> listUserDO(){

        Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.info("hello");

        List<UserDO> userDOList = userDOMapper.listUserDO();

        return userDOList;
    }
}
