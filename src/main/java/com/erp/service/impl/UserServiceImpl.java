/*
 * @(#)UserServiceImpl.java    Created on 2018年3月21日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.mapper.UserMapper;
import com.erp.pojo.User;
import com.erp.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author Pengzheng
 * @version $Revision: 1.0 $, $Date: 2018年3月21日 下午12:33:01 $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findPageUser(int page, int rows) {
        // 引入分页插件
        PageHelper.startPage(page, rows);
        /**
         * 分页插件 已经实现分页查询
         */
        List<User> userList = userMapper.findAll();

        // 设定分页参数
        PageInfo<User> userInfo = new PageInfo<User>(userList);

        return userInfo;
    }

    @Override
    public PageInfo<User> findUserByName(Integer page, Integer rows, String name) {
        // 引入分页插件
        PageHelper.startPage(page, rows);
        /**
         * 分页插件 已经实现分页查询
         */
        List<User> userList = userMapper.findUserByName(name);

        // 设定分页参数
        PageInfo<User> userInfo = new PageInfo<User>(userList);

        return userInfo;
    }

    @Override
    public List<User> findUserByName(String name) {
        List<User> userList = userMapper.findUserByName(name);
        return userList;
    }

    @Override
    public PageInfo<User> findUserBySex(Integer page, Integer rows, String sex) {
        // 引入分页插件
        PageHelper.startPage(page, rows);
        /**
         * 分页插件 已经实现分页查询
         */
        List<User> itemList = userMapper.findUserBySex(sex);

        // 设定分页参数
        PageInfo<User> userInfo = new PageInfo<User>(itemList);

        return userInfo;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void deleteUser(String[] ids) {
        /* String[] checkedIds = ids.split(","); */
        userMapper.deleteUser(ids);
    }

    @Override
    public int checkName(User user) {
        int count = userMapper.checkName(user);
        return count;
    }

}
