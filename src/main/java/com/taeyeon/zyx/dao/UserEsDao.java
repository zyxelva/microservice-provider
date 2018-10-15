package com.taeyeon.zyx.dao;

import com.taeyeon.zyx.entity.TbTeacher;

import java.util.List;

/**
 * @Author: zhuyuanxin
 * @Date: 18/10/14 下午4:31
 * @Description:
 */
public interface UserEsDao {
    boolean index(TbTeacher teacher);

    TbTeacher getByName(String name);

    List<TbTeacher> listByName(String name);
}
