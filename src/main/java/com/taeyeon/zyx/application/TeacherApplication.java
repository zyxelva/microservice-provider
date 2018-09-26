package com.taeyeon.zyx.application;

import com.taeyeon.zyx.dto.TbTeacherDto;

/**
 * @author zyx
 * @date 2018/9/26 026 18:18
 */
public interface TeacherApplication {
    /**
     * 根据Uid查询老师信息
     *
     * @param uid
     * @return
     */
    TbTeacherDto getByUid(Long uid);
}
