package com.wangc.api.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangc.api.service.UserLoginService;
import com.wangc.api.service.feign.UserCheckClient;
import com.wangc.fmmall.Utils.MD5Utils;
import com.wangc.fmmall.entity.Users;
import com.wangc.fmmall.vo.ResStatus;
import com.wangc.fmmall.vo.ResultVO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author After拂晓
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private UserCheckClient userCheckClient;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ObjectMapper objectMapper;
    @Override
    public ResultVO checkLogin(String name, String pwd) {
        // 调用user-check服务
        Users user = userCheckClient.check(name);

        // 校验
        if (user == null){
            return new ResultVO(ResStatus.NO, "login fail...用户名不存在！", null);
        }

        String md5pwd = MD5Utils.md5(pwd);
        if(md5pwd.equals(user.getPassword())){
            // 登录成功，使用jwt 生成token
            JwtBuilder builder = Jwts.builder();
            String token = builder.setSubject(name) //主题 ,token中携带的数据
                    .setIssuedAt(new Date())  // 设置token的生成时间
                    .setId(user.getUserId() + "")
                    .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                    .signWith(SignatureAlgorithm.HS256, "jojo123")
                    .compact();
            try {
                String userInfo = objectMapper.writeValueAsString(user);
                stringRedisTemplate.boundValueOps(token).set(userInfo, 1, TimeUnit.MINUTES);
            }catch (JsonProcessingException e){
                e.printStackTrace();
            }
            return new ResultVO(ResStatus.OK, token, user);
        }else{
            return new ResultVO(ResStatus.NO,"登录失败，密码错误！", null);
        }
    }
}
