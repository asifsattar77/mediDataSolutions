package com.medidataSolutions;

public abstract class MedicalService {
	
	private double discountSixtyToSeventy = 0.6;
	
	private double discountOverSeventy = 0.9;
	
	private double discountUnderFive = 0.4;
	
	private double discountMediHealth = 0.15;

	public double getDiscountSixtyToSeventy() {
		return discountSixtyToSeventy;
	}

	public void setDiscountSixtyToSeventy(float discountSixtyToSeventy) {
		this.discountSixtyToSeventy = discountSixtyToSeventy;
	}

	public double getDiscountOverSeventy() {
		return discountOverSeventy;
	}

	public void setDiscountOverSeventy(float discountOverSeventy) {
		this.discountOverSeventy = discountOverSeventy;
	}

	public double getDiscountUnderFive() {
		return discountUnderFive;
	}

	public void setDiscountUnderFive(float discountUnderFive) {
		this.discountUnderFive = discountUnderFive;
	}

	public double getDiscountMediHealth() {
		return discountMediHealth;
	}

	public void setDiscountMediHealth(float discountMediHealth) {
		this.discountMediHealth = discountMediHealth;
	}
	
	public abstract double getPrice();
	
	public abstract void setPrice(double price);

}
