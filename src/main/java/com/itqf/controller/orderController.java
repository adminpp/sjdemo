package com.itqf.controller;

import com.itqf.dto.OrderDTO;
import com.itqf.service.OrderService;
import com.itqf.utils.R;
import com.itqf.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@RestController
@RequestMapping("/seller/order")
public class orderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/list")
    public ResultData findOrder(@RequestParam(defaultValue = "3") Integer limit,
                                @RequestParam(defaultValue = "0") Integer offset){
        return orderService.findOrderList(limit, offset);
    }
    @RequestMapping("findOrderById/{orderid}")
    public OrderDTO findOrderById(@PathVariable("orderid") String orderid){
        return orderService.findOrderById(orderid);
    }
    @RequestMapping("/finishOrder/{orderid}")
    public R finishOrder(@PathVariable("orderid") String orderId){
        System.out.println(orderId);
        OrderDTO orderDTO = orderService.findOrderById(orderId);
        return orderService.finishOrder(orderDTO);
    }
}
