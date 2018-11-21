package com.ly.user.controller;

import com.ly.common.base.ResponseMessage;
import com.ly.user.service.UserService;
import com.ly.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseMessage registry(@RequestBody UserVo userVo){
        userService.save(userVo);
        return null;
    }
}
