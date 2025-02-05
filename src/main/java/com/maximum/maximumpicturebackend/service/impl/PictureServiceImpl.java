package com.maximum.maximumpicturebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maximum.maximumpicturebackend.model.entity.Picture;
import com.maximum.maximumpicturebackend.service.PictureService;
import com.maximum.maximumpicturebackend.manager.PictureMapper;
import org.springframework.stereotype.Service;

/**
* @author maximum
* @description 针对表【picture(图片)】的数据库操作Service实现
* @createDate 2025-02-05 17:37:22
*/
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture>
    implements PictureService{

}




