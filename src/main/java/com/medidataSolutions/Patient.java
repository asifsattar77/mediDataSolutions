package com.medidataSolutions;

public class Patient {
	
	private String name = "anonymous";
	
	private int age = 0;
	
	private String insuranceProvider = "";
	
	private String physicianInsuranceAffiliation = "";
	
	private int noVaccines = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public String getPhysicianInsuranceAffiliation() {
		return physicianInsuranceAffiliation;
	}

	public void setPhysicianInsuranceAffiliation(String physicianInsuranceAffiliation) {
		this.physicianInsuranceAffiliation = physicianInsuranceAffiliation;
	}

	public int getNoVaccines() {
		return noVaccines;
	}

	public void setNoVaccines(int noVaccines) {
		this.noVaccines = noVaccines;
	}



}
