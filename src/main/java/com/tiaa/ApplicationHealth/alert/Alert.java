package com.tiaa.ApplicationHealth.alert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiaa.ApplicationHealth.application.Application;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long alertId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private String parameter;
    private Long unit;

    @ManyToOne
    private Application application;

    public Alert() {
    }

    public Alert(LocalDateTime time, String parameter, Long unit, Application application) {
        this.time = time;
        this.parameter = parameter;
        this.unit = unit;
        this.application = application;
    }

    public Alert(Long alertId, LocalDateTime time, String parameter, Long unit, Application application) {
        this.alertId = alertId;
        this.time = time;
        this.parameter = parameter;
        this.unit = unit;
        this.application = application;
    }

    public Long getAlertId() {
        return alertId;
    }

    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertId=" + alertId +
                ", time=" + time +
                ", parameter='" + parameter + '\'' +
                ", unit=" + unit +
                ", application=" + application +
                '}';
    }
}
