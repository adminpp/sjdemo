package com.itqf.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itqf.dto.OrderDTO;
import com.itqf.entity.OrderDetail;
import com.itqf.enums.ResultEnum;
import com.itqf.form.OrderForm;
import com.itqf.service.OrderService;
import com.itqf.utils.ResultData;
import com.itqf.vo.ResultVO;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2019/4/23 18:42
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
@Resource
    private OrderService orderService;
//生成订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> createOrder(@Valid OrderForm orderForm , BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
       }
       //controller得到表单提交的数据
        //调用service向订单表中添加记录，向订详情表中添加记录
        //需要把订单数据和商品数据传给OrderService OrderDto
        //把orderForm中的数据转换成OrderDto
        OrderDTO orderDto = new OrderDTO();
       orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        //订单中的商品得到是json字符串需要还原成Llist
        List<OrderDetail> orderDetails = new ArrayList<>();
        try{
            Gson gson = new Gson();
            orderDetails = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>() {
            }.getType());
            orderDto.setOrderDetailList(orderDetails);
        }catch(Exception e){
            throw new RuntimeException(ResultEnum.PARAM_ERROR.getMessage());
        }
        //判断是否有商品
        if(CollectionUtils.isEmpty(orderDetails)){
            throw new RuntimeException(ResultEnum.CART_ERROR.getMessage());
        }
        orderDto.setOrderDetailList(orderDetails);
        OrderDTO orderDtoo = orderService.addOrder(orderDto);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderDtoo.getBuyerOpenid());
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(map);
        resultVO.setMsg("成功");
        return resultVO;
    }
    //订单列表
    @PostMapping("/list")
    public  ResultVO<List<OrderDTO>> findOrders(@RequestParam("openid") String openid, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "2") Integer size){
        if(StringUtils.isEmpty(openid)){
            throw new RuntimeException(ResultEnum.OPENID_NULL.getMessage());
        }
        ResultData resultDate = orderService.findOrderList(openid,page,size);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(resultDate.getRows());
        return resultVO;
    }
    //订单详情
    @PostMapping("/detail")
    public ResultVO<OrderDTO> findById(@RequestParam String openid,@RequestParam String orderId){
    OrderDTO orderDto = orderService.findById(openid,orderId);
         if(orderDto==null){
            throw new RuntimeException(ResultEnum.ORDER_NOT_EXISTS.getMessage());
        }
        ResultVO resultVO = new ResultVO();
         resultVO.setCode(0);
         resultVO.setMsg("成功");
         resultVO.setData(orderDto);
        return resultVO;
    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancelOrder(String openid,String orderId){
        //得到内被取消的订单对象
        OrderDTO orderDto = orderService.findById(openid,orderId);
        if(orderDto==null){
            throw new RuntimeException(ResultEnum.ORDER_NOT_EXISTS.getMessage());
        }
        if(!orderDto.getBuyerOpenid().equals(openid)){
            throw new RuntimeException(ResultEnum.ORDER_OWNER_ERROR.getMessage());
        }
        orderService.cancelOrder(orderDto);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(null);
        return resultVO;
    }
}
