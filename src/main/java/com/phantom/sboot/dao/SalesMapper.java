package com.phantom.sboot.dao;

import com.phantom.sboot.entity.Sales;

import java.util.List;
import java.util.Map;

//@Mapper
public interface SalesMapper {

    List<Sales> getAreaSales(Sales sales);

    List<Sales> getAreaChildSales(Sales sales);

    List<Sales> getAreaModelSales(Sales sales);

    List<Sales> getModelSales(Sales sales);

    List<Sales> getModelAreaSales(Sales sales);

    List<Sales> getModelChildSales(Sales sales);

    List<Sales> getChartYear(Sales sales);

    List<Sales> getHotModelSales(Sales sales);

    List<Sales> getNewPhone(Sales sales);

    List<Sales> getNewPhoneSales(Map<String, Object> param);
}
