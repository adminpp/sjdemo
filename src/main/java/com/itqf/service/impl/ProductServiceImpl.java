package com.itqf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.dto.CartDto;
import com.itqf.entity.ProductInfo;
import com.itqf.entity.ProductInfoExample;
import com.itqf.mapper.ProductInfoMapper;
import com.itqf.service.ProductInfoService;
import com.itqf.utils.R;
import com.itqf.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoMapper productInfoMapper;
    //查询宠物
    @Override
    public ResultData findByPage(int page, int size, String pageId,String search) {

        PageHelper.startPage(page,size);
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();

        if("1".equals(pageId)){
            criteria.andCategoryTypeBetween(1,2);
        }else if("2".equals(pageId)){
            criteria.andCategoryTypeEqualTo(3);

        }else if("3".equals(pageId)){
            criteria.andCategoryTypeEqualTo(4);
        }
        if(!search.equals("")&&search!=null){
            criteria.andProductNameLike("%"+search+"%");
        }
        List<ProductInfo> list = productInfoMapper.selectByExample(example);

        PageInfo info = new PageInfo(list);

        long total = info.getTotal();
        List<ProductInfo> list1 = info.getList();

        ResultData resultData = new ResultData(total,list1);

        return resultData;

    }

    //分页查询所有食品
    //productType食品分类  priceRange价格区间  type宠物类型
    //typwId判断犬类 猫类
    //
    @Override
   public  ResultData findProductByPage(Integer page, Integer size, Integer typeId, String search, Integer type, Integer  productType, Integer priceRange , Integer order) {
        PageHelper.startPage(page, size);
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();
        if (!search.equals("")) {
            criteria.andProductNameLike("%" + search + "%");
        }
        if(order.equals(3)){
            example.setOrderByClause("product_price");
        }
        if(order.equals(4)){
            example.setOrderByClause("create_time");
        }
        if (priceRange.equals(1)) {
            BigDecimal a = new BigDecimal("0");
            BigDecimal b = new BigDecimal("50");
            criteria.andProductPriceBetween(a, b);
        }
        if (priceRange.equals(2)) {
            BigDecimal a = new BigDecimal("51");
            BigDecimal b = new BigDecimal("100");
            criteria.andProductPriceBetween(a, b);
        }
        if (priceRange.equals(3)) {
            BigDecimal a = new BigDecimal("101");
            BigDecimal b = new BigDecimal("200");
            criteria.andProductPriceBetween(a, b);
        }
        if (priceRange.equals(4)) {
            BigDecimal a = new BigDecimal("201");
            BigDecimal b = new BigDecimal("500");
            criteria.andProductPriceBetween(a, b);
        }
        criteria.andCategoryTypeEqualTo(type);
        StringBuffer stringBuffer = new StringBuffer();
        if (typeId == 2) {
            stringBuffer.append("犬类");
        }
        if (typeId == 3) {
            stringBuffer.append("猫类");
        }

        if (productType == 5) {
            stringBuffer.append("主食");
        }
        if (productType == 6) {
            stringBuffer.append("零食");
        }
        if (productType == 7) {
            stringBuffer.append("保健");
        }

        criteria.andProductTypeLike("%" + stringBuffer.toString() + "%");
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(example);
        ResultData resultData = new ResultData();
        PageInfo info = new PageInfo(productInfos);
        resultData.setRows(info.getList());
        resultData.setTotal(info.getTotal());
        return resultData;
    }

    //分页查询所有日用品
    //productType食品分类  priceRange价格区间  type宠物类型
    //typwId判断犬类 猫类
    //
    public ResultData findDailyByPage(Integer page, Integer size, Integer typeId, String search, Integer type, Integer productType, Integer priceRange , Integer order){
        PageHelper.startPage(page, size);
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();
        if (!search.equals("")) {
            criteria.andProductNameLike("%" + search + "%");
        }
        if (priceRange.equals(1)) {
            BigDecimal a = new BigDecimal("0");
            BigDecimal b = new BigDecimal("50");
            criteria.andProductPriceBetween(a, b);
        }
        if (priceRange.equals(2)) {
            BigDecimal a = new BigDecimal("51");
            BigDecimal b = new BigDecimal("100");
            criteria.andProductPriceBetween(a, b);
        }
        if (priceRange.equals(3)) {
            BigDecimal a = new BigDecimal("101");
            BigDecimal b = new BigDecimal("200");
            criteria.andProductPriceBetween(a, b);
        }
        if (priceRange.equals(4)) {
            BigDecimal a = new BigDecimal("201");
            BigDecimal b = new BigDecimal("500");
            criteria.andProductPriceBetween(a, b);
        }
        if(order.equals(3)){
            example.setOrderByClause("product_price");
        }
        if(order.equals(4)){
            example.setOrderByClause("create_time");
        }
        criteria.andCategoryTypeEqualTo(type);
        StringBuffer stringBuffer = new StringBuffer();
        if (typeId == 2) {
            stringBuffer.append("犬类");
        }
        if (typeId == 3) {
            stringBuffer.append("猫类");
        }

        if (productType == 5) {
            stringBuffer.append("服饰");
        }
        if (productType == 6) {
            stringBuffer.append("清洁");
        }
        if (productType == 7) {
            stringBuffer.append("玩具");
        }
        if(productType==8){
            stringBuffer.append("用具");
        }

        criteria.andProductTypeLike("%" + stringBuffer.toString() + "%");
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(example);
        ResultData resultData = new ResultData();
        PageInfo info = new PageInfo(productInfos);
        resultData.setRows(info.getList());
        resultData.setTotal(info.getTotal());
        return resultData;
    };
    //商城查询宠物
    @Override
    public ResultData findAnimalByPage(Integer page, Integer size, Integer typeId, String search, int age, String animalSize) {
        return null;
    }

    //商城登录后首页
    //（4张俩猫俩狗）
   public  ResultData findDog(){
       ProductInfoExample example = new ProductInfoExample();
       ProductInfoExample.Criteria criteria = example.createCriteria();
       ArrayList animals = new ArrayList();
       animals.add(505);
       animals.add(506);
       animals.add(507);
       animals.add(508);
       criteria.andProductIdIn(animals);
       List<ProductInfo> productInfos = productInfoMapper.selectByExample(example);
       ResultData resultData = new ResultData();
       resultData.setRows(productInfos);
       return resultData;
   };
    //登录后首页食品5张
    public  ResultData findDlFood(){
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();
        ArrayList foods = new ArrayList();
        foods.add(509);
        foods.add(510);
        foods.add(511);
        foods.add(512);
        foods.add(513);
        criteria.andProductIdIn(foods);
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(example);
        ResultData resultData = new ResultData();
        resultData.setRows(productInfos);
        return resultData;
    };
    //登录后首页用品4张
   public  ResultData findDetail(){
       ProductInfoExample example = new ProductInfoExample();
       ProductInfoExample.Criteria criteria = example.createCriteria();
       ArrayList deatils = new ArrayList();
       deatils.add(514);
       deatils.add(515);
       deatils.add(516);
       deatils.add(517);
       criteria.andProductIdIn(deatils);
       List<ProductInfo> productInfos = productInfoMapper.selectByExample(example);
       ResultData resultData = new ResultData();
       resultData.setRows(productInfos);
       return resultData;
   };

    @Override
    public R saveProductInfo(ProductInfo productInfo) {
        int i = productInfoMapper.insertSelective(productInfo);
        return i>0?R.ok():R.error("新增失败");
    }

    @Override
    public R findProductInfoById(Integer productId) {
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productId);
        return R.ok().put("productInfo",productInfo);
    }

    @Override
    public R updateProductInfo(ProductInfo productInfo) {
        int i = productInfoMapper.updateByPrimaryKeySelective(productInfo);
        if (i>0){
            return R.ok();
        }
        return R.error("修改失败");
    }

    @Override
    public R deleteProductInfo(List<Integer> ids) {
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();

        criteria.andProductIdIn(ids);

        int i = productInfoMapper.deleteByExample(example);
        if(i>0){
            return  R.ok();
        }
        return R.error("删除失败");
    }
    @Override
    public void jianStock(List<CartDto> lists) {
        for(CartDto cartDto:lists){
            ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(Integer.parseInt(cartDto.getProductId()));
            int num = productInfo.getProductStock()-cartDto.getProductQuantity();
            if(num<0){
                throw new RuntimeException("库存不足");
            }
            productInfo.setProductStock(num);
            productInfoMapper.updateByPrimaryKey(productInfo);
        }
    }

    @Override
    public void addStock(List<CartDto> lists) {
        for(CartDto cartDTO:lists){
            //根据商品id查询商品信息
            ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(Integer.parseInt(cartDTO.getProductId()));

            int num = productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(num);
            productInfoMapper.updateByPrimaryKey(productInfo);
        }
    }
    //分页查询所有宠物
    @Override
    public ResultData findProductsByPage(Integer page, Integer size,Integer typeId,String search,int age,String animalSize) {
        PageHelper.startPage(page,size);
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();
        if(typeId.equals(1)) {
            criteria.andCategoryTypeBetween(1,2);
        }else{
            criteria.andCategoryTypeEqualTo(typeId);
        }
        if(!search.equals("")&&search!=null){
            criteria.andProductNameLike("%"+search+"%");
        }
        if(age!=0){
            criteria.andProductAgeEqualTo(age);
        }
        if(!animalSize.equals("")&&animalSize!=null){
            criteria.andProductSizeEqualTo(animalSize);
        }

        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        PageInfo info = new PageInfo(list);
        ResultData resultData = new ResultData();
        long total = info.getTotal();
        List list1 = info.getList();
        resultData.setTotal(total);
        resultData.setRows(list1);
        return resultData;
    }


}
