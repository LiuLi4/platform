package com.bjfu.inspect.service.Impl;

import com.bjfu.inspect.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String save(MultipartFile file, String name, String folder) {
        String ans = null;
        String fileName = name;
        File dirFile = new File(folder);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        File localFile = new File(folder, String.valueOf(fileName));
        try{
            file.transferTo(localFile);
            ans = folder + fileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public boolean show() {
        return false;
    }

    @Override
    public boolean delete(String fileName, int type) {
        String folder = "";
        switch (type){
            case 1:
                folder = "alliance";
                break;
            case 2:
                folder = "data";
                break;
            case 3:
                folder = "human";
                break;
            case 4:
                folder = "land";
                break;
            case 5:
                folder = "project";
                break;
        }
        File localFile = new File(folder, String.valueOf(fileName));
        if (localFile.exists()){
            return localFile.delete();
        }
        return false;
    }
}
