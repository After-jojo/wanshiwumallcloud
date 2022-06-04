package com.wangc.user.dao;

import com.wangc.fmmall.entity.Users;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author After拂晓
 */
public interface UserMapper extends Mapper<Users>, MySqlMapper<Users> {
}
