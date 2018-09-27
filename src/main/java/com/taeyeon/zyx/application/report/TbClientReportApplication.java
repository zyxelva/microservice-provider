package com.taeyeon.zyx.application.report;

import com.taeyeon.zyx.dto.TbClientReportDto;

public interface TbClientReportApplication {
	/**
	 * 根据uid查询单个日志文件信息
	 * @param id
	 * @return
	 */
	TbClientReportDto get(Long id);
}
