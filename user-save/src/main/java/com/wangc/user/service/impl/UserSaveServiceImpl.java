package com.wangc.user.service.impl;

import com.wangc.fmmall.entity.Users;
import com.wangc.user.dao.UserMapper;
import com.wangc.user.service.UserSaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@Service
public class UserSaveServiceImpl implements UserSaveService {
    @Resource
    private UserMapper userMapper;
    @Override
    public int saveUser(Users users) {
        return userMapper.insertUseGeneratedKeys(users);
    }
}
