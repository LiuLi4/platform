package com.bjfu.inspect.controller.app;

import com.bjfu.inspect.common.Base64Util;
import com.bjfu.inspect.common.Log;
import com.bjfu.inspect.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@RequestMapping("/api/file")
@RestController
@CrossOrigin
public class FileApiController {
    @Autowired
    private FileService fileService;

    @Value("${location.img}")
    private String folder;
    @Value("${location.imgPath}")
    private String imgPath;

    @RequestMapping("/img")
    public String uploadImg(@RequestParam(value = "img") MultipartFile file, @RequestParam(value = "type")int type) {
        String fileName = file.getOriginalFilename();
        //映射通知类型
        String typeName = "";
        switch (type){
            case 1:
                typeName = "alliance";
                break;
            case 2:
                typeName = "data";
                break;
            case 3:
                typeName = "human";
                break;
            case 4:
                typeName = "land";
                break;
            case 5:
                typeName = "project";
                break;
        }
        if(fileName != null){
            String folder1 = folder + typeName + File.separator;
            String imgPath1 = imgPath + typeName + "/";
            String savePath = fileService.save(file, fileName, folder1);
            // log
            Log.info(this.getClass(), "图片:" + file.getOriginalFilename() + "\t存储于:" + savePath + "\t映射为:" + imgPath1 + fileName);
            return imgPath1 + fileName;
        }
        return "-1";
    }

    @RequestMapping("download")
    public String downloadImg(@RequestParam(value = "dir") String dir) {
        String ans = null;
        if(dir != null && !dir.equals("")){
            File file = new File(dir);
            if(file.exists()){
                ans = "data:image/png;base64," + Base64Util.img2Base64(file);
            }
        }
        return ans;
    }
}
