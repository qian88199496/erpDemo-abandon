/*
 * @(#)SplitUtils.java    Created on 2018年4月27日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.erp.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengzheng
 * @version $Revision: 1.0 $, $Date: 2018年4月27日 下午2:14:39 $
 */
public class SplitUtils {

    /**
     *
     * @param list
     *            要拆分的集合
     * @param size
     *            指定的大小一般小于60000
     * @return
     */
    public static <T> List<List<T>> getSplitList(List<T> list, int size) {
        List<List<T>> returnList = new ArrayList<List<T>>();
        int listSize = list.size();
        int num = listSize % size == 0 ? listSize / size : (listSize / size + 1);
        int start = 0;
        int end = 0;
        for (int i = 1; i <= num; i++) {
            start = (i - 1) * size;
            end = i * size > listSize ? listSize : i * size;
            returnList.add(list.subList(start, end));
        }
        return returnList;
    }

}
