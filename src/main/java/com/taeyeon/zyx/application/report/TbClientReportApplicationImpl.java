package com.taeyeon.zyx.application.report;

import cn.huanju.edu100.exception.ServiceException;
import com.taeyeon.zyx.common.ErrCodeConsts;
import com.taeyeon.zyx.common.Page;
import com.taeyeon.zyx.dto.ReportParamDto;
import com.taeyeon.zyx.dto.TbClientReportDto;
import com.taeyeon.zyx.entity.TbClientReport;
import com.taeyeon.zyx.service.TbClientReportService;
import com.taeyeon.zyx.utils.BeanUtil;
import com.taeyeon.zyx.utils.CommUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<TbClientReportDto> list(Collection<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            logger.error("list, but ids is empty.");
            return Collections.emptyList();
        }
        List<TbClientReport> clientReportList = tbClientReportService.listByIds(ids);
        if (CollectionUtils.isEmpty(clientReportList)) {
            return Collections.emptyList();
        }
        return BeanUtil.copyList(clientReportList, TbClientReportDto.class);
    }

    @Override
    public Page<TbClientReportDto> page(ReportParamDto reportParam) {
        if (reportParam == null) {
            logger.error("page,but reportParam should not be null!");
            return Page.emptyPage();
        }
        reportParam.validatePage();
        TbClientReport tbClientReport = BeanUtil.copy(reportParam, TbClientReport.class);
        Page<TbClientReport> tbClientReportPage = tbClientReportService.findPage(new Page<>(reportParam.getPageNo(), reportParam.getPageSize()), tbClientReport);
        return BeanUtil.copyPage(tbClientReportPage, TbClientReportDto.class);
    }

    /**
     * 保存日志上传信息
     */
    @Override
    public Long add(TbClientReportDto tbClientReportDto) throws ServiceException {
        validateAdd(tbClientReportDto);
        return tbClientReportService.add(tbClientReportDto);
    }

    @Override
    public int delete(TbClientReportDto reportDto) {
        if (null == reportDto) {
            return 0;
        }
        if (!CommUtil.isValid(reportDto.getId()))
            return 0;
        tbClientReportService.delete(BeanUtil.copy(reportDto, TbClientReport.class));
        return 1;
    }

    /**
     * 校验日志必要属性信息
     */
    private void validateAdd(TbClientReportDto tbClientReportDto) {
        if (tbClientReportDto == null) {
            throw new ServiceException(ErrCodeConsts.BussinessError.ParamLost, "tbClientReportDto");
        }
        if (!cn.huanju.edu100.util.CommUtil.isValid(tbClientReportDto.getUid())) {
            logger.error("validateAdd,but uid is null, dto :{}.", tbClientReportDto.toString());
            throw new ServiceException(ErrCodeConsts.ReportError.UidEmpty);
        }
        if (StringUtils.isBlank(tbClientReportDto.getFileUrl())) {
            logger.error("validateAdd,but FileUrl is null, uid :{}.", tbClientReportDto.getUid());
            throw new ServiceException(ErrCodeConsts.ReportError.FileUrlEmpty);
        }
        if (tbClientReportDto.getReportTime() == null) {
            logger.error("validateAdd,but ReportTime is null, uid :{}.", tbClientReportDto.getUid());
            throw new ServiceException(ErrCodeConsts.ReportError.ReportTimeEmpty);
        }
        if (StringUtils.isBlank(tbClientReportDto.getFileSize())) {
            logger.error("validateAdd,but Filesize is null, uid :{}.", tbClientReportDto.getUid());
            throw new ServiceException(ErrCodeConsts.ReportError.FileSizeEmpty);
        }
    }

}
