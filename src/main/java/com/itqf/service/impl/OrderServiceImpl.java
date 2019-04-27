package com.itqf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.dto.CartDto;
import com.itqf.dto.OrderDTO;
import com.itqf.entity.*;
import com.itqf.enums.OrderStatusEnum;
import com.itqf.enums.PayStatus;
import com.itqf.enums.ResultEnum;
import com.itqf.mapper.OrderDetailMapper;
import com.itqf.mapper.OrderMasterMapper;
import com.itqf.mapper.ProductInfoMapper;
import com.itqf.service.OrderService;
import com.itqf.service.ProductInfoService;
import com.itqf.utils.IDUtils;
import com.itqf.utils.R;
import com.itqf.utils.ResultData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**********************************************
 _______________$$$$$$$$$_______________________
 ______________$$$$$$$$$$$$_____________________
 ______________$$$$$$$$$$$$$____________________
 _____________$$__$$$$$$$$$$$___________________
 ____________$$$__$$$$$$_$$$$$__________________
 ____________$$$_$$$$$$$___$$$$_________________
 ___________$$$__$$$$$$$$$$_$$$$________________
 __________$$$$__$$$$$$$$$$$_$$$$_______________
 ________$$$$$___$$$$$$$$$$$__$$$$$_____________
 _______$$$$$$___$$$_$$$$$$$$___$$$$$___________
 _______$$$$$___$$$___$$$$$$$$___$$$$$$_________
 ______$$$$$$___$$$__$$$$$$$$$$$___$$$$$$_______
 _____$$$$$$___$$$$_$$$$$$$$$$$$$$__$$$$$$______
 ____$$$$$$$__$$$$$$$$$$$$$$$$$$$$$_$$$$$$$_____
 ____$$$$$$$__$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$____
 ___$$$$$$$__$$$$$$_$$$$$$$$$$$$$$$$$_$$$$$$$___
 ___$$$$$$$__$$$$$$_$$$$$$_$$$$$$$$$___$$$$$$___
 ___$$$$$$$____$$__$$$$$$___$$$$$$_____$$$$$$___
 ___$$$$$$$________$$$$$$____$$$$$_____$$$$$____
 ____$$$$$$________$$$$$_____$$$$$_____$$$$_____
 _____$$$$$________$$$$______$$$$$_____$$$______
 ______$$$$$______;$$$________$$$______$________
 ________$$_______$$$$________$$$$______________ 
 ***********************************************
 ************* 葱官赐福，百无禁忌*****************
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private ProductInfoMapper productInfoMapper;
    @Resource
    private OrderMasterMapper orderMasterMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private ProductInfoService productInfoService;
    @Override
    public ResultData findOrderList( Integer limit, Integer offset) {
        PageHelper.offsetPage(offset,limit);
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        List<OrderMaster> orderMasters = orderMasterMapper.selectByExample(orderMasterExample);
        PageInfo pageInfo = new PageInfo(orderMasters);
        long total = pageInfo.getTotal();
        List list = pageInfo.getList();
        return new ResultData(total,list);
    }

    @Override
    public OrderDTO findOrderById(String orderId) {
        OrderMasterExample example = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderMaster> orderMasters = orderMasterMapper.selectByExample(example);
        if (orderMasters!=null&&orderMasters.size()!=0){
            OrderMaster orderMaster = orderMasters.get(0);
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(orderMaster,orderDTO);
            OrderDetailExample example1 = new OrderDetailExample();
            OrderDetailExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andOrderIdEqualTo(orderId);
            List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(example1);
            orderDTO.setOrderDetailList(orderDetails);
            return orderDTO;
        }
        return null;
    }

    @Override
    public R finishOrder(OrderDTO orderDTO) {

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        int num = orderMasterMapper.updateByPrimaryKeySelective(orderMaster);
        if (num>0){
            return R.ok().put("order",orderDTO);
        }
        return R.error();
    }
    @Override
    @Transactional
    public OrderDTO addOrder(OrderDTO orderDto) {
        //生成订单
        String orderId = IDUtils.genOrderId();
        List<CartDto> lists = new ArrayList<>();
        //计算订单应支付的总金额
        BigDecimal totalPrice = new BigDecimal(BigInteger.ZERO);
        List<OrderDetail> orderDetailList = orderDto.getOrderDetailList();
        for (OrderDetail orderDetail : orderDetailList) {
            //根据商品id查询上商品信息

            ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(Integer.parseInt(orderDetail.getProductId()));
            if(productInfo==null){
                throw new RuntimeException("商品不存在");
            }
            totalPrice = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(totalPrice);

            orderDetail.setDetailId(IDUtils.genOrderId());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            //像订单详情表提娜佳记录
            orderDetailMapper.insert(orderDetail);
            CartDto cartDto = new CartDto();
            cartDto.setProductId(orderDetail.getProductId());
            cartDto.setProductQuantity(orderDetail.getProductQuantity());
            lists.add(cartDto);
        }
        //向订单表添加记录
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(totalPrice);
        orderMaster.setPayStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        orderMasterMapper.insert(orderMaster);
        orderDto.setOrderId(orderId);
        //减库存
        productInfoService.jianStock(lists);
        return orderDto;
    }
    //订单详情
    @Override
    public OrderDTO findById(String openid, String orderId) {
        OrderMaster orderMaster = orderMasterMapper.selectByPrimaryKey(orderId);
        if(orderMaster==null){
            throw new RuntimeException("订单不存在");
        }
        OrderDetailExample example = new OrderDetailExample();
        OrderDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);

        List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(orderDetails)){
            throw new RuntimeException(ResultEnum.ORDER_DETAIL_NOT_EXISTS.getMessage());
        }
        OrderDTO orderDto = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDto);
        orderDto.setOrderDetailList(orderDetails);
        return orderDto;
    }
    //根据微信号分页查询订单
    @Override
    public ResultData findOrderList(String openid, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        if(openid!=null&&openid!=""){
            OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
            criteria.andBuyerOpenidEqualTo(openid);
        }
        List<OrderMaster> orderMasters = orderMasterMapper.selectByExample(orderMasterExample);
        List<OrderDTO> orderDtoList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasters) {
            OrderDTO orderDto = new OrderDTO();
            BeanUtils.copyProperties(orderMaster,orderDto);
            orderDtoList.add(orderDto);
        }
        PageInfo<OrderMaster> info = new PageInfo<>(orderMasters);
        ResultData resultData = new ResultData();
        resultData.setRows(info.getList());
        resultData.setTotal(info.getTotal());

        return resultData;
    }
    @Transactional
    @Override
    public OrderDTO cancelOrder(OrderDTO orderDto) {
        //判断订单是否为新订单
        if(!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW)){
            throw new RuntimeException(ResultEnum.ORDER_STATUS_ERROR.getMessage());
        }
        //修改订单状态
        orderDto.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMasterMapper.updateByPrimaryKey(orderMaster);
        //恢复库存
        List<OrderDetail> orderDetailList = orderDto.getOrderDetailList();
        if(CollectionUtils.isEmpty(orderDetailList)){
            throw new RuntimeException(ResultEnum.ORDER_DETAIL_NOT_EXISTS.getMessage());
        }
        //得到订单中的所有商品详情
        List<CartDto> cartDtoList = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailList) {
            CartDto cartDto = new CartDto();
            cartDto.setProductId(orderDetail.getProductId());
            cartDto.setProductQuantity(orderDetail.getProductQuantity());

            cartDtoList.add(cartDto);
        }
        //加库存
        productInfoService.addStock(cartDtoList);
        return orderDto;
    }

    @Transactional
    @Override
    public OrderDTO payOrder(OrderDTO orderDto) {
        //新订单才能支付
        if(!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW)){
            throw new RuntimeException(ResultEnum.ORDER_STATUS_ERROR.getMessage());
        }
        if(!orderDto.getPayStatus().equals(PayStatus.WAIT)){
            throw new RuntimeException(ResultEnum.ORDER_PAY_STATUS_ERROR.getMessage());
        }
        //修改支付状态为已支付
        orderDto.setOrderStatus(PayStatus.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        int num = orderMasterMapper.updateByPrimaryKey(orderMaster);
        if(num<0){
            throw new RuntimeException(ResultEnum.ORDER_PAY_UPDATE_ERROR.getMessage());
        }
        return orderDto;
    }
}
