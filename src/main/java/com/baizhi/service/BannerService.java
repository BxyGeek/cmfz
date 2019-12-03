package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.Map;

/**
 * @ClassName BannerService
 * @Description TODO ()
 * @Author buxy
 * @Date 2019/12/3 16:08
 * @Version 1.0
 **/
public interface BannerService {
    Map<String, Object> selectAll(Integer page, Integer rows);

    String add(Banner banner);

    void del(Banner banner);

    void update(Banner banner);

}
