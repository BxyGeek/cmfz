package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BannerController
 * @Description TODO ()
 * @Author buxy
 * @Date 2019/12/3 16:17
 * @Version 1.0
 **/
@RestController
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;


    @RequestMapping("selectAll")
    public Map<String, Object> selectAll(Integer page, Integer rows) {
        Map<String, Object> map = null;
        try {
            map = bannerService.selectAll(page, rows);
            map.put("code", 200);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 500);
            map.put("msg", "查询失败");
        }
        return map;
    }

    @RequestMapping("edit")
    public Map<String, Object> edit(String oper, Banner banner) {
        Map<String, Object> map = new HashMap<>(16);
        if ("add".equals(oper)) {
            try {
                String id = bannerService.add(banner);
                map.put("code", 200);
                map.put("data", id);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("code", 500);
                map.put("msg", e.getMessage());
            }
        }
        if ("edit".equals(oper)) {
            try {
                bannerService.update(banner);
                map.put("code", 200);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("code", 500);
                map.put("msg", e.getMessage());
            }
        }
        if ("del".equals(oper)) {
            try {
                bannerService.del(banner);
                map.put("code", 200);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("code", 500);
                map.put("msg", e.getMessage());
            }
        }
        return map;
    }

    @RequestMapping("upload")
    public void upload(String id, MultipartFile cover, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/statics/images/");
        File file = new File(realPath, cover.getOriginalFilename());
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            cover.transferTo(file);
            System.out.println("文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传失败");
        }
        Banner banner = new Banner();
        banner.setId(id);
        banner.setCover(cover.getOriginalFilename());
        bannerService.update(banner);
    }


}
