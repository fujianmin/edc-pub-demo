package com.newland.edc.pub.demo.common.dao;

import com.newland.bd.utils.db.springjdbc.dao.basedao.CommonBaseDao;
import com.newland.edc.pub.demo.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author fujm
 * history 1.0.0 2020/1/13 created by fujm
 */
@Repository
public abstract class CommonCommonDao implements ICommonDao {
    private static final Logger logger = LoggerFactory.getLogger(CommonCommonDao.class);

    @Resource(name = "com.newland.bd.utils.db.springjdbc.dao.basedao.CommonBaseDao")
    protected CommonBaseDao dao;

    @Override
    public String getNextVal(String tableName) {
        String dualTable; //虚拟表，用来配置数据库的虚拟表如：oracle的dual、db2的sysibm.sysdummy1、mysql为空
        if (StringUtils.equalsIgnoreCase(Constants.DB_TYPE, "oracle")) {
            dualTable = " from dual";
        } else if (StringUtils.equalsIgnoreCase(Constants.DB_TYPE, "db2")) {
            dualTable = " from sysibm.sysdummy1";
        } else {
            dualTable = "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("select f_get_key_int_nextval('").append(tableName).append("')  login_seq_id ").append(dualTable);
        logger.info("(#^.^#)根据表名获取ID值SQL = {}", sb);
        return this.dao.queryForObject(sb.toString(), String.class);
    }
}
