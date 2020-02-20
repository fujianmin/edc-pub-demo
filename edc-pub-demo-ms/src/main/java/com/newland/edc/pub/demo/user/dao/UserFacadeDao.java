package com.newland.edc.pub.demo.user.dao;

import com.newland.bd.utils.db.springjdbc.dao.facadedao.FacadeDao;
import com.newland.bd.utils.db.springjdbc.dao.model.DaoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
@Repository
public class UserFacadeDao extends FacadeDao<IUserDao> {
    @Autowired
    private UserOracleDao oracleDao;

    @Autowired
    private UserMysqlDao mySqlDao;

    private ThreadLocal<Map<DaoInfo.DB_TYPE, IUserDao>> tlMap = ThreadLocal.withInitial(() -> {
        Map<DaoInfo.DB_TYPE, IUserDao> map = new HashMap<>();
        map.put(DaoInfo.DB_TYPE.ORACLE, oracleDao);
        map.put(DaoInfo.DB_TYPE.MYSQL, mySqlDao);
        return map;
    });

    public IUserDao getBaseDao() {
        Map<DaoInfo.DB_TYPE, IUserDao> mapDbType = tlMap.get();
        return this.getBusDao(mapDbType);
    }
}
