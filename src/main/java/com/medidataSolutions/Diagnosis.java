package com.medidataSolutions;

public class Diagnosis extends MedicalService {
	
	private static double price = 60;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		Diagnosis.price = price;
	}	

}
