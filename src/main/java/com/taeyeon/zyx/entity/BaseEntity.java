package com.taeyeon.zyx.entity;

/**
 * @author zyx
 * @date 2018/9/26 026 18:33
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import cn.huanju.edu100.common.Page;
import com.google.common.collect.Maps;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Map;

public abstract class BaseEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    protected long auto_id;
    protected Long id;
    @Expose(
            serialize = false,
            deserialize = false
    )
    protected Page<T> page;
    @Expose(
            serialize = false,
            deserialize = false
    )
    protected Map<String, String> sqlMap;
    protected boolean isNewRecord;
    public static final Integer DEL_FLAG_NORMAL = 0;
    public static final Integer DEL_FLAG_DELETE = 1;
    public static final Integer DEL_FLAG_AUDIT = 2;

    public BaseEntity() {
        this.isNewRecord = false;
    }

    public Long fetchLongId() {
        return null != this.id ? this.id : null;
    }

    public BaseEntity(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAuto_id() {
        return this.auto_id;
    }

    public void setAuto_id(long auto_id) {
        this.auto_id = auto_id;
    }

    @XmlTransient
    public Page<T> getPage() {
        if (this.page == null) {
            this.page = new Page();
        }

        return this.page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public Map<String, String> getSqlMap() {
        if (this.sqlMap == null) {
            this.sqlMap = Maps.newHashMap();
        }

        return this.sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    public boolean getIsNewRecord() {
        return this.isNewRecord || null == this.getId();
    }

    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (!this.getClass().equals(obj.getClass())) {
            return false;
        } else {
            BaseEntity<?> that = (BaseEntity)obj;
            return null == this.getId() ? false : this.getId().equals(that.getId());
        }
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

