package com.tiaa.ApplicationHealth.activity;


import org.springframework.data.jpa.repository.JpaRepository;



public interface ActivityRepo extends JpaRepository<Activity, Long> {
	 public Activity findByApplicationAppId(Long id);
}
