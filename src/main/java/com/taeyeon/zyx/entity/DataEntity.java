package com.taeyeon.zyx.entity;

/**
 * @author zyx
 * @date 2018/9/26 026 18:32
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

public abstract class DataEntity<T> extends BaseEntity<T> {
    private static final long serialVersionUID = 1L;
    protected String remarks;
    protected Long createBy;
    protected Long updateBy;
    protected Date createDate;
    protected Date updateDate;
    protected Integer delFlag;
    protected Date updateBeginDate;
    protected Date updateEndDate;
    protected Date createBeginDate;
    protected Date createEndDate;

    public DataEntity() {
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(Long id) {
        super(id);
    }

    @Length(
            min = 0,
            max = 255
    )
    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @JsonIgnore
    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getUpdateBeginDate() {
        return this.updateBeginDate;
    }

    public void setUpdateBeginDate(Date updateBeginDate) {
        this.updateBeginDate = updateBeginDate;
    }

    public Date getUpdateEndDate() {
        return this.updateEndDate;
    }

    public void setUpdateEndDate(Date updateEndDate) {
        this.updateEndDate = updateEndDate;
    }

    public Date getCreateBeginDate() {
        return this.createBeginDate;
    }

    public void setCreateBeginDate(Date createBeginDate) {
        this.createBeginDate = createBeginDate;
    }

    public Date getCreateEndDate() {
        return this.createEndDate;
    }

    public void setCreateEndDate(Date createEndDate) {
        this.createEndDate = createEndDate;
    }

    public void addLogDetail(StringBuffer logDetail, String oldProperty, String newProperty, String propertyKey) {
        if (!this.isSameStr(oldProperty, newProperty)) {
            if (StringUtils.isBlank(newProperty)) {
                logDetail.append(propertyKey).append("取消").append("; ");
            } else {
                logDetail.append(propertyKey).append("修改为").append(newProperty).append(";");
            }
        }

    }

    public boolean isSameStr(String oldProperty, String newProperty) {
        if (StringUtils.isBlank(oldProperty) && StringUtils.isBlank(newProperty)) {
            return true;
        } else {
            return null != oldProperty && oldProperty.equals(newProperty);
        }
    }
}

