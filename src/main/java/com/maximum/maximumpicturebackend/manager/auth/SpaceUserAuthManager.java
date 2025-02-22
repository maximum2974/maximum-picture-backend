package com.maximum.maximumpicturebackend.manager.auth;


import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.maximum.maximumpicturebackend.manager.auth.model.SpaceUserAuthConfig;
import com.maximum.maximumpicturebackend.manager.auth.model.SpaceUserRole;
import com.maximum.maximumpicturebackend.service.SpaceUserService;
import com.maximum.maximumpicturebackend.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpaceUserAuthManager {
    @Resource
    private SpaceUserService spaceUserService;

    @Resource
    private UserService userService;

    public static final SpaceUserAuthConfig SPACE_USER_AUTH_CONFIG;

    static{
        String json = ResourceUtil.readUtf8Str("biz/spaceUserAuthConfig.json");
        SPACE_USER_AUTH_CONFIG = JSONUtil.toBean(json, SpaceUserAuthConfig.class);
    }

    /**
     * 根据角色获取权限列表
     * @param spaceUserRole
     * @return
     */
    public List<String> getPermissionsByRole(String spaceUserRole){
        if(StrUtil.isBlank(spaceUserRole)){
            return new ArrayList<>();
        }
        //找到匹配的角色
        SpaceUserRole role = SPACE_USER_AUTH_CONFIG.getRoles().stream()
                .filter(r -> spaceUserRole.equals(r.getKey()))
                .findFirst()
                .orElse(null);
        if(role == null){
            return new ArrayList<>();
        }
        return role.getPermissions();
    }
}
