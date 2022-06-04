package com.wangc.api.controller;

import com.wangc.api.service.UserLoginService;
import com.wangc.fmmall.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@RestController
@CrossOrigin
public class UserLoginController {
    @Resource
    private UserLoginService userLoginService;
    @GetMapping("/user/login")
    public ResultVO login(@RequestParam("username") String username,
                          @RequestParam("password") String password){
        ResultVO resultVO = userLoginService.checkLogin(username, password);
        return resultVO;
    }
}
