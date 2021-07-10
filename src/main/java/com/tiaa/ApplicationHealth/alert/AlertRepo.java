package com.tiaa.ApplicationHealth.alert;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepo extends JpaRepository<Alert, Long> {
    public List<Alert> findByApplicationAppId(Long id);
}
