package com.wangc.user.controller;

import com.wangc.fmmall.entity.Users;
import com.wangc.user.service.UserCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@RestController
@RequestMapping("/user")
public class UserCheckController {
    @Resource
    private UserCheckService userCheckService;

    @GetMapping("/check")
    public Users check(String username){
        return userCheckService.queryUser(username);
    }
}
