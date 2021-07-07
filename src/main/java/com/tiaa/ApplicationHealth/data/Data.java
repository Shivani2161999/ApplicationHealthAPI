package com.tiaa.ApplicationHealth.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiaa.ApplicationHealth.application.Application;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dataId;
    @Column(name="`currentTime`")
    //@Convert(converter = LocalDateTimeConverter.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime currentTime;
    @Column(name="`memoryUsage`")
    private long memoryUsage;
    @Column(name="`diskUsage`")
    private long diskUsage;
    @Column(name="`cpuUsage`")
    private double cpuUsage;
    private int numberOfThread;

    @ManyToOne
    private Application application;
    private Long applicationID;

    public Data() {
    }

    public Data(long dataId, LocalDateTime currentTime, long memoryUsage, long diskUsage, int numberOfThread, double cpuUsage, Application application, Long applicationID) {
        this.dataId = dataId;
        this.currentTime = currentTime;
        this.memoryUsage = memoryUsage;
        this.diskUsage = diskUsage;
        this.numberOfThread = numberOfThread;
        this.cpuUsage = cpuUsage;
        this.application = application;
        this.applicationID = applicationID;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public long getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(long memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public long getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(long diskUsage) {
        this.diskUsage = diskUsage;
    }

    public int getNumberOfThread() {
        return numberOfThread;
    }

    public void setNumberOfThread(int numberOfThread) {
        this.numberOfThread = numberOfThread;
    }


    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Long applicationID) {
        this.applicationID = applicationID;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dataId=" + dataId +
                ", currentTime=" + currentTime +
                ", memoryUsage=" + memoryUsage +
                ", diskUsage=" + diskUsage +
                ", cpuUsage=" + cpuUsage +
                ", numberOfThread=" + numberOfThread +
                ", application=" + application +
                ", applicationId=" + applicationID +
                '}';
    }
}
