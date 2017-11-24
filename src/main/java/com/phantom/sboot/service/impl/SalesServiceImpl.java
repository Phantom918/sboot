package com.phantom.sboot.service.impl;

import com.phantom.sboot.config.DsConfig.DS;
import com.phantom.sboot.dao.SalesMapper;
import com.phantom.sboot.entity.Sales;
import com.phantom.sboot.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesMapper salesMapper;

    @Override
    @Cacheable(value = "wxCache")
    public List<Sales> getAreaSales(Sales sales) {
        return removeEmpty(salesMapper.getAreaSales(sales));
    }

    @Override
    @DS(value = "ds2")
    @Cacheable(value = "wxCache")
    public List<Sales> getAreaChildSales(Sales sales) {
        return salesMapper.getAreaChildSales(sales);
    }

    @Override
    @Cacheable(value = "wxCache")
    public List<Sales> getAreaModelSales(Sales sales) {
        return salesMapper.getAreaModelSales(sales);
    }


    @Override
    @Cacheable(value = "wxCache")
    public List<Sales> getModelSales(Sales sales) {
        return salesMapper.getModelSales(sales);
    }

    @Override
    @Cacheable(value = "wxCache")
    public List<Sales> getModelAreaSales(Sales sales) {
        return removeEmpty(salesMapper.getModelAreaSales(sales));
    }

    @Override
    @Cacheable(value = "wxCache")
    public List<Sales> getModelChildSales(Sales sales) {
        return salesMapper.getModelChildSales(sales);
    }

    @Override
    @Cacheable(value = "wxCache")
    public List<Sales> getChartYear(Sales sales) {
        return salesMapper.getChartYear(sales);
    }

    @Override
    @Cacheable(value = "wxCache", key="#sales.startDate + #sales.endDate + #sales.queryType")
    public List<Sales> getHotModelSales(Sales sales) {
        return salesMapper.getHotModelSales(sales);
    }

    /**
     * 去除空数据
     * @param sales
     * @return
     */
    private static  List<Sales> removeEmpty(List<Sales> sales) {
        List<Sales> temp = sales;
        if (sales !=null && sales.size() > 0) {
            for (int i=0; i<sales.size(); i++) {
                Sales sa = sales.get(i);
                if (sa.getSend() == null && sa.getSell() == null && sa.getRepair() == null) {
                    temp.remove(i);
                }
            }
        }

        return temp;
    }

    @Override
    @Cacheable(value = "wxCache")
    public List<Sales> getNewPhone(Sales sales) {
        return salesMapper.getNewPhone(sales);
    }

    @Override
    @Cacheable(value = "wxCache")
    public List<Sales> getNewPhoneSales(Map<String, Object> param) {
        return salesMapper.getNewPhoneSales(param);
    }


}
