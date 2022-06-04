package com.wangc.user.service.Impl;

import com.wangc.fmmall.entity.Users;
import com.wangc.user.dao.UserMapper;
import com.wangc.user.service.UserCheckService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author After拂晓
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Users queryUser(String name) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);
        List<Users> users = userMapper.selectByExample(example);
        if (users.size() <= 0) return null;
        return users.get(0);
    }
}
