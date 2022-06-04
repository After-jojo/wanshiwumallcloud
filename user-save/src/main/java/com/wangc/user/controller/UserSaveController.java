package com.wangc.user.controller;

import com.wangc.fmmall.entity.Users;
import com.wangc.user.service.UserSaveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@RestController
@RequestMapping("/user")
public class UserSaveController {
    @Resource
    private UserSaveService userSaveService;
    @PostMapping("/save")
    public int save(@RequestBody Users users){
        return userSaveService.saveUser(users);
    }
}
