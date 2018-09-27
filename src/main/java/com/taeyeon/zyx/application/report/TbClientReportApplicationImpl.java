package com.taeyeon.zyx.application.report;

import com.taeyeon.zyx.dto.TbClientReportDto;
import com.taeyeon.zyx.entity.TbClientReport;
import com.taeyeon.zyx.service.TbClientReportService;
import com.taeyeon.zyx.utils.BeanUtil;
import com.taeyeon.zyx.utils.CommUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zyx
 * @date 2018/9/27 027 15:49
 */
@Service("tbClientReportApplication")
public class TbClientReportApplicationImpl implements TbClientReportApplication {
    private static final Logger logger = LoggerFactory.getLogger(TbClientReportApplicationImpl.class);

    @Autowired
    private TbClientReportService tbClientReportService;

    /**
     * 查询单个日志文件信息
     */
    @Override
    public TbClientReportDto get(Long id) {
        if (!CommUtil.isValid(id)) {
            logger.error("get,but id is null");
            return null;
        }
        TbClientReport tbClientReport = tbClientReportService.get(id);
        return BeanUtil.copy(tbClientReport, TbClientReportDto.class);
    }

}
