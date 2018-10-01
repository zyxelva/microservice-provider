package com.taeyeon.zyx.service.impl;

import com.taeyeon.zyx.dao.TbClientReportDao;
import com.taeyeon.zyx.dto.TbClientReportDto;
import com.taeyeon.zyx.entity.TbClientReport;
import com.taeyeon.zyx.service.CrudService;
import com.taeyeon.zyx.service.TbClientReportService;
import com.taeyeon.zyx.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service("tbClientReportService")
public class TbClientReportServiceImpl extends CrudService<TbClientReportDao, TbClientReport>
        implements TbClientReportService {
    private static final Logger logger = LoggerFactory.getLogger(TbClientReportServiceImpl.class);
//    @Autowired
//    private TbClientReportDao tbClientReportDao;
//
//    public TbClientReport get(Long id){
//        return tbClientReportDao.get(id);
//    }

    /*
     * 创建随机文件名称
     *
     * @return
     */
    private String buildeName(String extensionName) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString() + "." + extensionName;
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return nowTimeStamp
     */
    private String getNowTimeStamp() {
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time / 1000);
        return nowTimeStamp;
    }

    @Override
    public List<TbClientReport> listByIds(Collection<Long> ids) {
        return dao.listByIds(ids);
    }

    @Transactional
    @Override
    public Long add(TbClientReportDto tbClientReportDto) {
        TbClientReport tbClientReport = BeanUtil.copy(tbClientReportDto, TbClientReport.class);
        dao.insert(tbClientReport);
        return tbClientReport.getId();
    }
}
