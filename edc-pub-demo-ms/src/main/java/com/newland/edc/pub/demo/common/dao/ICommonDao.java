package com.newland.edc.pub.demo.common.dao;

/**
 * @author fujm
 * history 1.0.0 2020/1/13 created by fujm
 */
public interface ICommonDao {
    /**
     * 根据表名获取ID值
     *
     * @param tableName 表名
     * @return ID值
     */
    String getNextVal(String tableName);
}
