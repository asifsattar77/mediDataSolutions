package com.medidataSolutions;

import java.text.DecimalFormat;

public class BillingEngine {
	
	DecimalFormat df = new DecimalFormat("###.##");
	
	public double getPrice(Patient patient, MedicalService service) {
		double price = 0;
		if (patient.getAge() >= 65 && patient.getAge() <= 70) {
			price = getPriceForServiceForSixtyFiveToSeventy(patient, service);
		}
		else if (patient.getAge() > 70) {
			price = getPriceForServiceForSeventyPlus(patient, service);
		}
		else if (patient.getAge() < 5) {
			price = getPriceForServiceForLessThanFive(patient, service);
		}	
		else {
			price = getPriceForRegular(patient, service);
		}
		return price;
	}
	
	private double getPriceForServiceForSixtyFiveToSeventy(Patient patient, MedicalService service) {
		double price = 0;
		if (service instanceof Vaccine) {
			price = ((service.getPrice() + ((Vaccine) service).getPerVaccinePrice() * patient.getNoVaccines()) * (1 - service.getDiscountSixtyToSeventy())) ;
		}
		else if ((service instanceof BloodTest) && patient.getInsuranceProvider().equals("MediHealth") && patient.getPhysicianInsuranceAffiliation().equals("MediHealth")) {
			price = (service.getPrice()  * (1 - service.getDiscountSixtyToSeventy())) * (1 - service.getDiscountMediHealth()) ;
		}
		else {
			price = service.getPrice() * (1 - service.getDiscountSixtyToSeventy());
		}

		return Double.parseDouble(df.format(price));
	}
	
	private double getPriceForServiceForSeventyPlus(Patient patient, MedicalService service) {
		double price = 0;
		if (service instanceof Vaccine) {
			price = ((service.getPrice() + ((Vaccine) service).getPerVaccinePrice() * patient.getNoVaccines()) * (1 - service.getDiscountOverSeventy())) ;
		}
		else if ((service instanceof BloodTest) && patient.getInsuranceProvider().equals("MediHealth") && patient.getPhysicianInsuranceAffiliation().equals("MediHealth")) {
			price = (service.getPrice()  * (1 - service.getDiscountOverSeventy())) * (1 - service.getDiscountMediHealth()) ;
		}		
		else {
			price = service.getPrice() * (1 - service.getDiscountOverSeventy());
		}

		return Double.parseDouble(df.format(price));
	}
	
	private double getPriceForServiceForLessThanFive(Patient patient, MedicalService service) {
		double price = 0;
		if (service instanceof Vaccine) {
			price = ((service.getPrice() + ((Vaccine) service).getPerVaccinePrice() * patient.getNoVaccines()) * (1 - service.getDiscountUnderFive())) ;
		}
		else if ((service instanceof BloodTest) && patient.getInsuranceProvider().equals("MediHealth") && patient.getPhysicianInsuranceAffiliation().equals("MediHealth")) {
			price = (service.getPrice()  * (1 - service.getDiscountUnderFive())) * (1 - service.getDiscountMediHealth()) ;
		}	
		else {
			price = service.getPrice() * (1 - service.getDiscountUnderFive());
		}

		return Double.parseDouble(df.format(price));
	}
	
	private double getPriceForRegular(Patient patient, MedicalService service) {
		double price = 0;
		if (service instanceof Vaccine) {
			price = ((service.getPrice() + ((Vaccine) service).getPerVaccinePrice() * patient.getNoVaccines()));
		}
		else if ((service instanceof BloodTest) && patient.getInsuranceProvider().equals("MediHealth") && patient.getPhysicianInsuranceAffiliation().equals("MediHealth")) {
			price = (service.getPrice() * (1 - service.getDiscountMediHealth())) ;
		}		
		else {
			price = service.getPrice();
		}

		return Double.parseDouble(df.format(price));
	}

}
