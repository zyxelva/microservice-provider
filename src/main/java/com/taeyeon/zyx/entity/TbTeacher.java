/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.entity;


import java.util.List;

/**
 * 河马老师Entity
 *
 * @author lizhuo
 * @version 2018-04-14
 */
public class TbTeacher extends DataEntity<TbTeacher> {

    private static final long serialVersionUID = -1686002139318426670L;

    private Long uid; //uid
    private Integer type;//老师类型 1 正式老师 2 MOCK老师
    private Integer subjectId; // 科目ID
    private String school; // 毕业学校
    private String diploma; // 学历
    private String diplomaPic; // 学历照片URL
    private String teachAge; // 教龄
    private String selfIntro; // 简介
    private Integer source;// 老师来源 0:招聘 1:录入
    private String teachingSchool;// 任教学校
    private Integer jobTitle;// 职称
    private Integer state;// 状态 0:正常 10:冻结 20 解约
    private String comment;// 备注

    // 查询参数
    private List<Long> uids;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getDiplomaPic() {
        return diplomaPic;
    }

    public void setDiplomaPic(String diplomaPic) {
        this.diplomaPic = diplomaPic;
    }

    public String getTeachAge() {
        return teachAge;
    }

    public void setTeachAge(String teachAge) {
        this.teachAge = teachAge;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getTeachingSchool() {
        return teachingSchool;
    }

    public void setTeachingSchool(String teachingSchool) {
        this.teachingSchool = teachingSchool;
    }

    public Integer getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Integer jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Long> getUids() {
        return uids;
    }

    public void setUids(List<Long> uids) {
        this.uids = uids;
    }
}