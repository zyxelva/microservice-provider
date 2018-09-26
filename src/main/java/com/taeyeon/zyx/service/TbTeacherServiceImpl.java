package com.taeyeon.zyx.service;

import com.taeyeon.zyx.entity.TbTeacher;
import org.springframework.stereotype.Service;

/**
 * @author zyx
 * @date 2018/9/26 026 18:34
 */
@Service("tbTeacherService")
public class TbTeacherServiceImpl implements TbTeacherService {
    public TbTeacher get(Long tuid){
        TbTeacher teacher=new TbTeacher();
        teacher.setUid(123L);
        teacher.setType(1);
        return teacher;
    }
}
