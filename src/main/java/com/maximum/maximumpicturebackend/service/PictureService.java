package com.maximum.maximumpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maximum.maximumpicturebackend.model.dto.picture.PictureQueryRequest;
import com.maximum.maximumpicturebackend.model.dto.picture.PictureReviewRequest;
import com.maximum.maximumpicturebackend.model.dto.picture.PictureUploadByBatchRequest;
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
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

    /**
     * 图片审核
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(
            PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser
    );

}
