package org.lijingpeng.algorithm.image.api.service.impl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lijingpeng.algorithm.image.api.service.ImageSimilarityService;
import org.lijingpeng.algorithm.image.bo.ImagePHashBO;

/**
 * Created by frank on 16/7/26.
 */
public class ImageSimilarityServiceImpl implements ImageSimilarityService {

    private final Log log = LogFactory.getLog(this.getClass());
    ImagePHashBO imagePHashBO;

    @Override
    public String getImagePHashFromURL(String url) throws Exception {
        if (url == null) {
            log.error("url can not be null");
            return null;
        }
        return imagePHashBO.getPHashFromURL(url);
    }

    @Override
    public String getImageHexPHashFromURL(String url) throws Exception {
        if (url == null) {
            log.error("url can not be null");
            return null;
        }
        return imagePHashBO.getHexPHashFromURL(url);
    }

    @Override
    public Integer getImageSimilarityDistance(String url1, String url2) throws Exception {
        if (url1 == null || url2 == null) {
            log.error("url can not be null");
            return null;
        }
        return imagePHashBO.getImageSimilarityDistanceFromURL(url1, url2);
    }

    @Override
    public Integer getImageHexSimilarityDistance(String url1, String url2) throws Exception {
        if (url1 == null || url2 == null) {
            log.error("url can not be null");
            return null;
        }
        return imagePHashBO.getImageHexSimilarityDistanceFromURL(url1, url2);
    }

    public ImagePHashBO getImagePHashBO() {
        return imagePHashBO;
    }

    public void setImagePHashBO(ImagePHashBO imagePHashBO) {
        this.imagePHashBO = imagePHashBO;
    }
}
