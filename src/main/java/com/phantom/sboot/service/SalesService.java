package com.phantom.sboot.service;


import com.phantom.sboot.entity.Sales;

import java.util.List;
import java.util.Map;

public interface SalesService {

    /**
     * 获取各个国家的销售信息
     * @param sales
     * @return
     */
    List<Sales> getAreaSales(Sales sales);

    /**
     * 获取国家下面的代理商的销售信息
     * @param sales
     * @return
     */
    List<Sales> getAreaChildSales(Sales sales);

    /**
     * 获取代理商下面的机型销售信息
     * @param sales
     * @return
     */
    List<Sales> getAreaModelSales(Sales sales);

    /**
     * 获取机型销售信息
     * @param sales
     * @return
     */
    List<Sales> getModelSales(Sales sales);

    /**
     * 获取某个机型在各个国家销售信息
     * @param sales
     * @return
     */
    List<Sales> getModelAreaSales(Sales sales);

    /**
     * 获取某个机型在某个国家销售信息
     * @param sales
     * @return
     */
    List<Sales> getModelChildSales(Sales sales);

    /**
     * 获取国内国外十年的销售信息
     * @param sales
     * @return
     */
    List<Sales> getChartYear(Sales sales);

    /**
     * 获取热门Top10机型销售信息
     * @param sales
     * @return
     */
    List<Sales> getHotModelSales(Sales sales);

    /**
     * 获取年度的新机型信息
     * @param sales
     * @return
     */
    List<Sales> getNewPhone(Sales sales);

    /**
     * 获取指定机型的销售信息
     * @param param
     * @return
     */
    List<Sales> getNewPhoneSales(Map<String, Object> param);

}
