package com.itqf.controller;

import com.itqf.service.ProductCategoryService;
import com.itqf.service.ProductInfoService;
import com.itqf.utils.ResultData;
import com.itqf.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Date: 2019/4/21 19:49
 */
//查询所有商品

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Resource
    private ProductInfoService productInfoService;

    @Resource
    private ProductCategoryService productCategoryService;
    //宠物展示
    @PostMapping("/list")
    public ResultVO productInfos(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size,
                                 @RequestParam(defaultValue = "3") int typeId,
                                 @RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "0") int age,
                                 @RequestParam (defaultValue = "")String animalSize,@RequestParam(defaultValue = "0") int productPrice){
        //分页展示商品
        ResultData products = productInfoService.findProductsByPage(page,size,typeId,search,age,animalSize);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
       resultVO.setMsg("成功");
        resultVO.setData(products);
        return resultVO;
    }
    //展示食品，日用品
    //Integer page, Integer size, Integer typeId, String search, Integer type,
    // String prodtcuType, Integer priceRange , Integer order
    //productType食品分类  priceRange价格区间  type宠物类型
    @RequestMapping(value = "/shop")
    public ResultVO productInfo(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size,
                                 @RequestParam(defaultValue = "3") int typeId,
                                 @RequestParam(defaultValue = "") String search,
                                @RequestParam(defaultValue = "3") int type,
                                 @RequestParam (defaultValue = "5")Integer productType,
                                @RequestParam(defaultValue = "0") int priceRange,Integer order){
        System.out.println(productType);
        System.out.println(priceRange);
        System.out.println(type);
        //分页展示商品
        ResultData products = productInfoService.findProductByPage(page,size,typeId,search,type,productType,priceRange,order);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(products);
        return resultVO;
    }

    @RequestMapping("/daily")
    public ResultVO productDaily(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size,
                                @RequestParam(defaultValue = "3") int typeId,
                                @RequestParam(defaultValue = "") String search,
                                @RequestParam(defaultValue = "4") int type,
                                @RequestParam (defaultValue = "5")Integer productType,
                                @RequestParam(defaultValue = "0") int priceRange,Integer order){
        System.out.println(productType);
        System.out.println(priceRange);
        System.out.println(typeId);
        //分页展示商品
        ResultData products = productInfoService.findDailyByPage(page,size,typeId,search,type,productType,priceRange,order);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(products);
        return resultVO;
    }




    //首页食品图
    @GetMapping("/homefood")
    public ResultVO productInfoFood(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size,
                                 @RequestParam(defaultValue = "3") int typeId,
                                 @RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "0") int age,
                                 @RequestParam (defaultValue = "")String animalSize,@RequestParam(defaultValue = "0") int productPrice){
        //分页展示商品
        ResultData products = productInfoService.findProductsByPage(page,size,typeId,search,age,animalSize);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(products);
        return resultVO;
    }
    //首页知宠图
    @GetMapping("/zc")
    public ResultVO productZc(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "6") int size,
                              @RequestParam(defaultValue = "5") int typeId,
                              @RequestParam(defaultValue = "知宠详情") String search, @RequestParam(defaultValue = "0") int age,
                              @RequestParam (defaultValue = "")String animalSize,@RequestParam(defaultValue = "0") int productPrice){
        //分页展示商品
        ResultData products = productInfoService.findProductsByPage(page,size,typeId,search,age,animalSize);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(products);
        return resultVO;
    }
    //知宠详情图
    @GetMapping("/zcxq")
    public ResultVO productZcXQ(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "6") int size,
                              @RequestParam(defaultValue = "3") int typeId,
                              @RequestParam(defaultValue = "知宠详情") String search, @RequestParam(defaultValue = "0") int age,
                              @RequestParam (defaultValue = "")String animalSize,@RequestParam(defaultValue = "0") int productPrice){
        //分页展示商品
        ResultData products = productInfoService.findProductsByPage(page,size,typeId,search,age,animalSize);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(products);
        return resultVO;
    }
    //首页零食小屋
    @GetMapping("/xw")
    public ResultVO productXu(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size,
                              @RequestParam(defaultValue = "6") int typeId,
                              @RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "0") int age,
                              @RequestParam (defaultValue = "")String animalSize,@RequestParam(defaultValue = "0") int productPrice){
        //分页展示商品
        ResultData products = productInfoService.findProductsByPage(page,size,typeId,search,age,animalSize);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(products);
        return resultVO;
    }
    //登录后首页筛选器



}
