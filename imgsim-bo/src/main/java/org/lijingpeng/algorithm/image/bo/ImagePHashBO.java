package org.lijingpeng.algorithm.image.bo;
/**
 * Created by frank on 16/7/26.
 */
public interface ImagePHashBO {
    /**
     * 获取网络图片地址的pHash值
     * @param url:地址URL
     * @return String:10101...哈希值
     */
    public String getPHashFromURL(String url) throws Exception;

    /**
     * 获取网络图片地址的pHash值(十六进制)
     * @param url:地址URL
     * @return String:a5e...哈希值
     */
    public String getHexPHashFromURL(String url) throws Exception;

    /**
     * 获取两个图片的汉明距离
     * @param url1
     * @param url2
     * @return
     * @throws Exception
     */
    public Integer getImageSimilarityDistanceFromURL(String url1, String url2) throws Exception;

    /**
     * 获取两个图片的汉明距离(十六进制)
     * @param url1
     * @param url2
     * @return
     * @throws Exception
     */
    public Integer getImageHexSimilarityDistanceFromURL(String url1, String url2) throws Exception;
}
