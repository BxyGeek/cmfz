package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName BannerDAO
 * @Description TODO ()
 * @Author buxy
 * @Date 2019/12/3 16:07
 * @Version 1.0
 **/
@Repository
public interface BannerDAO extends Mapper<Banner> {
}
