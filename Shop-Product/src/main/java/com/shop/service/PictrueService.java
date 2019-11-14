package com.shop.service;

import com.shop.domain.Pictrue;

import java.util.List;

/**
 * @author HeXiaoH
 * @date 2019/11/14 17:22
 */
public interface PictrueService {
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
    public void update(Pictrue pictrue);
}
