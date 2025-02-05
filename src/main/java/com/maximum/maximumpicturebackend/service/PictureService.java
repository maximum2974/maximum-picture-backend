package com.maximum.maximumpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maximum.maximumpicturebackend.model.dto.picture.PictureQueryRequest;
import com.maximum.maximumpicturebackend.model.dto.picture.PictureUploadRequest;
import com.maximum.maximumpicturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maximum.maximumpicturebackend.model.entity.User;
import com.maximum.maximumpicturebackend.model.vo.picture.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author maximum
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-02-05 17:37:22
*/
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);
}
