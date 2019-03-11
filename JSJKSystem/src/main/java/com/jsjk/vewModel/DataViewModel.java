package com.jsjk.vewModel;

import com.jsjk.pojo.Data;

public class DataViewModel {
	
	private int heartRate;
	private int fatigue;
	private int bloodPressure1;
	private int bloodPressure2;
	private int alcoholConcentration;
	private int nowStatus;	// 
	private int alcoholConcentrationStatus; 	// 酒精浓度状态
	private int fatigueStatus;	// 疲劳度状态
	private int heartRateStatus;	// 心率状态
	private int bloodPressure1Status;	// 血压状态1
	private int bloodPressure2Status;	// 血压状态2
	
	

	
	public DataViewModel(int heartRate, int fatigue, int bloodPressure1, int bloodPressure2, int alcoholConcentration) {
		super();
		this.heartRate = heartRate;
		this.fatigue = fatigue;
		this.bloodPressure1 = bloodPressure1;
		this.bloodPressure2 = bloodPressure2;
		this.alcoholConcentration = alcoholConcentration;
	}
	public int getNowStatus() {
		return nowStatus;
	}
	public void setNowStatus(int nowStatus) {
		this.nowStatus = nowStatus;
	}
	public int getAlcoholConcentrationStatus() {
		return alcoholConcentrationStatus;
	}
	public void setAlcoholConcentrationStatus(int alcoholConcentrationStatus) {
		this.alcoholConcentrationStatus = alcoholConcentrationStatus;
	}
	public int getFatigueStatus() {
		return fatigueStatus;
	}
	public void setFatigueStatus(int fatigueStatus) {
		this.fatigueStatus = fatigueStatus;
	}
	public int getHeartRateStatus() {
		return heartRateStatus;
	}
	public void setHeartRateStatus(int heartRateStatus) {
		this.heartRateStatus = heartRateStatus;
	}
	public int getBloodPressure1Status() {
		return bloodPressure1Status;
	}
	public void setBloodPressure1Status(int bloodPressure1Status) {
		this.bloodPressure1Status = bloodPressure1Status;
	}
	public int getBloodPressure2Status() {
		return bloodPressure2Status;
	}
	public void setBloodPressure2Status(int bloodPressure2Status) {
		this.bloodPressure2Status = bloodPressure2Status;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	public int getFatigue() {
		return fatigue;
	}
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}
	public int getBloodPressure1() {
		return bloodPressure1;
	}
	public void setBloodPressure1(int bloodPressure1) {
		this.bloodPressure1 = bloodPressure1;
	}
	public int getBloodPressure2() {
		return bloodPressure2;
	}
	public void setBloodPressure2(int bloodPressure2) {
		this.bloodPressure2 = bloodPressure2;
	}
	public int getAlcoholConcentration() {
		return alcoholConcentration;
	}
	public void setAlcoholConcentration(int alcoholConcentration) {
		this.alcoholConcentration = alcoholConcentration;
	}
	
	
	

}
