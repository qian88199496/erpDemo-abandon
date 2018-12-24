package com.erp.mapper.entity;


import java.util.Date;

/**
 * 商品表
 * create by xu ao
 */
public class Goods {

    private Long goodsId;
    private String goodsCode; // 商品编码，唯一标识
    /**
     * 基础信息
     */
    private String goodsName; // 商品名称
    private String goodsCategory; // 商品类别
    private String goodsSpec; // 规格型号
    private String goodsBrand; // 商品品牌
    private String goodsDescription; // 商品描述
    private String goodsImage; // 商品图片
    /**
     * 额外信息
     */
    private String goodsMeasure; // 计量单位
    private Double presetEnterPrice; // 预设进价
    private Double presetSellPrice; // 预设售价
    /**
     * 系统保留字段
     */
    private Date createTime; // 创建时间
    private String creator; // 创建人
    private String updateTime; // 更新时间
    private String updator; // 更新人
    private Integer status; // 状态（保留字段）
}
