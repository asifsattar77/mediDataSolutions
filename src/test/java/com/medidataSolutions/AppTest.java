package com.medidataSolutions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Object Creation
     */
    public void testBillingEngineTestObject()
    {
        BillingEngine testBillingEngine = new BillingEngine();
    	assertNotNull(testBillingEngine);
    }
    
    /**
     * Object Creation
     */
    public void testPatientTestObject()
    {
        Patient testPatient = new Patient();
    	assertNotNull(testPatient);
    }
    
    /**
     * No Discount
     */
    public void testPatientWithoutDiscount()
    {
        BillingEngine testBillingEngine1 = new BillingEngine();
        Patient testPatient1 = new Patient();
        Diagnosis testDiagnosis1 = new Diagnosis();
        XRay testXray1 = new XRay();
        BloodTest testBloodTest1 = new BloodTest();
        ECG testECG1 = new ECG();
        Vaccine testVaccine1 = new Vaccine();
        testPatient1.setAge(50);
        testPatient1.setNoVaccines(2);
        assertEquals(60.00, testBillingEngine1.getPrice(testPatient1, testDiagnosis1)); //£60
        assertEquals(150.00, testBillingEngine1.getPrice(testPatient1, testXray1)); //£150
        assertEquals(78.00, testBillingEngine1.getPrice(testPatient1, testBloodTest1)); //£78
        assertEquals(200.40, testBillingEngine1.getPrice(testPatient1, testECG1)); //£200.40
        assertEquals(57.50, testBillingEngine1.getPrice(testPatient1, testVaccine1)); //(£27.50 + £30)
        
    }    
    
    /**
     * Senior Citizens (65-70 inclusive) receive a 60% discount
     */
    public void testSeniorCitizenSixtyToSeventyDiscount()
    {
        BillingEngine testBillingEngine = new BillingEngine();
        Patient testPatient = new Patient();
        Diagnosis testDiagnosis = new Diagnosis();
        XRay testXray = new XRay();
        BloodTest testBloodTest = new BloodTest();
        ECG testECG = new ECG();
        Vaccine testVaccine = new Vaccine();
        testPatient.setAge(65);
        testPatient.setNoVaccines(1);
        assertEquals(24.00, testBillingEngine.getPrice(testPatient, testDiagnosis)); //£60 * (1 - 0.6)
        assertEquals(60.00, testBillingEngine.getPrice(testPatient, testXray)); //£150 * (1 - 0.6)
        assertEquals(31.20, testBillingEngine.getPrice(testPatient, testBloodTest)); //£78 * (1 - 0.6)
        assertEquals(80.16, testBillingEngine.getPrice(testPatient, testECG)); //£200.40 * (1 - 0.6)
        assertEquals(17.00, testBillingEngine.getPrice(testPatient, testVaccine)); //(£27.50 + £15) * (1 - 0.6)
        testPatient.setInsuranceProvider("MediHealth");
        testPatient.setPhysicianInsuranceAffiliation("MediHealth");
        assertEquals(26.52, testBillingEngine.getPrice(testPatient, testBloodTest)); //£78 * (1 - 0.6) * (1 - 0.15)
        
    }
    
    /**
     * Senior Citizens (Over 70) receive a 90% discount
     */
    public void testSeniorCitizenOverSeventyDiscount()
    {
        BillingEngine testBillingEngine = new BillingEngine();
        Patient testPatient = new Patient();
        Diagnosis testDiagnosis = new Diagnosis();
        XRay testXray = new XRay();
        BloodTest testBloodTest = new BloodTest();
        ECG testECG = new ECG();
        Vaccine testVaccine = new Vaccine();
        testPatient.setAge(80);
        testPatient.setNoVaccines(1);
        assertEquals(6.00, testBillingEngine.getPrice(testPatient, testDiagnosis)); //£60 * (1 - 0.9)
        assertEquals(15.00, testBillingEngine.getPrice(testPatient, testXray)); //£150 * (1 - 0.9)
        assertEquals(7.80, testBillingEngine.getPrice(testPatient, testBloodTest)); //£78 * (1 - 0.9)
        assertEquals(20.04, testBillingEngine.getPrice(testPatient, testECG)); //£200.40 * (1 - 0.9)
        assertEquals(4.25, testBillingEngine.getPrice(testPatient, testVaccine)); //(£27.50 + £15) * (1 - 0.9)
        testPatient.setInsuranceProvider("MediHealth");
        testPatient.setPhysicianInsuranceAffiliation("MediHealth");
        assertEquals(6.63, testBillingEngine.getPrice(testPatient, testBloodTest)); //£78 * (1 - 0.9) * (1 - 0.15)
        
    }
    
    /**
     * Young patients (less than 5) receive a 40% discount
     */
    public void testPatientsLessThanFiveDiscount()
    {
        BillingEngine testBillingEngine = new BillingEngine();
        Patient testPatient = new Patient();
        Diagnosis testDiagnosis = new Diagnosis();
        XRay testXray = new XRay();
        BloodTest testBloodTest = new BloodTest();
        ECG testECG = new ECG();
        Vaccine testVaccine = new Vaccine();
        testPatient.setAge(3);
        testPatient.setNoVaccines(1);
        assertEquals(36.00, testBillingEngine.getPrice(testPatient, testDiagnosis)); //£60 * (1 - 0.4)
        assertEquals(90.00, testBillingEngine.getPrice(testPatient, testXray)); //£150 * (1 - 0.4)
        assertEquals(46.80, testBillingEngine.getPrice(testPatient, testBloodTest)); //£78 * (1 - 0.4)
        assertEquals(120.24, testBillingEngine.getPrice(testPatient, testECG)); //£200.40 * (1 - 0.4)
        assertEquals(25.50, testBillingEngine.getPrice(testPatient, testVaccine)); //(£27.50 + £15) * (1 - 0.4)
        testPatient.setInsuranceProvider("MediHealth");
        testPatient.setPhysicianInsuranceAffiliation("MediHealth");
        assertEquals(39.78, testBillingEngine.getPrice(testPatient, testBloodTest)); //£78 * (1 - 0.4) * (1 - 0.15)
        
    }    
    
}
