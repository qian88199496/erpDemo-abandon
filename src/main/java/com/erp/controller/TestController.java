/*
 * @(#)TestController.java    Created on 2018年12月4日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.service.UserService;

/**
 * @author qianpz
 * @version $Revision: 1.0 $, $Date: 2018年12月4日 下午3:06:09 $
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserService userService;

    @RequestMapping("/forward")
    public String test(HttpServletRequest request) {
        System.out.println(request.getAttribute("forward"));
        return "forward:/index.html";
    }

}
