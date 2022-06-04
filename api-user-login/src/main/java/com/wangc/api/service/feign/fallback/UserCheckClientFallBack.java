package com.wangc.api.service.feign.fallback;

import com.wangc.api.service.feign.UserCheckClient;
import com.wangc.fmmall.entity.Users;
import org.springframework.stereotype.Component;

/**
 * @author After拂晓
 */
@Component
public class UserCheckClientFallBack implements UserCheckClient {
    @Override
    public Users check(String username) {
        return null;
    }
}
