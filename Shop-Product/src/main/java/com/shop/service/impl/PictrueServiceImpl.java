package com.shop.service.impl;

import com.shop.config.ShopFanoutSender;
import com.shop.dao.PictrueMapper;
import com.shop.domain.Pictrue;
import com.shop.service.PictrueService;
import com.shop.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author HeXiaoH
 * @date 2019/11/14 17:23
 */
@Service
public class PictrueServiceImpl implements PictrueService {
    @Resource
    private PictrueMapper pictrueMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private ShopFanoutSender shopFanoutSender;


    /**
     * 查询轮播图
     * @return
     */
    @Override
    public List<Pictrue> selectAll() {
        List list = new ArrayList<>();
        Map map = redisUtils.hgetAll("picture");
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            String s = next.toString();
            String key = s.substring(0, s.indexOf("="));
            String value = s.substring(key.length()+1, s.length());
            Pictrue pictrue = new Pictrue();
            pictrue.setPictrueId(Integer.parseInt(key));
            pictrue.setPictrueUrl(value);
            list.add(pictrue);
            System.err.println(pictrue);
        }
        
        if(list!=null && list.size()!=0){
            return list;
        }

        List<Pictrue> list1 = pictrueMapper.selectAll();
        if(list1!=null && list1.size()!=0){
            for (Pictrue p: list1) {
                redisUtils.hset("picture",p.getPictrueId()+"",p.getPictrueUrl());
            }
        }else {
            //防止缓存穿透
            redisUtils.hset("picture","null","null");
            redisUtils.expire("picture",60*1000);
        }
        return list1;
    }


    /**
     * 修改轮播图片
     * @param pictrue
     * @return
     */
    @Override
    public void update(Pictrue pictrue) {
        shopFanoutSender.send(pictrue);
    }
}
