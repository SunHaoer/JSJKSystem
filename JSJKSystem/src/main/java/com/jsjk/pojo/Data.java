package com.jsjk.pojo;

public class Data {
	
	private int id;
	private String dataDate;
	private String dataTime;
	private int heartRate;
	private int fatigue;
	private int bloodPressure1;
	private int bloodPressure2;
	private int alcoholConcentration;
	
	public Data() {
		
	}
	
	
	public Data(String dataDate, String dataTime, int heartRate, int bloodPressure1, int bloodPressure2,
			int alcoholConcentration, int fatigue) {
		super();
		this.dataDate = dataDate;
		this.dataTime = dataTime;
		this.heartRate = heartRate;
		this.bloodPressure1 = bloodPressure1;
		this.bloodPressure2 = bloodPressure2;
		this.alcoholConcentration = alcoholConcentration;
		this.fatigue = fatigue;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDataDate() {
		return dataDate;
	}


	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}


	public String getDataTime() {
		return dataTime;
	}


	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
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


	@Override
	public String toString() {
		return "Data [id=" + id + ", dataDate=" + dataDate + ", dataTime=" + dataTime + ", heartRate=" + heartRate
				+ ", fatigue=" + fatigue + ", bloodPressure1=" + bloodPressure1 + ", bloodPressure2=" + bloodPressure2
				+ ", alcoholConcentration=" + alcoholConcentration + "]";
	}
	
	
}
