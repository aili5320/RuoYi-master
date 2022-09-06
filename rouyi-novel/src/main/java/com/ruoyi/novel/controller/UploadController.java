package com.ruoyi.novel.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.exception.file.FileException;
import com.ruoyi.novel.service.UploadService;
import com.ruoyi.novel.utils.MyResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @Autowired
    MyResultMap resultMap;

    //    上传用户头像
    @PostMapping("/uploadImg")
    public String uploadImg(@RequestBody MultipartFile file, HttpServletRequest request) {
        String imgURL = uploadService.uploadImg(file, request);
        return imgURL;
    }


    //    上传用户头像
    @PostMapping("/uploadBookImg")
    public String uploadBookImg(@RequestBody MultipartFile file, HttpServletRequest request) {
        String imgURL = uploadService.uploadBookImg(file, request);
        return imgURL;
    }

}
