/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.dao;

import com.taeyeon.zyx.entity.TbTeacher;
import com.taeyeon.zyx.persistence.CrudDao;
import com.taeyeon.zyx.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * 河马老师DAO接口
 *
 * @author lizhuo
 * @version 2018-04-14
 */
@MyBatisDao
public interface TbTeacherDao extends CrudDao<TbTeacher> {

    /**
     * 返回正常可用状态的老师
     *
     * @param mobile
     * @return
     */
    TbTeacher getByMobile(@Param("mobile") String mobile);

    TbTeacher getByMobileStates(@Param("mobile") String mobile, @Param("stateList") List<Integer> stateList);

    /**
     * 返回正常可用状态的老师
     *
     * @param uids
     * @return
     */
    List<TbTeacher> listByUids(@Param("uids") Collection<Long> uids);

    /**
     * 返回正常可用状态的老师
     *
     * @param uid
     * @return
     */
    TbTeacher getByUid(@Param("uid") Long uid);

    /**
     * 返回老师
     *
     * @param uid
     * @return
     */
    TbTeacher getByUidStates(@Param("uid") Long uid, @Param("stateList") List<Integer> stateList);

    int formalize(TbTeacher tbTeacher);
}