package com.itqf.controller;/*
 *　　　　　　　　┏┓　　　┏┓+ +
 *　　　　　　　┏┛┻━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　　┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████- + + + +
 *　　　　　　　┃　　　　　　　┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　　┃ + +
 *　　　　　　　┗━┓　　　┏━┛
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃ + + + +
 *　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　　┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 *　　　　　　　　　　┃┫┫　┃┫┫
 *　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

import com.itqf.entity.Provider;
import com.itqf.service.ProviderService;
import com.itqf.utils.R;
import com.itqf.utils.ResultData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProviderController {

    @Resource
    private ProviderService providerService;

    @RequestMapping("/findAllProvider")
    public ResultData findAllProvider(){
        return providerService.findByPage(3,0);
    }

    @RequestMapping("/addProvider")
    public R addProvider(Provider provider){
        return providerService.saveProvider(provider);
    }

    @RequestMapping("/findProviderById/{providerId}")//
    public R findProviderById(@PathVariable Integer providerId){
        return  providerService.findProviderById(providerId);
    }

    @RequestMapping("/updateProvider")
    public R updateProvider(Provider provider){
        return providerService.updateProvider(provider);
    }

    @RequestMapping("/deleteProvider")
    public R deleteProvider(@RequestBody List<Integer> ids){
        return providerService.deleteProvider(ids);
    }
}
