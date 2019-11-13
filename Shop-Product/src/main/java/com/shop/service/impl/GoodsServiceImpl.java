package com.shop.service.impl;

import com.shop.dao.GoodsMapper;
import com.shop.domain.Goods;
import com.shop.domain.GoodsInfo;
import com.shop.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/9 16:55
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    //全查放进es中  进行检索查询
    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    @Override
    public GoodsInfo selectGoodsInfo(Integer goodsId) {
        return goodsMapper.selectGoodsInfo(goodsId);
    }
}
