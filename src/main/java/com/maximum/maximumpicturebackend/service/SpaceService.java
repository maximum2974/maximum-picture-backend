package com.maximum.maximumpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maximum.maximumpicturebackend.model.dto.space.SpaceAddRequest;
import com.maximum.maximumpicturebackend.model.dto.space.SpaceQueryRequest;
import com.maximum.maximumpicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maximum.maximumpicturebackend.model.entity.User;
import com.maximum.maximumpicturebackend.model.vo.space.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author maximum
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-02-09 14:51:53
*/
public interface SpaceService extends IService<Space> {
    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 创建空间
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 校验空间权限
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);
}
