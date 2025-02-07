package com.maximum.maximumpicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureUploadByBatchRequest implements Serializable {
    private static final long serialVersionUID = 6142914327793865718L;
    /**
     * 搜索词
     */
    private String searchText;

    /**
     * 抓取数量
     */
    private Integer count = 10;

    /**
     * 名称前缀
     */
    private String namePrefix;


}
