package com.tiaa.ApplicationHealth.application;

import com.tiaa.ApplicationHealth.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
