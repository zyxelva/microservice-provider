package com.taeyeon.zyx.application;

import cn.huanju.edu100.util.EduGsonUtils;
import com.taeyeon.zyx.application.report.TbClientReportApplication;
import com.taeyeon.zyx.common.Page;
import com.taeyeon.zyx.dto.ReportParamDto;
import com.taeyeon.zyx.dto.TbClientReportDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: zhuyuanxin
 * @Date: 18/10/1 下午1:04
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class ClientApplicationTest {

    @Autowired
    private TbClientReportApplication tbClientReportApplication;
    @Test
    public void  test_page(){
        ReportParamDto reportParam=new ReportParamDto();
        reportParam.setUid(50005023L);
        Page<TbClientReportDto> clientReportDtoPage = tbClientReportApplication.page(reportParam);
        Assert.assertNotNull(clientReportDtoPage);
        System.out.println("+++++++++++"+ EduGsonUtils.toJson(clientReportDtoPage));

    }

}
