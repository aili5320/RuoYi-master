package com.ruoyi.novel.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UploadService {

    String uploadImg( MultipartFile file, HttpServletRequest request);
    String uploadBookImg( MultipartFile file, HttpServletRequest request);



    Boolean deleteImg(String imgURL);
}

