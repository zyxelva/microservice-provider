package com.taeyeon.zyx.application.report;

import cn.huanju.edu100.exception.ServiceException;
import com.taeyeon.zyx.common.Page;
import com.taeyeon.zyx.dto.ReportParamDto;
import com.taeyeon.zyx.dto.TbClientReportDto;

import java.util.Collection;
import java.util.List;

public interface TbClientReportApplication {
    /**
     * 根据uid查询单个日志文件信息
     *
     * @param id
     * @return
     */
    TbClientReportDto get(Long id);

    /**
     * 根据 ID 列表查询日志
     *
     * @param ids
     * @return
     */
    List<TbClientReportDto> list(Collection<Long> ids);

    /**
     * 分页查询
     *
     * @param reportParam
     * @return
     */
    Page<TbClientReportDto> page(ReportParamDto reportParam);

    /**
     * 日志新增
     *
     * @param tbClientReportDto
     * @return
     * @throws ServiceException
     */
    Long add(TbClientReportDto tbClientReportDto) throws ServiceException;

    /**
     * 删除日志
     *
     * @param reportDto
     * @return
     */
    int delete(TbClientReportDto reportDto);
}
