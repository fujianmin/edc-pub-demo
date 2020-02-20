package com.newland.edc.pub.demo.utils;

import com.newland.bd.multidb.autoconfigure.AppConst;
import com.newland.bi.util.common.DateUtil;
import com.newland.bi.util.common.StringUtil;

/**
 * @author fujm
 * history 1.0.0 2020/2/20 created by fujm
 */
public class CommonUtils {
    /**
     * 获取插入数据库匹配的系统时间字符串
     *
     * @param dbType  ORACLE,MYSQL,DB2
     * @param dateStr 指定的时间（为NULL取系统时间）
     * @return
     */
    public static String getDBDate(String dbType, String dateStr) {
        String systemDate;
        if (AppConst.ORACLE_DB_TYPE.equalsIgnoreCase(dbType) || AppConst.DB2_DB_TYPE.equalsIgnoreCase(dbType)) {
            if (StringUtil.isBlank(dateStr)) {
                systemDate = DateUtil.getSysDateByFormat("yyyy/MM/dd HH:mm:ss");
                systemDate = "TO_DATE('" + systemDate + "','yyyy/mm/dd hh24:mi:ss')";
            } else {
                dateStr = dateStr.replace("-", "/").trim();
                systemDate = "TO_DATE('" + dateStr + "','yyyy/mm/dd hh24:mi:ss')";
            }
        } else if (AppConst.MYSQL_DB_TYPE.equalsIgnoreCase(dbType)) {
            if (StringUtil.isBlank(dateStr)) {
                systemDate = DateUtil.getSysDateByFormat("yyyy-MM-dd HH:mm:ss");
                systemDate = "STR_TO_DATE('" + systemDate + "','%Y-%m-%d %H:%i:%s')";
            } else {
                dateStr = dateStr.replace("/", "-").trim();
                systemDate = "STR_TO_DATE('" + dateStr + "','%Y-%m-%d %H:%i:%s')";
            }
        } else {
            throw new IllegalArgumentException("Unsupport database type!");
        }
        return systemDate;
    }
}
