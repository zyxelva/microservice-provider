package com.taeyeon.zyx.entity;

/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taeyeon.zyx.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 客户端日志记录Entity
 * 
 * @author zhuyuanxin
 * @version 2018-07-17
 */
public class TbClientReport extends DataEntity<TbClientReport> {

	private static final long serialVersionUID = 1L;
	private Long uid; // 文件uid
	private Integer type; // 日志上传的原因类型：主动上报、自动拉取、错误触发
	private Integer subType; // 子类型
	private String fileUrl; // 文件URL
	private String feedback; // 反馈内容（长字符串）
	private Date reportTime; // 上报时间
	private String versionName; // 版本名称
	private Integer versionCode; // 版本号
	private String channel; // 发行渠道
	private Integer osType; // OS类型，Android、iOS、WinPhone
	private String osVersion; // OS版本
	private String deviceModel; // 设备型号
	private String appName; // APP名称
	private String deviceId; // 设备ID
	private String macAddr; // macAddr
	private String bizType; // 业务类型
	private String bizId; // 业务标识
	private String fileSize; // 文件大小
	private String phone; // 手机号码
	private String netType; // 网络类型
	private String reserve1; // reserve1
	private String reserve2; // reserve2
	private String reserve3; // reserve3
	private String reserve4; // reserve4
	private String reserve5; // reserve5
	private String reserve6; // reserve6

	private Date queryBeginDate;
	private Date queryEndDate;

	public TbClientReport() {
		super();
	}

	public TbClientReport(Long id) {
		super(id);
	}

	@Length(min = 0, max = 20, message = "文件对应的uid长度必须介于 0 和 20 之间")
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	@Length(min = 0, max = 32, message = "日志上传的原因类型：主动上报、自动拉取、错误触发长度必须介于 0 和 32 之间")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Length(min = 0, max = 32, message = "子类型长度必须介于 0 和 32 之间")
	public Integer getSubType() {
		return subType;
	}

	public void setSubType(Integer subType) {
		this.subType = subType;
	}

	@Length(min = 0, max = 256, message = "文件URL长度必须介于 0 和 256 之间")
	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	@Length(min = 0, max = 64, message = "版本名称长度必须介于 0 和 64 之间")
	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	@Length(min = 0, max = 32, message = "版本号长度必须介于 0 和 32 之间")
	public Integer getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	@Length(min = 0, max = 256, message = "发行渠道长度必须介于 0 和 256 之间")
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Length(min = 0, max = 32, message = "OS类型，Android、iOS、WinPhone长度必须介于 0 和 32 之间")
	public Integer getOsType() {
		return osType;
	}

	public void setOsType(Integer osType) {
		this.osType = osType;
	}

	@Length(min = 0, max = 64, message = "OS版本长度必须介于 0 和 64 之间")
	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	@Length(min = 0, max = 64, message = "设备型号长度必须介于 0 和 64 之间")
	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	@Length(min = 0, max = 64, message = "APP名称长度必须介于 0 和 64 之间")
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Length(min = 0, max = 64, message = "设备ID长度必须介于 0 和 64 之间")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Length(min = 0, max = 64, message = "macAddr长度必须介于 0 和 64 之间")
	public String getMacAddr() {
		return macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	@Length(min = 0, max = 64, message = "业务类型长度必须介于 0 和 64 之间")
	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	@Length(min = 0, max = 64, message = "业务标识长度必须介于 0 和 64 之间")
	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	@Length(min = 0, max = 128, message = "文件大小长度必须介于 0 和 128 之间")
	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@Length(min = 0, max = 128, message = "手机号码长度必须介于 0 和 128 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(min = 0, max = 128, message = "网络类型长度必须介于 0 和 128 之间")
	public String getNetType() {
		return netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	@Length(min = 0, max = 128, message = "reserve1长度必须介于 0 和 128 之间")
	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	@Length(min = 0, max = 128, message = "reserve2长度必须介于 0 和 128 之间")
	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	@Length(min = 0, max = 128, message = "reserve3长度必须介于 0 和 128 之间")
	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	@Length(min = 0, max = 128, message = "reserve4长度必须介于 0 和 128 之间")
	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	@Length(min = 0, max = 128, message = "reserve5长度必须介于 0 和 128 之间")
	public String getReserve5() {
		return reserve5;
	}

	public void setReserve5(String reserve5) {
		this.reserve5 = reserve5;
	}

	@Length(min = 0, max = 128, message = "reserve6长度必须介于 0 和 128 之间")
	public String getReserve6() {
		return reserve6;
	}

	public void setReserve6(String reserve6) {
		this.reserve6 = reserve6;
	}

	public Date getQueryBeginDate() {
		return queryBeginDate;
	}

	public void setQueryBeginDate(Date queryBeginDate) {
		this.queryBeginDate = queryBeginDate;
	}

	public Date getQueryEndDate() {
		return queryEndDate;
	}

	public void setQueryEndDate(Date queryEndDate) {
		this.queryEndDate = queryEndDate;
	}
}