package com.baizhi.service;

import com.baizhi.api.BaseAipService;
import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO ()
 * @Author buxy
 * @Date 2019/11/28 16:19
 * @Version 1.0
 **/
@Service(value = "adminService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Map<String, Object> login(String username, String password, String userCode, HttpSession session) {
        System.out.println("==========***code  is  :  " + userCode);
        if ("".equals(userCode)) {
            System.out.println("==========**********===========code  is  :  " + userCode);
            userCode = null;
        }
        try {
            if (userCode != null) {
                String code = userCode.toLowerCase();
                String sessionCode = (String) session.getAttribute("adminSessionCode");
                String s1 = sessionCode.toLowerCase();
                if (code.equals(s1)) {
                    Admin admin = adminDAO.login(username);
                    if (admin != null) {
                        if (admin.getPassword().equals(password)) {
                            session.setAttribute("nickname", admin.getNickname());
                            return BaseAipService.setRestltSuccessDataMsg("登陆成功", admin);
                        }
                        return BaseAipService.setRestltErrorMsg("密码错误");
                    }
                    return BaseAipService.setRestltErrorMsg("用户不存在");
                }
                return BaseAipService.setRestltErrorMsg("验证码错误");
            }
            return BaseAipService.setRestltErrorMsg("验证码不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("<font style:'color:red'>内部异常 请稍后重试</font>     ");
        }
    }


}