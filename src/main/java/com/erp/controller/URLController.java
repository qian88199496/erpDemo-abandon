/*
 * @(#)TestController.java    Created on 2018年12月4日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuao
 */
@Controller
@RequestMapping("/web")
public class URLController {

    @ResponseBody
    @RequestMapping({"", "/index"})
    public String test() {
        return "index";
    }

}
