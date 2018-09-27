package com.taeyeon.zyx.service;

import com.taeyeon.zyx.dao.TbTeacherDao;
import com.taeyeon.zyx.entity.TbTeacher;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author zyx
 * @date 2018/9/26 026 18:34
 */
@Service("tbTeacherService")
public class TbTeacherServiceImpl extends CrudService<TbTeacherDao, TbTeacher> implements TbTeacherService {
//    @Autowired
//    private TbTeacherDao tbTeacherDao;
    public TbTeacher get(Long tuid){
//        TbTeacher teacher=new TbTeacher();
//        teacher.setUid(123L);
//        teacher.setType(1);
        return dao.get(tuid);
    }

    @Override
    public TbTeacher getByMobile(String mobile) throws DataAccessException {
        if (StringUtils.isBlank(mobile) || !NumberUtils.isNumber(mobile)) {
            logger.error("getByMobile mobile is blank or not number");
            return null;
        }
        return dao.getByMobile(mobile);
    }
}
