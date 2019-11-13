package com.shop.service;

import com.shop.domain.Goods;
import com.shop.domain.GoodsInfo;

import java.util.List;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/9 16:54
 */
public interface GoodsService {

    //查询所有商品（Goods表）  放入es中进行检索
    public List<Goods> selectAll();

    //查询单个商品的详细信息（GoodsInfo + Goods + GITable中间表）
    public GoodsInfo selectGoodsInfo(Integer goodsId);
}
