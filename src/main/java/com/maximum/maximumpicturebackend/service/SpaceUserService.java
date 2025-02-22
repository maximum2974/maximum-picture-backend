package com.maximum.maximumpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maximum.maximumpicturebackend.model.dto.spaceuser.SpaceUserAddRequest;
import com.maximum.maximumpicturebackend.model.dto.spaceuser.SpaceUserQueryRequest;
import com.maximum.maximumpicturebackend.model.entity.SpaceUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maximum.maximumpicturebackend.model.vo.spaceuser.SpaceUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author maximum
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2025-02-22 18:24:16
*/
public interface SpaceUserService extends IService<SpaceUser> {

    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);

    void validSpaceUser(SpaceUser spaceUser, boolean add);

    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);

    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser, HttpServletRequest request);

    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);
}
