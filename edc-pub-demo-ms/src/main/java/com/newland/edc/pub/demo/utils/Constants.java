package com.newland.edc.pub.demo.utils;

import com.newland.bd.multidb.autoconfigure.utils.MutilDataSourceUtils;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
public final class Constants {
    /**
     * 数据库类型
     */
    public static final String DB_TYPE = MutilDataSourceUtils.getCurrentDaoInfo().getDbType().toString();
}
