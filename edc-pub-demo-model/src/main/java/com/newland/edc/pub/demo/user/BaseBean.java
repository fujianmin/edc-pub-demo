package com.newland.edc.pub.demo.user;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
public class BaseBean {
    /**
     * 页码
     * 分页为空默认不分页
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    protected String startPage;

    /**
     * 单页条数
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    protected String pageSize;

    /**
     * 操作用户
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    protected String optUser;

    /**
     * 操作类型  1-新增 2-修改 3-删除
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    protected String optFlag;

    /**
     * 操作描述
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    protected String optDesc;

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public String getOptFlag() {
        return optFlag;
    }

    public void setOptFlag(String optFlag) {
        this.optFlag = optFlag;
    }

    public String getOptDesc() {
        return optDesc;
    }

    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc;
    }
}
