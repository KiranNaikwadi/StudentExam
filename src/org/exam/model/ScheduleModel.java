package org.exam.model;

import java.sql.Date;

public class ScheduleModel {
	private int schid;
	public ScheduleModel() {
		
	}
	public ScheduleModel(Date examDate,String startTime,String endTime,int examid) {
		//this.name=name;
		this.examDate=examDate;
		this.startTime=startTime;
		this.endTime=endTime;
		this.examid=examid;
		}
	private int examid;
	private Date examDate;
	private String startTime,endTime;
	public int getSchid() {
		return schid;
	}
	public void setSchid(int schid) {
		this.schid = schid;
	}
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	

}
