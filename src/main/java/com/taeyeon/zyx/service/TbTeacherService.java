package com.taeyeon.zyx.service;

import com.taeyeon.zyx.entity.TbTeacher;

/**
 * @author zyx
 * @date 2018/9/26 026 18:37
 */
public interface TbTeacherService extends CrudInf<TbTeacher>{
    TbTeacher get(Long tuid);

    TbTeacher getByMobile(String mobile);
}
