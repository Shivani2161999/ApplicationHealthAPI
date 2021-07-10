package com.tiaa.ApplicationHealth.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {
    private AlertRepo alertRepo;

    @Autowired
    public AlertService(AlertRepo alertRepo) {
        this.alertRepo = alertRepo;
    }

    public Alert addAlert(Alert alert){
        return alertRepo.save(alert);
    }

    public List<Alert> getAllAlerts(){
        return alertRepo.findAll();
    }

    public List<Alert> getAlertByAppId(Long appId){
        List<Alert> alerts = new ArrayList<>();
        alertRepo.findByApplicationAppId(appId).forEach(alerts::add);
        return alerts;
    }

}
