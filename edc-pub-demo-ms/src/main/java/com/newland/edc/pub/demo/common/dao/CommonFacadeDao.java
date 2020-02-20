package com.newland.edc.pub.demo.common.dao;

import com.newland.bd.utils.db.springjdbc.dao.facadedao.FacadeDao;
import com.newland.bd.utils.db.springjdbc.dao.model.DaoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fujm
 * history 1.0.0 2020/1/13 created by fujm
 */
@Repository
public class CommonFacadeDao extends FacadeDao<ICommonDao> {
    @Autowired
    private CommonOracleDao oracleDao;

    @Autowired
    private CommonMysqlDao mySqlDao;

    private ThreadLocal<Map<DaoInfo.DB_TYPE, ICommonDao>> tlMap = ThreadLocal.withInitial(() -> {
        Map<DaoInfo.DB_TYPE, ICommonDao> map = new HashMap<>();
        map.put(DaoInfo.DB_TYPE.ORACLE, oracleDao);
        map.put(DaoInfo.DB_TYPE.MYSQL, mySqlDao);
        return map;
    });

    public ICommonDao getBaseDao() {
        Map<DaoInfo.DB_TYPE, ICommonDao> mapDbType = tlMap.get();
        return this.getBusDao(mapDbType);
    }
}
