package com.wangc.api.service.feign;

import com.wangc.api.service.feign.fallback.UserSaveClientfallback;
import com.wangc.fmmall.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * @author After拂晓
 */
@FeignClient(value = "user-save", fallback = UserSaveClientfallback.class)
public interface UserSaveClient {
    @PostMapping("/user/save")
    int save(Users users);
}
