package com.ruoyi.novel.service.impl;

import com.ruoyi.novel.common.Constants;
import com.ruoyi.novel.service.UploadService;
import com.ruoyi.novel.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {
    //获取根路径

    private String dirPath = Constants.UPLOAD_PATH;

    private String bookPath = Constants.UPLOAD_BOOK_PATH;


    /**
     * 上传用户头像
     * @param file
     * @param request
     * @return
     */
    @Override
    public String uploadImg(MultipartFile file, HttpServletRequest request) {
        Boolean img = UploadUtil.checkImg(file);
        if (img) {
            String URL = UploadUtil.upload(file, request, dirPath);
            return URL;
        } else {
            return "请上传bmp/gif/jpg/png格式的图片";
        }
    }


    /**
     * 上传小说封面
     * @param file
     * @param request
     * @return
     */
    @Override
    public String uploadBookImg(MultipartFile file, HttpServletRequest request) {
        Boolean img = UploadUtil.checkImg(file);
        if (img) {
            String URL = UploadUtil.upload(file, request, bookPath);
            return URL;
        } else {
            return "请上传bmp/gif/jpg/png格式的图片";
        }
    }


    @Override
    public Boolean deleteImg(String imgURL) {

        return  UploadUtil.deleteFile(dirPath,imgURL);
    }
}

