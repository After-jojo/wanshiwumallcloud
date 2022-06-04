package com.wangc.api.service.impl;

import com.wangc.api.service.UserRegistService;
import com.wangc.api.service.feign.UserCheckClient;
import com.wangc.api.service.feign.UserSaveClient;
import com.wangc.fmmall.Utils.MD5Utils;
import com.wangc.fmmall.entity.Users;
import com.wangc.fmmall.vo.ResStatus;
import com.wangc.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author After拂晓
 */
@Service
public class UserRegistServiceImpl implements UserRegistService {
    @Resource
    private UserCheckClient userCheckClient;
    @Resource
    private UserSaveClient userSaveClient;
    @Override
    public ResultVO regist(String name, String pwd) {
        synchronized (this){
            // 调用user-check 服务
            Users users = userCheckClient.check(name);

            if(users == null){
                String md5Pwd = MD5Utils.md5(pwd);
                Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                // 调用user-save服务
                int row = userSaveClient.save(user);
                if(row == 1){
                    return new ResultVO(ResStatus.OK, "注册成功", user);
                }else{
                    return new ResultVO(ResStatus.NO, "注册失败", null);
                }
            }else if (users.getUsername() == null){
                // fallback 服务降级
                return new ResultVO(ResStatus.NO, "出现故障， 请重试！", null);
            }
        }
        return new ResultVO(ResStatus.NO, "用户名已被占用！", null);
    }
}
