package com.tiaa.ApplicationHealth.activity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiaa.ApplicationHealth.application.Application;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long activityId;
	private int counter;
	private boolean status;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
	
	@OneToOne
	private Application application;

	
	public Activity() { }


	public Activity(long activityId, int counter, boolean status, LocalDateTime startTime, LocalDateTime endTime, Application application) {
		super();
		this.activityId = activityId;
		this.counter = counter;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.application = application;
	}
	
	public Activity( int counter, boolean status, LocalDateTime startTime, LocalDateTime endTime, Application application) {
		this.counter = counter;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.application = application;
	}


	public long getActivityId() {
		return activityId;
	}


	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;

	}


	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) {
		this.application = application;
	}


	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", counter=" + counter + ", status=" + status + ", startTime="
				+ startTime + ", endTime=" + endTime + ", application=" + application + "]";
	}
	
		
}
