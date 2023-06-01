package com.xiang.egg.common.security.service;

import com.xiang.egg.admin.api.dto.UserInfo;
import com.xiang.egg.admin.api.feign.RemoteUserService;
import com.xiang.egg.common.core.constant.CacheConstants;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import com.xiang.egg.common.core.model.R;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author Xiang JiangCheng
 */
@Slf4j
@Primary
@RequiredArgsConstructor
@Service
public class PigUserDetailsServiceImpl implements PigUserDetailsService {

    private final RemoteUserService remoteUserService;

    private final CacheManager cacheManager;

    /**
     * 用户名密码登录
     *
     * @param username 用户名
     * @return
     */
    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
        if (cache != null && cache.get(username) != null) {
            return (PigUser) cache.get(username).get();
        }

        R<UserInfo> result = remoteUserService.info(username);
        UserDetails userDetails = getUserDetails(result);
        if (cache != null) {
            cache.put(username, userDetails);
        }
        return userDetails;
    }

}
