package com.itqf.service.impl;/*
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.entity.Provider;
import com.itqf.entity.ProviderExample;
import com.itqf.mapper.ProviderMapper;
import com.itqf.service.ProviderService;
import com.itqf.utils.R;
import com.itqf.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProviderServiceImpl implements ProviderService {

    @Resource
    private ProviderMapper providerMapper;

    @Override
    public ResultData findByPage(int limit, int offset) {
        /**
         * @param offSet 数据库的起始记录
         * @param limit 每页显示行数
         */
        PageHelper.offsetPage(offset,limit);
        ProviderExample example = new ProviderExample();
        ProviderExample.Criteria criteria = example.createCriteria();

        List<Provider> list = providerMapper.selectByExample(example);

        PageInfo info = new PageInfo(list);

        long total = info.getTotal();
        List<Provider> list1 = info.getList();

        ResultData resultData = new ResultData(total,list1);

        return resultData;
    }

    @Override
    public R saveProvider(Provider provider) {

        int i = providerMapper.insertSelective(provider);
        return i>0?R.ok():R.error("新增失败");
    }

    @Override
    public R findProviderById(Integer providerId) {

        Provider provider = providerMapper.selectByPrimaryKey(providerId);
        return R.ok().put("provider",provider);
    }

    @Override
    public R updateProvider(Provider provider) {

        int i = providerMapper.updateByPrimaryKeySelective(provider);
        if (i>0){
            return R.ok();
        }
        return R.error("修改失败");
    }

    @Override
    public R deleteProvider(List<Integer> ids) {

        ProviderExample example = new ProviderExample();
        ProviderExample.Criteria criteria = example.createCriteria();

        criteria.andIdIn(ids);

        int i = providerMapper.deleteByExample(example);
        if(i>0){
            return  R.ok();
        }
        return R.error("删除失败");
    }
}
