package org.lijingpeng.algorithm.image.bo.Impl;

import org.lijingpeng.utils.ImageUtils;
import org.lijingpeng.algorithm.image.bo.ImagePHashBO;

/**
 * Created by frank on 16/7/26.
 */
public class ImagePHashBOImpl implements ImagePHashBO {

    private ImagePHash imagePHash;

    @Override
    public String getPHashFromURL(String url) throws Exception {
        if (url == null) {
            throw new Exception("url can not be null");
        }
        return imagePHash.getHash(ImageUtils.getImageFromURL(url));
    }

    @Override
    public String getHexPHashFromURL(String url) throws Exception {
        if (url == null) {
            throw new Exception("url can not be null");
        }
        return imagePHash.getHexHash(ImageUtils.getImageFromURL(url));
    }

    @Override
    public Integer getImageSimilarityDistanceFromURL(String url1, String url2) throws Exception {
        if (url1 == null || url2 == null) throw new Exception("url can not be null");

        String hash1 = imagePHash.getHash(ImageUtils.getImageFromURL(url1));
        String hash2 = imagePHash.getHash(ImageUtils.getImageFromURL(url2));
        if (hash1 == null || hash2 == null) return null;

        return imagePHash.distance(hash1, hash2);
    }

    @Override
    public Integer getImageHexSimilarityDistanceFromURL(String url1, String url2) throws Exception {
        if (url1 == null || url2 == null) throw new Exception("url can not be null");

        String hash1 = imagePHash.getHexHash(ImageUtils.getImageFromURL(url1));
        String hash2 = imagePHash.getHexHash(ImageUtils.getImageFromURL(url2));
        if (hash1 == null || hash2 == null) return null;

        return imagePHash.distance(hash1, hash2);
    }

    public ImagePHash getImagePHash() {
        return imagePHash;
    }

    public void setImagePHash(ImagePHash imagePHash) {
        this.imagePHash = imagePHash;
    }

}
