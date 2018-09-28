package com.taeyeon.zyx.dao;

import com.taeyeon.zyx.entity.TbClientReport;
import com.taeyeon.zyx.persistence.CrudDao;
import com.taeyeon.zyx.persistence.annotation.MyBatisDao;

/**
 * 客户端日志记录DAO接口
 * @author zhuyuanxin
 * @version 2018-07-17
 */
@MyBatisDao
//@MapperScan("com.taeyeon.zyx.dao")
public interface TbClientReportDao extends CrudDao<TbClientReport> {
//    TbClientReport get(@PathVariable("id") Long id);
}
