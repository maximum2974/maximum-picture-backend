package com.maximum.maximumpicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchPictureByPictureRequest implements Serializable {
    /**
     * 图片id
     */
    private Long pictureId;
    private static final long serialVersionUID = 7441685914391910205L;
}
