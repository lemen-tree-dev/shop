package com.shop.controller;

import com.shop.domain.Pictrue;
import com.shop.service.PictrueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author HeXiaoH
 * @date 2019/11/14 18:52
 */
@Controller
public class PictrueController {
    @Autowired
    private PictrueService pictrueService;

    /**
     * 查询轮播图
     * @return
     */
    @RequestMapping("/queryLBT")
    @ResponseBody
    public List<Pictrue> queryLBT(){
        return pictrueService.selectAll();
    }

    /**
     * 修改轮播图片
     * @param pictrue
     */
    @RequestMapping("/updateLBT")
    @ResponseBody
    public void updateLBT(Pictrue pictrue){
        pictrueService.update(pictrue);
    }
}
