package com.runnersoftware.hot_pot_shop.controller;

import com.runnersoftware.hot_pot_shop.service.OssService;
import com.runnersoftware.hot_pot_shop.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/upload")
@RestController
public class UploadController {

    @Autowired
    private OssService ossService;

    @RequestMapping("")
    public R upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return R.ok().data("url", ossService.upload(multipartFile.getInputStream()));
    }

}
