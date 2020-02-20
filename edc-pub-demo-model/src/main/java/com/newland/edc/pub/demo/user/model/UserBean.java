package com.newland.edc.pub.demo.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.newland.edc.pub.demo.user.BaseBean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
public class UserBean extends BaseBean implements Serializable {
    /**
     * 用户工号
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String userId;

    /**
     * 机构ID
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String orgId;

    /**
     * 机构名称
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String orgName;

    /**
     * 用户归属
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String regionId;

    /**
     * 归属地名称
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String regionName;

    /**
     * 用户别名
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String nickName;

    /**
     * 用户姓名
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String userName;

    /**
     * 用户密码
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String passwd;

    /**
     * 密码变更周期
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String expireDates;

    /**
     * 联系电话
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String mobilePhone;

    /**
     * 电子邮箱
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String mailAddr;

    /**
     * 操作员状态：0 初始、1 正常、2 暂时失效、9 失效
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String status;

    /**
     * 锁定标志   0  正常   1  锁定
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String lockFlag;

    /**
     * 生效时间
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inureTime;

    /**
     * 失效时间
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expireTime;

    /**
     * 创建工号
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String createUser;

    /**
     * 创建时间
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改工号
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String modifyUser;

    /**
     * 修改时间
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

    /**
     * 操作员级别0, 一般员工1, 二级部门领导2, 一级部门领导3, 公司领导
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String headShip;

    /**
     * 性别
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String sex;

    /**
     * 职务
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String headshipDesc;

    /**
     * 备注
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String description;

    /**
     * 出生日期
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 证件类型
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String icType;

    /**
     * 证件号
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String icNo;

    /**
     * 民族
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String nation;

    /**
     * 敏感等级 dim_id = 1030
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String secureLevel;

    /**
     * 4A主账号
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String account4a;

    /**
     * 密码连续失败次数
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String passwdRepeatCnt;

    /**
     * 省份编码
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String homeProvince;

    /**
     * 省份名称
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String homeProvinceName;

    /**
     * 归属市ID
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String homeCity;

    /**
     * 归属市名称
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String homeCityName;

    /**
     * 归属县ID
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String homeCounty;

    /**
     * 归属县名称
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String homeCountyName;

    /**
     * 验证码
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String verifyCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getExpireDates() {
        return expireDates;
    }

    public void setExpireDates(String expireDates) {
        this.expireDates = expireDates;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

    public Date getInureTime() {
        return inureTime;
    }

    public void setInureTime(Date inureTime) {
        this.inureTime = inureTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getHeadShip() {
        return headShip;
    }

    public void setHeadShip(String headShip) {
        this.headShip = headShip;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadshipDesc() {
        return headshipDesc;
    }

    public void setHeadshipDesc(String headshipDesc) {
        this.headshipDesc = headshipDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIcType() {
        return icType;
    }

    public void setIcType(String icType) {
        this.icType = icType;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSecureLevel() {
        return secureLevel;
    }

    public void setSecureLevel(String secureLevel) {
        this.secureLevel = secureLevel;
    }

    public String getAccount4a() {
        return account4a;
    }

    public void setAccount4a(String account4a) {
        this.account4a = account4a;
    }

    public String getPasswdRepeatCnt() {
        return passwdRepeatCnt;
    }

    public void setPasswdRepeatCnt(String passwdRepeatCnt) {
        this.passwdRepeatCnt = passwdRepeatCnt;
    }

    public String getHomeProvince() {
        return homeProvince;
    }

    public void setHomeProvince(String homeProvince) {
        this.homeProvince = homeProvince;
    }

    public String getHomeProvinceName() {
        return homeProvinceName;
    }

    public void setHomeProvinceName(String homeProvinceName) {
        this.homeProvinceName = homeProvinceName;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeCityName() {
        return homeCityName;
    }

    public void setHomeCityName(String homeCityName) {
        this.homeCityName = homeCityName;
    }

    public String getHomeCounty() {
        return homeCounty;
    }

    public void setHomeCounty(String homeCounty) {
        this.homeCounty = homeCounty;
    }

    public String getHomeCountyName() {
        return homeCountyName;
    }

    public void setHomeCountyName(String homeCountyName) {
        this.homeCountyName = homeCountyName;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
