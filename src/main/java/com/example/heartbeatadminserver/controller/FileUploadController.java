package com.example.heartbeatadminserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class FileUploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");

    @PostMapping("/admin/upload")
    public Map<String, Object> fileupload(MultipartFile file, HttpServletRequest req) {
        Map<String, Object> result = new HashMap<>();
        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith(".png")) {
            result.put("status", "error");
            result.put("msg", "文件类型需为png后结尾");
            return result;
        }
        String format = sdf.format(new Date());
        String realpath = req.getServletContext().getRealPath("/") + format;
        File folder = new File(realpath);
        if(!folder.exists()){
            folder.mkdir();
        }
        String newName = UUID.randomUUID().toString() + ".png";
        try {
            file.transferTo(new File(folder,newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + format + newName;
            result.put("status","success");
            result.put("url",url);
        } catch (IOException e) {
            result.put("status", "error");
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
