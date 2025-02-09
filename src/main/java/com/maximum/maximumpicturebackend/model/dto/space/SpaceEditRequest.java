package com.maximum.maximumpicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpaceEditRequest implements Serializable {
    private static final long serialVersionUID = 5199514982473936423L;
    /**
     * 空间 id
     */
    private Long id;

    /**
     * 空间名称
     */
    private String spaceName;
}
