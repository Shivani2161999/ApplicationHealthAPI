package com.tiaa.ApplicationHealth.application;

import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long appId;
    private String path;
    private String port;
    private String packageName;
    private String applicationName;

    public Application() {
    }

    public Application(long appId, String path, String port, String packageName, String applicationName) {
        this.appId = appId;
        this.path = path;
        this.port = port;
        this.packageName = packageName;
        this.applicationName = applicationName;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appId=" + appId +
                ", path='" + path + '\'' +
                ", port=" + port +
                ", packageName='" + packageName + '\'' +
                ", applicationName='" + applicationName + '\'' +
                '}';
    }
}
