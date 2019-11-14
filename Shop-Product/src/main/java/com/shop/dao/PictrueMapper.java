package com.shop.dao;

import com.shop.domain.Pictrue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictrueMapper {

    /**
     * 查询轮播图
     * @return
     */
    public List<Pictrue> selectAll();

    /**
     * 修改轮播图
     * @param pictrue
     * @return
     */
    public int update(Pictrue pictrue);
}