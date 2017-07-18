package com.medidataSolutions;

public class ECG extends MedicalService{
	
	private static double price = 200.40;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		ECG.price = price;
	}	


}
