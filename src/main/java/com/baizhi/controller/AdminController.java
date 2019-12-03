package com.baizhi.controller;

import com.baizhi.api.BaseAipService;
import com.baizhi.service.AdminService;
import com.baizhi.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName AdminController
 * @Description TODO ()
 * @Author buxy
 * @Date 2019/11/28 16:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public Map<String, Object> login(String username, String password, String code, HttpSession session) {
        Map<String, Object> map = null;
        try {
            map = adminService.login(username, password, code, session);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(BaseAipService.HTTP_RESP_MSG, e.getMessage());
        }
        System.out.println("响应code：        " + map.get("code"));
        return map;
    }

    @RequestMapping("imageCode")
    public void imageCode(HttpSession session, HttpServletResponse response) {
        try {
            String adminSessionCode = VerifyCodeUtil.generateVerifyCode(5);
            System.out.println("验证码：          " + adminSessionCode);
            session.setAttribute("adminSessionCode", adminSessionCode);
            BufferedImage image = VerifyCodeUtil.getImage(255, 80, adminSessionCode);
            response.setContentType("img/png");
            ImageIO.write(image, "png", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("验证码生成失败");
        }
    }


}
