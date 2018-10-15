package com.taeyeon.zyx.dao;

import com.taeyeon.zyx.entity.TbTeacher;
import com.taeyeon.zyx.utils.GsonUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;

/**
 * @Author: zhuyuanxin
 * @Date: 18/10/14 下午5:32
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class UserEsDaoTest {
    @Autowired
    private UserEsDao userEsDao;
    @Test
    public void testEsIndex() throws ParseException {
        TbTeacher tbUser = new TbTeacher();
        tbUser.setUid(2L);
        tbUser.setNick("100教育 zhoujielun");
//        tbUser.setBirthday(DateUtils.parseDateTimeSec("1982-09-01 00:00:00"));
        Boolean result = userEsDao.index(tbUser);
        Assert.assertTrue(result);
    }

    @Test
    public void testProfileNameSearch(){
        TbTeacher tbUser = userEsDao.getByName("100教育戴支荣");
        Assert.assertNotNull(tbUser);
        System.out.println(GsonUtils.toJson(tbUser));
    }
}
