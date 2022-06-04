package com.wangc.api.service.feign.fallback;

import com.wangc.api.service.feign.UserSaveClient;
import com.wangc.fmmall.entity.Users;
import org.springframework.stereotype.Component;

/**
 * @author After拂晓
 */
@Component
public class UserSaveClientfallback implements UserSaveClient {
    @Override
    public int save(Users users) {
        return 0;
    }
}
