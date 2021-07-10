package com.tiaa.ApplicationHealth.activity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tiaa.ApplicationHealth.application.Application;

public class GetApplicationIds {
	//create an empty list initially
	private List<Long> oldIdlist =new ArrayList<Long>(); 	
	
	public void checkAllIds(List<Long> newList) {
		List<Activity>updateActivityList;
		if(oldIdlist.isEmpty()) {
			oldIdlist=newList;
			for(long id :newList) {
//				public Activity( int counter, boolean status, LocalDateTime startTime, LocalDateTime endTime, Application application)
//				updateActivityList.add(new Activity(1,true,"06/07/2021 20:00",));
			}
			
		}else {
			
		}
		
	}
	
	
}
