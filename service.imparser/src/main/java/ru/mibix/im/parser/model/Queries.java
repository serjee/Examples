package ru.mibix.im.parser.model;

import java.util.Date;

/**
 * Объектное представление сущности Запросы.
 */
public class Queries extends AbstractModel {

    private String name;
    private int shop_id;
    private int status;
    private Date createTime;
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShopId() {
        return shop_id;
    }

    public void setShopId(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
