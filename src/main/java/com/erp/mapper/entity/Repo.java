package com.erp.mapper.entity;

import java.util.Date;

/**
 * 仓库表
 * create by xu ao
 */
public class Repo {

    private Long id;
    private String repoCode;
    /**
     * 基本信息
     */
    private String repoName; // 仓库名称
    private String repoAddr; // 仓库地址
    private String repoDescription; // 仓库描述
    /**
     * 系统保留字段
     */
    private Date createTime; // 创建时间
    private String creator; // 创建人
    private String updateTime; // 更新时间
    private String updator; // 更新人
    private Integer status; // 状态（保留字段）

}
