package com.example.uploadphoto.Controller;/**
 * @Author：hyj
 * @Date: 2020/7/13 21:50
 */

import com.example.uploadphoto.Entity.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName photoUploadController
 * @Description TODO
 * @Author hyj
 * @Date 2020/7/13 21:50
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/test")
public class photoUploadController {
    @RequestMapping(value = "/index")
     public String index(Model model){
        List<String> urlList=new ArrayList<>();
        urlList.add("/微信图片_20200607110749.jpg");
        urlList.add("/微信图片_20200607110749.jpg");
        model.addAttribute("data",urlList);
         return "index";
     }

    @RequestMapping(value = "/uploadImg")
    @ResponseBody
    public Map<String,Object> uploadImg(MultipartFile file, HttpServletRequest request){
        Map<String,Object> data = new HashMap<>();
        String url = "";
        if (!file.isEmpty()){
            url = FileUploadUtil.saveImage(file,"orderVoucher",request);
        }
        data.put("url",url);
        return data;
    }
}
