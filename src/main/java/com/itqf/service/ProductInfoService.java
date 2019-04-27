package com.itqf.service;

import com.itqf.dto.CartDto;
import com.itqf.entity.ProductInfo;
import com.itqf.utils.R;
import com.itqf.utils.ResultData;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

public interface ProductInfoService {

    public ResultData findByPage(int page, int size, String pageId,String search);

    //分页查询所有宠物
    ResultData findProductsByPage(Integer page, Integer size,Integer typeId,String search,int age,String animalSize);

    //分页查询所有食品，日用品
    ResultData findProductByPage(Integer page, Integer size, Integer typeId, String search, Integer type, Integer productType, Integer priceRange , Integer order);
    //分页查询所有食品，日用品
    ResultData findDailyByPage(Integer page, Integer size, Integer typeId, String search, Integer type, Integer productType, Integer priceRange , Integer order);
    //商城登录后首页
    //productType宠物具体类型  age成年幼年
    ResultData findDogByPage(@RequestParam(defaultValue = "1") String page,@RequestParam(defaultValue = "6") String size,@RequestParam String productType, @RequestParam Integer age, @RequestParam(defaultValue = "1") Integer categoryType);

    public R saveProductInfo(ProductInfo productInfo);

    public R findProductInfoById(Integer productId);

    public R  updateProductInfo(ProductInfo ProductInfo);

    public R deleteProductInfo(List<Integer> ids);
    //减库存
    void jianStock(List<CartDto> lists);

    //加库存
    void addStock(List<CartDto> lists);




}
