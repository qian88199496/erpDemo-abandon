/*
 * @(#)UserService.java    Created on 2018年3月21日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.erp.service;

import java.util.List;

import com.erp.pojo.User;
import com.github.pagehelper.PageInfo;

/**
 * 定义service层的接口文件
 *
 * @author Pengzheng
 * @version $Revision: 1.0 $, $Date: 2018年3月21日 上午11:53:24 $
 */
public interface UserService {

    /**
     * 分页查询用户信息
     *
     * @param page
     *            当前页
     * @param rows
     *            一页记录数
     * @return PageInfo<User> 分页的用户信息
     */
    PageInfo<User> findPageUser(int page, int rows);

    /**
     * 根据姓名分页查询用户信息
     *
     * @param page
     *            当前页
     * @param rows
     *            一页记录数
     * @param name
     *            查询条件
     * @return PageInfo<User> 分页的用户信息
     */
    PageInfo<User> findUserByName(Integer page, Integer rows, String name);

    /**
     * 根据用户名查询用户信息
     *
     * @param name
     * @return
     */
    List<User> findUserByName(String name);

    /**
     * 根据性别分页查询用户信息
     *
     * @param page
     *            当前页
     * @param rows
     *            一页记录数
     * @param sex
     *            查询条件
     * @return 分页的用户信息
     */
    PageInfo<User> findUserBySex(Integer page, Integer rows, String sex);

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return 当前ID用户
     */
    User findUserById(Integer id);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 新增用户信息
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 根据ID批量删除用户
     *
     * @param ids
     *            用户id
     */
    void deleteUser(String[] ids);

    /**
     * 查询用户姓名是否重复
     *
     * @param user
     *            用户名
     * @return 重复数量
     */
    int checkName(User user);
}
