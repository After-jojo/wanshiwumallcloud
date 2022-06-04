package com.wangc.api.controller;

import com.wangc.api.service.UserRegistService;
import com.wangc.fmmall.entity.Users;
import com.wangc.fmmall.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@RestController
@CrossOrigin
public class UserRegistController {
    @Resource
    private UserRegistService userRegistService;
    @PostMapping("/user/regist")
    public ResultVO regist(@RequestBody Users user){
        return userRegistService.regist(user.getUsername(), user.getPassword());
    }
}
