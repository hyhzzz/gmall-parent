package com.atguigu.gmall.product.conntroller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author coderhyh
 * @create 2022-09-18 7:56
 */

@RestController
@RequestMapping("/admin/product")
@Slf4j
public class FileController {


    @Autowired
    FileService fileService;

    @PostMapping("/fileUpload")
    public Result upload(HttpServletRequest request,
                         @RequestPart("file") MultipartFile file) throws Exception {

        String url = fileService.upload(file);

        return Result.ok(url);
    }
}
