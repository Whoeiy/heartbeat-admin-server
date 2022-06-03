package com.example.heartbeatadminserver.controller;

import com.example.heartbeatadminserver.util.HeartBeatUtils;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/admin/upload")
public class FileUploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
    @Value("${file.server_path}")   // 服务器地址
//    @Value("${file.local_path}")
    private String path;

    @PostMapping("/file")
    @ApiOperation("单个文件上传")
    public Result uploadFile(HttpServletRequest req, @RequestParam("file") MultipartFile file, int adminId) {
        if (file.isEmpty()) {
            return ResultGenerator.genFailResult("文件不能为空");
        }
        String originalName = file.getOriginalFilename();
        if (!(originalName.endsWith(".png") || originalName.endsWith(".jpeg") || originalName.endsWith(".jpg"))){
            return ResultGenerator.genFailResult("上传文件失败,文件格式不支持");
        }
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        String fileName = UUID.randomUUID().toString() + originalName.substring(originalName.lastIndexOf("."));
        File dest = new File(path, fileName);
        String temp = "";
        try {
            file.transferTo(dest);
            temp += HeartBeatUtils.getHost(new URI(req.getRequestURL() + "")) + "/upload/" + fileName;
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("上传文件失败");
        }
        return ResultGenerator.genSuccessResultData(temp);
    }
    @PostMapping("/files")
    @ApiOperation("多个文件上传")
    public Result uploadFiles(HttpServletRequest req, HttpServletResponse res, int adminId) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) req).getFiles("file");
        if( files == null || files.size() == 0) {
            return ResultGenerator.genFailResult("文件不能为空");
        }
        File file1 = new File(path);
        String temp = "";
        if (!file1.exists()) {
            file1.mkdirs();
        }
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            String originalName = file.getOriginalFilename();
            if (!(originalName.endsWith(".png") || originalName.endsWith(".jpeg") || originalName.endsWith(".jpg"))){
                return ResultGenerator.genFailResult("上传第" + i + "个文件失败," + "文件格式不支持");
            }
            if(file.isEmpty()) {
                return ResultGenerator.genFailResult("上传第" + i + "个文件失败");
            }
            String fileName = UUID.randomUUID().toString() + originalName.substring(originalName.lastIndexOf("."));
            File dest = new File(path, fileName);
            try {
                file.transferTo(dest);
                temp += HeartBeatUtils.getHost(new URI(req.getRequestURL() + "")) + "/upload/" + fileName + ",";
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                return ResultGenerator.genFailResult("上传第" + (i + 1) + "文件失败");
            }
        }
        return ResultGenerator.genSuccessResultData(temp.substring(0, temp.length() - 1));
    }
}
