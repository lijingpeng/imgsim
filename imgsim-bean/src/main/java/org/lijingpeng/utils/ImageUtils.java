package org.lijingpeng.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by frank on 16/7/26.
 */
public class ImageUtils {

    private static File file = null;

    /**
     * 获取image
     * @param infile
     * @return FileInputStream
     * @throws FileNotFoundException
     */
    public static FileInputStream getImageFromLocal(String infile) throws FileNotFoundException {
        FileInputStream inputImage = null;
        file = new File(infile);
        try {
            inputImage = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputImage;
    }

    public static InputStream getImageFromURL(String remoteURL) throws Exception {
        InputStream inputStream = null;
        try {
            URL url = new URL(remoteURL);
            URLConnection conn = url.openConnection();
            inputStream = conn.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputStream;
    }

    /**
     * 输出图片
     *
     * @param inputStream
     * @param path
     */
    public static void readBlob(FileInputStream inputStream, String path) throws FileNotFoundException, IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }
            inputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readImage(InputStream inputStream, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }
            inputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downLoadImage(String imgPath, String savePath){
        //测试地址，"http://m.1more.com/image/pic1_ok.jpg";
        BufferedReader reader = null;
        try {
            URL url = new URL(imgPath);
            URLConnection conn = url.openConnection();
            ImageUtils.readImage(conn.getInputStream(), savePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
