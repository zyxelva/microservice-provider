package com.taeyeon.zyx.service;

import com.taeyeon.zyx.dto.TbClientReportDto;
import com.taeyeon.zyx.entity.TbClientReport;

import java.util.Collection;
import java.util.List;

public interface TbClientReportService extends CrudInf<TbClientReport> {

    List<TbClientReport> listByIds(Collection<Long> ids);

    Long add(TbClientReportDto tbClientReportDto);
}
