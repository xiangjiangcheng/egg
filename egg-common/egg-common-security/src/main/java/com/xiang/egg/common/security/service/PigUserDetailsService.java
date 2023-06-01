package com.xiang.egg.common.security.service;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.xiang.egg.admin.api.dto.UserInfo;
import com.xiang.egg.admin.api.entity.SysUser;
import com.xiang.egg.common.core.constant.CommonConstants;
import com.xiang.egg.common.core.constant.SecurityConstants;
import com.xiang.egg.common.core.model.R;
import com.xiang.egg.common.core.model.RetOps;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xiang JiangCheng
 */
public interface PigUserDetailsService extends UserDetailsService {

    /**
     * 构建userdetails
     * @param result 用户信息
     * @return UserDetails
     */
    default UserDetails getUserDetails(R<UserInfo> result) {
        UserInfo info = RetOps.of(result).getData().orElseThrow(() -> new UsernameNotFoundException("用户不存在"));

        Set<String> dbAuthsSet = new HashSet<>();

        if (ArrayUtil.isNotEmpty(info.getRoles())) {
            // 获取角色
            Arrays.stream(info.getRoles()).forEach(role -> dbAuthsSet.add(SecurityConstants.ROLE + role));
            // 获取资源
            dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));

        }

        Collection<GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(dbAuthsSet.toArray(new String[0]));
        SysUser user = info.getSysUser();

        // 构造security用户
        return new PigUser(user.getUserId(), user.getDeptId(), user.getUsername(),
                SecurityConstants.BCRYPT + user.getPassword(), user.getPhone(), true, true, true,
                StrUtil.equals(user.getLockFlag(), CommonConstants.STATUS_NORMAL), authorities);
    }

    /**
     * 通过用户实体查询
     * @param pigUser user
     * @return
     */
    default UserDetails loadUserByUser(PigUser pigUser) {
        return this.loadUserByUsername(pigUser.getUsername());
    }

}
