/*
 * @(#)TestController.java    Created on 2018年12月4日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.common.vo.SysResult;

/**
 * @author qianpz
 * @version $Revision: 1.0 $, $Date: 2018年12月4日 下午3:06:09 $
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/aa")
    @ResponseBody
    public SysResult test() {
        return SysResult.build(200, "访问成功");
    }

}
