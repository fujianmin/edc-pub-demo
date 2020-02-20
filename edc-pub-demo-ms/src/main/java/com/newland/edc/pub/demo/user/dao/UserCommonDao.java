package com.newland.edc.pub.demo.user.dao;

import com.alibaba.fastjson.JSON;
import com.newland.bd.ms.core.model.RespInfo;
import com.newland.bd.utils.db.springjdbc.dao.basedao.CommonBaseDao;
import com.newland.edc.pub.demo.user.model.UserBean;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
@Repository
public abstract class UserCommonDao implements IUserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserCommonDao.class);

    @Resource(name = "com.newland.bd.utils.db.springjdbc.dao.basedao.CommonBaseDao")
    protected CommonBaseDao dao;

    @Override
    public RespInfo qryUserInfo(UserBean userBean) {
        StringBuilder sql = new StringBuilder();
        sql.append("select a.user_id,");
        sql.append("       a.user_name,");
        sql.append("       a.nick_name,");
        sql.append("       a.passwd,");
        sql.append("       a.status,");
        sql.append("       a.mobile_Phone,");
        sql.append("       a.mail_Addr,");
        sql.append("       a.secure_Level,");
        sql.append("       a.expire_Time,");
        sql.append("       a.lock_Flag,");
        sql.append("       a.passwd_Repeat_Cnt,");
        sql.append("       a.create_user,");
        sql.append("       a.create_time,");
        sql.append("       a.modify_user,");
        sql.append("       a.modify_time,");
        sql.append("       a.ic_type,");
        sql.append("       a.ic_no,");
        sql.append("       a.birthday,");
        sql.append("       a.sex,");
        sql.append("       a.org_id,");
        sql.append("       b.org_name,");
        sql.append("       a.region_id,");
        sql.append("       syr.region_Name,");
        sql.append("       syr.home_province,");
        sql.append("       syr.home_province_name,");
        sql.append("       syr.home_city,");
        sql.append("       syr.home_city_name,");
        sql.append("       syr.home_county,");
        sql.append("       syr.home_county_name");
        sql.append("  from sm2_user a");
        sql.append("  left join sm2_org b");
        sql.append("    on a.org_id = b.org_id");
        sql.append("  left join sm2_sys_region_view syr");
        sql.append("    on a.region_id = syr.region_id");
        sql.append(" where 1 = 1");
        if (StringUtils.isNotBlank(userBean.getUserId())) {
            sql.append(" and a.user_id = :userId ");
        }
        if (StringUtils.isNotBlank(userBean.getUserName())) {
            sql.append(" and a.user_name = :userName ");
        }
        if (StringUtils.isNotBlank(userBean.getNickName())) {
            sql.append(" and a.nick_name = :nickName ");
        }
        if (StringUtils.isNotBlank(userBean.getStatus())) {
            sql.append(" and a.nick_name = :status ");
        }
        sql.append(" order by a.modify_time desc,a.user_id");

        String execSQL = StringUtils.replacePattern(sql.toString(), "\\s+", " ");
        String jsonStr = JSON.toJSONString(userBean, true);
        logger.info("☆☆☆ 查询用户基本信息请求参数 = {}", jsonStr);
        logger.info("☆☆☆ 查询用户基本信息SQL = {}", execSQL);

        List<UserBean> userBeanList;
        int total = dao.getRecordCount(execSQL, userBean);
        if (StringUtils.isNotEmpty(userBean.getStartPage()) && StringUtils.isNotEmpty(userBean.getPageSize())) {
            int startPage = Integer.parseInt(userBean.getStartPage());
            int pageSize = Integer.parseInt(userBean.getPageSize());
            userBeanList = this.dao.pageQuery(sql.toString(), userBean, UserBean.class, startPage, pageSize);
        } else {
            userBeanList = this.dao.query(sql.toString(), userBean, UserBean.class);
        }

        RespInfo respInfo = new RespInfo();
        respInfo.setDataTotalCount(CollectionUtils.isNotEmpty(userBeanList) ? total : 0);
        respInfo.setRespData(userBeanList);
        return respInfo;
    }
}
