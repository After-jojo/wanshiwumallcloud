package com.wangc.api.service.feign;

import com.wangc.api.service.feign.fallback.UserCheckClientFallBack;
import com.wangc.fmmall.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author After拂晓
 */
@FeignClient(name = "user-check", fallback = UserCheckClientFallBack.class)
public interface UserCheckClient {
    @GetMapping("/user/check")
    Users check(@RequestParam("username") String username);
}
