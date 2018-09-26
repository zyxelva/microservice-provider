package com.taeyeon.zyx.application;

import com.taeyeon.zyx.dto.TbTeacherDto;
import com.taeyeon.zyx.entity.TbTeacher;
import com.taeyeon.zyx.service.TbTeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lynn on 2018/4/18.
 */
@Service("teacherApplication")
public class TeacherApplicationImpl implements TeacherApplication {

	private static final Logger logger = LoggerFactory.getLogger(TeacherApplicationImpl.class);

	@Autowired
	private TbTeacherService tbTeacherService;


	@Override
	public TbTeacherDto getByUid(Long uid) {
		if (uid<=0) {
			logger.error("getByUid, but uid is not valid.");
			return null;
		}

		TbTeacher tbTeacher = tbTeacherService.get(uid);
		if (null == tbTeacher) {
			logger.debug("get tbTeacher error, tbTeacher is not exist. uid:{}", uid);
			return null;
		}
		return null;
	}
}
