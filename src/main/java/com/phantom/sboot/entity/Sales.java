package com.phantom.sboot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Sales implements Serializable{

    private Integer regionId;// 区域id

    private String regionName;// 区域名称

    private Integer modelId;// 机型id

    private String modelName;// 机型名称

    private Integer send;// 发货量

    private Integer sell;// 销售量

    private Integer act;// 激活量

    private Integer repair;// 维修量

    private Date date; // 日期

    private String startDate; // 开始日期(yyyy-MM-dd)

    private String endDate; // 结束日期(yyyy-MM-dd)

    private Integer time;// 时间

    private Integer page; // 页码

    private Integer pageSize;// 每页记录数

    private String overSea; // 是否国外( y:是 n:否 )

    private String queryType;// 查询类型( m:机型查询 hot:热门机型查询)

    private String chartType;// 图标查询类型( y:年度类型 m:月度类型 s:季度类型 )

    private String countryType;// 查询类型( c:国内 f:国外 a:国内与国外 )

    private  String phoneType;// 需要查询的机型（多个机型名称用英文分号[;]隔开）

    private Integer phone0;// 机型0

    private Integer phone1;

    private Integer phone2;

    private Integer phone3;

    private Integer phone4;

    private Integer phone5;

    private Integer phone6;

    private Integer phone7;

    private Integer phone8;

    private Integer phone9;

    private Integer phone10;


}
