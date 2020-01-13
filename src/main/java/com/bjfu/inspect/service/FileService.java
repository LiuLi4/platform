package com.bjfu.inspect.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String save(MultipartFile file, String name, String folder);
    boolean show();
    boolean delete(String name, int type);
}
