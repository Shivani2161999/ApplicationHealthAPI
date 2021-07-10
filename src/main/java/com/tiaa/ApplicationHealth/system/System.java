package com.tiaa.ApplicationHealth.system;

public class System {
	private long totalDisk;
	private int usedMemory;
	private double cpuLoad;
	private int availableMemory;
	private int numberOfThread;
	private long usedDisk;
	private long availableDisk;
	
	
	
	public System() {
		
	}

	public System(long totalDisk, int usedMemory, double cpuLoad, int availableMemory, int numberOfThread,
			long usedDisk, long availableDisk) {
		super();
		this.totalDisk = totalDisk;
		this.usedMemory = usedMemory;
		this.cpuLoad = cpuLoad;
		this.availableMemory = availableMemory;
		this.numberOfThread = numberOfThread;
		this.usedDisk = usedDisk;
		this.availableDisk = availableDisk;
	}
	
	public long getTotalDisk() {
		return totalDisk;
	}
	public void setTotalDisk(long totalDisk) {
		this.totalDisk = totalDisk;
	}
	public int getUsedMemory() {
		return usedMemory;
	}
	public void setUsedMemory(int usedMemory) {
		this.usedMemory = usedMemory;
	}
	public double getCpuLoad() {
		return cpuLoad;
	}
	public void setCpuLoad(double cpuLoad) {
		this.cpuLoad = cpuLoad;
	}
	public int getAvailableMemory() {
		return availableMemory;
	}
	public void setAvailableMemory(int availableMemory) {
		this.availableMemory = availableMemory;
	}
	public int getNumberOfThread() {
		return numberOfThread;
	}
	public void setNumberOfThread(int numberOfThread) {
		this.numberOfThread = numberOfThread;
	}
	public long getUsedDisk() {
		return usedDisk;
	}
	public void setUsedDisk(long usedDisk) {
		this.usedDisk = usedDisk;
	}
	public long getAvailableDisk() {
		return availableDisk;
	}
	public void setAvailableDisk(long availableDisk) {
		this.availableDisk = availableDisk;
	}

	@Override
	public String toString() {
		return "System [totalDisk=" + totalDisk + ", usedMemory=" + usedMemory + ", cpuLoad=" + cpuLoad
				+ ", availableMemory=" + availableMemory + ", numberOfThread=" + numberOfThread + ", usedDisk="
				+ usedDisk + ", availableDisk=" + availableDisk + "]";
	}

	
}
