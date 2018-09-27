package com.taeyeon.zyx.controller;

import com.taeyeon.zyx.application.TeacherApplication;
import com.taeyeon.zyx.application.report.TbClientReportApplication;
import com.taeyeon.zyx.dto.TbClientReportDto;
import com.taeyeon.zyx.dto.TbTeacherDto;
import com.taeyeon.zyx.utils.GsonUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zyx
 * @date 2018/9/27 027 12:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class TeacherControllerTest {
    @Autowired
    private TeacherApplication teacherApplication;

    @Autowired
    private TbClientReportApplication tbClientReportApplication;

    @Test
    public void mytest(){
        System.out.print("==================Test================");
    }

    @Test
    public void test_getByUid() throws DataAccessException {
        TbTeacherDto teacher = teacherApplication.getByUid(2325455158L);
        Assert.assertNotNull(teacher);
        System.out.println(GsonUtils.toJson(teacher));
    }

    @Test
    public void test_getByReportId(){
        TbClientReportDto tbClientReportDto = tbClientReportApplication.get(103L);
        Assert.assertNotNull(tbClientReportDto);
        System.out.println(GsonUtils.toJson(tbClientReportDto));

    }
}
