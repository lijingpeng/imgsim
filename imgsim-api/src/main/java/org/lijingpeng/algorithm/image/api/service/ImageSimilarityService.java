package org.lijingpeng.algorithm.image.api.service;

/**
 * Created by frank on 16/7/26.
 */
public interface ImageSimilarityService {
    /**
     * 从网络URL中获取图片hash值
     * @param url
     * @return
     * @throws Exception
     */
    public String getImagePHashFromURL(String url) throws Exception;

    /**
     * 从网络URL中获取图片hash值(十六进制)
     * @param url
     * @return
     * @throws Exception
     */
    public String getImageHexPHashFromURL(String url) throws Exception;

    /**
     * 获取两个网络图片的汉明距离
     * @param url1
     * @param url2
     * @return
     * @throws Exception
     */
    public Integer getImageSimilarityDistance(String url1, String url2) throws Exception;

    /**
     * 获取两个图片的汉明距离（十六进制）
     * @param url1
     * @param url2
     * @return
     * @throws Exception
     */
    public Integer getImageHexSimilarityDistance(String url1, String url2) throws Exception;
}
