package com.itqf.controller;

import com.itqf.entity.ProductInfo;
import com.itqf.service.ProductInfoService;
import com.itqf.utils.R;
import com.itqf.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductInfoController {

    @Resource
    private ProductInfoService productInfoService;

    @RequestMapping("/findAll/{pageId}")
    public ResultData findAll(@PathVariable String pageId, @RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "6") int size ,
                              @RequestParam String search){
        return productInfoService.findByPage(page,size,pageId,search);
    }

    @RequestMapping("/add")
    public R add(ProductInfo productInfo){
        return productInfoService.saveProductInfo(productInfo);
    }
    //后台查单个
    @RequestMapping("/findById/{productId}")
    public R findProductInfoById(@PathVariable Integer productId ){
        return  productInfoService.findProductInfoById(productId);
    }
    //商城查商品详情
    @GetMapping("/findById")
    public R findProductById(@RequestParam String productId ){
        int i = Integer.parseInt(productId);
        return  productInfoService.findProductInfoById(i);
    }
    @RequestMapping("/update")
    public R update(ProductInfo productInfo){
        return productInfoService.updateProductInfo(productInfo);
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody List<Integer> ids){
        return productInfoService.deleteProductInfo(ids);
    }
}
