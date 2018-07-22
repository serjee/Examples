package ru.mibix.im.parser.model;

import java.util.Date;

/**
 * Объектное представление сущности Магазины.
 */
public class Shops extends AbstractModel {

    private String name;
    private String url;
    private int status;
    private int query_used;
    private int query_count;
    private Date createTime;
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuery_used() {
        return query_used;
    }

    public void setQuery_used(int query_used) {
        this.query_used = query_used;
    }

    public int getQuery_count() {
        return query_count;
    }

    public void setQuery_count(int query_count) {
        this.query_count = query_count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
