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

    /**
     * 默认失效时间
     */
    public static final String DEFAULT_EXPIRE_TIME = "2099-12-31 00:00:00";
}
