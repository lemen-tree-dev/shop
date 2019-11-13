package com.shop.service;

import com.shop.domain.Goods;

import java.util.List;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/9 17:09
 */
public interface EsService {
    //将数据库中的数据放进es索引库
    public void putInEs();

    //向索引库中增加数据
    public void addInEs(Goods product);

    //更新索引库中的数据
    public void updateInEs(Goods product);

    //删除索引库中的数据
    public void delInEs(Integer _id);

    //查询
    public List<Goods> chaxun(String str);

    public List<Goods> search();

}
