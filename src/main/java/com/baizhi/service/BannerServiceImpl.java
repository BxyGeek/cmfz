package com.baizhi.service;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName BannerServiceImpl
 * @Description TODO ()
 * @Author buxy
 * @Date 2019/12/3 16:09
 * @Version 1.0
 **/
@Service("bannerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDAO bannerDAO;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Map<String, Object> selectAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        RowBounds rowBounds = new RowBounds((page - 1) * rows, rows);
        Banner banner = new Banner();
        List<Banner> banners = bannerDAO.selectByRowBounds(banner, rowBounds);
        int count = bannerDAO.selectCount(banner);
        int total = count % rows == 0 ? count / rows : count / rows + 1;
        map.put("rows", banners);
        map.put("page", page);
        map.put("total", total);
        map.put("records", count);
        return map;
    }

    @Override
    public String add(Banner banner) {
        String id = UUID.randomUUID().toString().replace("-", "");
        banner.setId(id);
        banner.setCreateDate(new Date());

        //C:\fakepath\1.jpg
        //int i1 = cover.lastIndexOf("\\");
        //String s = cover.substring(i1+1);
        //String newName = System.currentTimeMillis() + "----" +s;
        //banner.setCover(newName);

        System.out.println("添加之前的轮播图：       " + banner);
        int i = bannerDAO.insertSelective(banner);
        if (i != 1) {
            throw new RuntimeException("添加失败");
        }
        return id;
    }

    @Override
    public void del(Banner banner) {
        int i = bannerDAO.deleteByPrimaryKey(banner.getId());
        if (i != 1) {
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public void update(Banner banner) {
        int i = bannerDAO.updateByPrimaryKeySelective(banner);
        Banner banner1 = bannerDAO.selectByPrimaryKey(banner.getId());
        System.out.println("修改过后的轮播图：      " + banner1);
        if (i != 1) {
            throw new RuntimeException("修改失败");
        }
    }
}
