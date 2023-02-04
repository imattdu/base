package com.matt.project.base.controller;

import com.matt.project.base.po.UserPO;
import com.matt.project.base.mapper.UserPOMapper;
import com.matt.project.base.util.LogUtil;
import com.matt.project.base.vo.CommonVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author matt
 * @create 2020-12-19 21:37
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserPOMapper userPOMapper;

    @GetMapping("/user/list")
    public List<UserPO> listUserDO() {
        logger.info("hello");
        List<UserPO> userDOList = userPOMapper.listUserPO();
        return userDOList;
    }

    @GetMapping("/hello")
    public CommonVO hello(HttpServletRequest req) {
        logger.info(LogUtil.genMsg(req, "_com_http_in", "test"));
        return CommonVO.suc(req, 11);
    }
}
