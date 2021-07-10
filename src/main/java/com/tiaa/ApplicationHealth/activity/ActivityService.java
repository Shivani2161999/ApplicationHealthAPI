package com.tiaa.ApplicationHealth.activity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiaa.ApplicationHealth.data.DataController;

@Service
public class ActivityService {
	private ActivityRepo activityRepo;
	
	@Autowired	
	public ActivityService(ActivityRepo activityRepo) {
		super();
		this.activityRepo = activityRepo;
	}
	
	//insert/add all activity status 
	public List<Activity> addAllActivity(List<Activity> list){
		return activityRepo.saveAll(list);
	}
	
	//get/fetch application status by appId
	public Activity getStatusByAppId(Long appId) {
		return activityRepo.findByApplicationAppId(appId);
	}
	
	//get/fetch all application status 
	public List<Activity> getAllActivity(){
		return activityRepo.findAll();
	}

}
