package org.radu.bigdata.dto;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {
	
	@Id
	private int idEvent;
	private static final AtomicInteger count = new AtomicInteger(0);
	private Date reportedTime;
	private String location;
	private int alertCode;
	private String description;
	//private byte[] picture;
	//private User user;
	private String tag;
	

	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", reportedTime=" + reportedTime + ", location=" + location
				+ ", alertCode=" + alertCode + ", description=" + description + ", tag=" + tag + "]";
	}

	public Event(){
		idEvent = count.incrementAndGet();
	}

	public int getIdEvent() {
		return idEvent;
	}
	
	public Date getReportedTime() {
		return reportedTime;
	}
	public void setReportedTime(Date reportedTime) {
		this.reportedTime = reportedTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAlertCode() {
		return alertCode;
	}
	public void setAlertCode(int alertCode) {
		this.alertCode = alertCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	*/
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
