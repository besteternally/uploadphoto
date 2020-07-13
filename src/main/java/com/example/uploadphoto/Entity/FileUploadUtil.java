package com.example.uploadphoto.Entity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;


/**

 * @Author：hyj
 * @Date: 2020/7/13 21:54
 */

/**
 * @ClassName FileUploadUtil
 * @Description TODO
 * @Author
 * @Date 2020/7/13 21:54
 * @Version 1.0
 **/
public class FileUploadUtil {
    public static String fileUploadPathUrl="D:\\svnproject\\wechatprintingPicture";

    /**
     * 图片读取存放获取路径
     *
     * @param file   文件
     * @param fileName 文件存放的目录名
     * @return
     */
    public static String saveImage(MultipartFile file, String fileName, HttpServletRequest requestFileUploadUtil) {
        long timestamp = new Date().getTime();//获取时间戳
        String realPath = fileUploadPathUrl;//项目路径
        String newFileName = timestamp + "" + file.getOriginalFilename(); //file.getOriginalFilename()是获取原始图片的拓展名，newfileName新的文件名字
        String path = realPath + "/" + fileName;
        String newPath = path + "/" + newFileName;////图片存放的位置路径
        File filePath = new File(path + "/");
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        if (!file.isEmpty()) {
            BufferedOutputStream out = null;
            try {
                out = new BufferedOutputStream(
                        new FileOutputStream(new File(newPath)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String url = requestFileUploadUtil.getScheme() + "://" + requestFileUploadUtil.getServerName() + ":" + requestFileUploadUtil.getServerPort() + requestFileUploadUtil.getContextPath() + "/" + fileName + "/" + newFileName;
        return url;
    }
}
