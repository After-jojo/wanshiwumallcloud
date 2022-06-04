package com.wangc.api.service.feign;

import com.wangc.api.service.feign.fallback.UserCheckClientFallback;
import com.wangc.fmmall.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author After拂晓
 */
@FeignClient(value = "user-check", fallback = UserCheckClientFallback.class)
public interface UserCheckClient {
    @GetMapping("/user/check")
    Users check(@RequestParam("username") String username);
}
