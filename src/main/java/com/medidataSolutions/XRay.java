package com.medidataSolutions;

public class XRay extends MedicalService {

	private static double price = 150;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		XRay.price = price;
	}	

}
