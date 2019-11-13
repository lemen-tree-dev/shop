package com.shop.controller;

import com.shop.domain.Goods;
import com.shop.domain.GoodsInfo;
import com.shop.service.EsService;
import com.shop.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/9 17:35
 */
@Controller
public class GoodController {
    @Resource
    private EsService esService;
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/chaxun")
    @ResponseBody
    public List<Goods> chaxun(@RequestParam("str") String str){
        if(!str.equals("全查")){
            List<Goods> list=esService.chaxun(str);
            if(list!=null){
                return list;
            }else{
                esService.putInEs();
                return null;
            }
        }else {
            return esService.search();
        }
    }
    //对Es中数据的增删改查
    @RequestMapping("/put")
    @ResponseBody
    public  void put(){
        esService.putInEs();
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(@RequestBody Goods goods){
        esService.addInEs(goods);
    }

    @RequestMapping("/del")
    @ResponseBody
    public void  del(@RequestParam("_id")Integer _id){
        esService.delInEs(_id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public void update(@RequestBody Goods goods){
        esService.updateInEs(goods);
    }

    /**
     * 商品详情查询
     */

    @RequestMapping("/getGoodsInfo")
    public GoodsInfo selectGoodsInfo(@RequestParam("goodsId")Integer goodsId){
        return goodsService.selectGoodsInfo(goodsId);
    }

    //查询所有商品（后台）
    @RequestMapping("/selectAll")
    public List<Goods> selectAll(){
        return goodsService.selectAll();
    }

    /**
     *首页
     */
    @RequestMapping("/welcome")
    public String Welcome(){
        return "index";
    }
}
