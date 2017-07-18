package com.medidataSolutions;

public class Vaccine extends MedicalService {

	private static double price = 27.50;
	
	private static double perVaccinePrice = 15;

	public double getPrice() {
		return price;
	}

	public void setPrice(double theprice) {
		Vaccine.price = theprice;
	}

	public double getPerVaccinePrice() {
		return perVaccinePrice;
	}

	public void setPerVaccinePrice(double perVaccinePrice) {
		Vaccine.perVaccinePrice = perVaccinePrice;
	}	


}
