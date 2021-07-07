package com.tiaa.ApplicationHealth.alert.parameters;

import com.tiaa.ApplicationHealth.alert.Alert;
import com.tiaa.ApplicationHealth.alert.AlertService;
import com.tiaa.ApplicationHealth.data.Data;
import org.springframework.web.client.RestTemplate;

public class ParameterValueChecker {

    private Long memoryLimit = 1000000000L;
    private Long diskLimit = 1000000000L;
    private double cpuLimit = 50;
    private int threadLimit = 1000;

    private String alertType;
    private Long parameterValue;

    public ParameterValueChecker() {

    }

    public void checkParameters(Data data){
        Alert alert;
        //Set the alert type and it's unit
        if(data.getMemoryUsage() > memoryLimit){
            alertType = "MemoryAlert";
            parameterValue = data.getMemoryUsage();
        }
        else if(data.getDiskUsage() > diskLimit){
            alertType = "DiskAlert";
            parameterValue = data.getDiskUsage();
        }
        else if(data.getCpuUsage() > cpuLimit){
            alertType = "CPUAlert";
            parameterValue = (long)data.getCpuUsage();
        }
        else if(data.getNumberOfThread() > threadLimit){
            alertType = "ThreadAlert";
            parameterValue = (long)data.getNumberOfThread();
        }
        else{
            return;
        }

        //Create new alert and call addAlert endpoint
        alert = new Alert(data.getCurrentTime(), alertType, parameterValue, data.getApplication());
        String uri = "http://localhost:8080/application/addAlert";
        RestTemplate restTemplate = new RestTemplate();
        Alert result = restTemplate.postForObject(uri, alert, Alert.class);

    }
}
