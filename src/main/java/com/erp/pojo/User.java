/*
 * @(#)User.java    Created on 2018年3月21日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.erp.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Pengzheng
 * @version $Revision: 1.0 $, $Date: 2018年3月21日 上午11:38:54 $
 */
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class User implements Serializable {

    private static final long serialVersionUID = 2635773181751559243L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer sex;
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "updateTime")
    private Date updateTime;
    private Integer age;
    private Integer statu;

    /**
     * @return Returns the id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the sex.
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @return Returns the sex.
     */
    public String getSexString() {
        if (sex == 0) {
            return "男";
        }
        return "女";
    }

    /**
     * @param sex
     *            The sex to set.
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return Returns the createTime.
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @return Returns the createTime.
     */
    public String getCreateTimeString() {
        if (createTime != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String date = sdf.format(createTime);
            return date;
        }
        return "";
    }

    /**
     * @param createTime
     *            The createTime to set.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return Returns the updateTime.
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @return Returns the updateTime.
     */
    public String getUpdateTimeString() {
        if (updateTime != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String date = sdf.format(updateTime);
            return date;
        }
        return "";
    }

    /**
     * @param updateTime
     *            The updateTime to set.
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return Returns the age.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     *            The age to set.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return Returns the statu.
     */
    public Integer getStatu() {
        return statu;
    }

    /**
     * @param status
     *            The statu to set.
     */
    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", createTime=" + createTime + ", updateTime="
                + updateTime + ", age=" + age + ", status=" + statu + "]";
    }

}
