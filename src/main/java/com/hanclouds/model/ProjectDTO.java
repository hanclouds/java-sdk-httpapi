package com.hanclouds.model;

import java.util.Date;

/**
 * @author majiwei
 * @date 2019/7/24
 */
public class ProjectDTO
{
  private String projectKey;
  private String projectName;
  private String userKey;
  private String industryName;
  private String descr;
  private Date createAt;
  private Date updateAt;
  private Integer status;

  public String getProjectKey() {
    return projectKey;
  }

  public void setProjectKey(String projectKey) {
    this.projectKey = projectKey;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getUserKey() {
    return userKey;
  }

  public void setUserKey(String userKey) {
    this.userKey = userKey;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getIndustryName()
  {
    return industryName;
  }

  public void setIndustryName(String industryName)
  {
    this.industryName = industryName;
  }

  @Override
  public String toString()
  {
    return "ProjectDTO{" +
            "projectKey='" + projectKey + '\'' +
            ", projectName='" + projectName + '\'' +
            ", userKey='" + userKey + '\'' +
            ", industryName='" + industryName + '\'' +
            ", descr='" + descr + '\'' +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", status=" + status +
            '}';
  }
}
