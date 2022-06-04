package com.wangc.api.service;

import com.wangc.fmmall.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author After拂晓
 */
public interface UserLoginService {
    ResultVO checkLogin(@RequestParam("username") String name, @RequestParam("password") String pwd);
}
