package com.maximum.maximumpicturebackend.api.imagesearch;

import com.maximum.maximumpicturebackend.api.imagesearch.model.ImageSearchResult;
import com.maximum.maximumpicturebackend.api.imagesearch.sub.GetImageFirstUrlApi;
import com.maximum.maximumpicturebackend.api.imagesearch.sub.GetImageListApi;
import com.maximum.maximumpicturebackend.api.imagesearch.sub.GetImagePageUrlApi;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ImageSearchApiFacade {

    /**
     * 搜索图片
     * @param imageUrl
     * @return
     */
    public static List<ImageSearchResult> searchImage(String imageUrl){
        String imagePaperUrl = GetImagePageUrlApi.getImagePageUrl(imageUrl);
        String imageFirstUrl = GetImageFirstUrlApi.getImageFirstUrl(imagePaperUrl);
        List<ImageSearchResult> imageList = GetImageListApi.getImageList(imageFirstUrl);
        return imageList;
    }

    public static void main(String[] args) {
        String imageUrl = "https://avatars.githubusercontent.com/maximum2974";
        List<ImageSearchResult> resultList = searchImage(imageUrl);
        System.out.println("结果列表" + resultList);
    }
}
