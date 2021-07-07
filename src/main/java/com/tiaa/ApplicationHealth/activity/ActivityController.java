package com.tiaa.ApplicationHealth.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ActivityController {
	
	private final ActivityService activityService;

	@Autowired
	public ActivityController(ActivityService activityService) {
		super();
		this.activityService = activityService;
	}
	
	//add/update all Status
	@PostMapping("/updateStatus")
	public ResponseEntity<?> addAllActivity(@RequestBody List<Activity> list){
		List<Activity> newlist=activityService.addAllActivity(list);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//get/fetch status of specified application with appId
	@GetMapping("/{appId}/status")
	public ResponseEntity<Activity>  getStatusByAppId(@PathVariable long appId) {
		Activity activity = activityService.getStatusByAppId(appId);
		return new ResponseEntity<>(activity, HttpStatus.OK);
	}
	
	
	//get/fetch all application status 
	@PostMapping("/allStatus")
	public List<Activity> getAllActivity(){
		return activityService.getAllActivity();
	}

}
