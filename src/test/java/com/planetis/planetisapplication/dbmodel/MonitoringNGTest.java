/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.dbmodel;

import org.bson.Document;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Donovan
 */
public class MonitoringNGTest {
    
    public MonitoringNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getUnitID method, of class Monitoring.
     */
    @Test
    public void testGetUnitID() {
        System.out.println("getUnitID");
        Monitoring instance = new Monitoring();
        long expResult = 0L;
        long result = instance.getUnitID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitID method, of class Monitoring.
     */
    @Test
    public void testSetUnitID() {
        System.out.println("setUnitID");
        long unitID = 0L;
        Monitoring instance = new Monitoring();
        instance.setUnitID(unitID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBeginTime method, of class Monitoring.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        Monitoring instance = new Monitoring();
        String expResult = "";
        String result = instance.getBeginTime();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateTime method, of class Monitoring.
     */
    @Test
    public void testSetDateTime() {
        System.out.println("setDateTime");
        String beginTime = "";
        Monitoring instance = new Monitoring();
        instance.setDateTime(beginTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndTime method, of class Monitoring.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Monitoring instance = new Monitoring();
        String expResult = "";
        String result = instance.getEndTime();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndTime method, of class Monitoring.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        String endTime = "";
        Monitoring instance = new Monitoring();
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Monitoring.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Monitoring instance = new Monitoring();
        String expResult = "";
        String result = instance.getType();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Monitoring.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Monitoring instance = new Monitoring();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMin method, of class Monitoring.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        Monitoring instance = new Monitoring();
        double expResult = 0.0;
        double result = instance.getMin();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMin method, of class Monitoring.
     */
    @Test
    public void testSetMin() {
        System.out.println("setMin");
        double min = 0.0;
        Monitoring instance = new Monitoring();
        instance.setMin(min);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMax method, of class Monitoring.
     */
    @Test
    public void testGetMax() {
        System.out.println("getMax");
        Monitoring instance = new Monitoring();
        double expResult = 0.0;
        double result = instance.getMax();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMax method, of class Monitoring.
     */
    @Test
    public void testSetMax() {
        System.out.println("setMax");
        double max = 0.0;
        Monitoring instance = new Monitoring();
        instance.setMax(max);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSum method, of class Monitoring.
     */
    @Test
    public void testGetSum() {
        System.out.println("getSum");
        Monitoring instance = new Monitoring();
        String expResult = "";
        String result = instance.getSum();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSum method, of class Monitoring.
     */
    @Test
    public void testSetSum() {
        System.out.println("setSum");
        String sum = "";
        Monitoring instance = new Monitoring();
        instance.setSum(sum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAndSplitRowCSV method, of class Monitoring.
     */
    @Test
    public void testSetAndSplitRowCSV() {
        System.out.println("setAndSplitRowCSV");
        Monitoring monitor = null;
        String[] row = null;
        Monitoring instance = new Monitoring();
        Document expResult = null;
        Document result = instance.setAndSplitRowCSV(monitor, row);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAndSplitRowLive method, of class Monitoring.
     */
    @Test
    public void testSetAndSplitRowLive() {
        System.out.println("setAndSplitRowLive");
        Monitoring monitor = null;
        String row = "";
        Monitoring instance = new Monitoring();
        Document expResult = null;
        Document result = instance.setAndSplitRowLive(monitor, row);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDoc method, of class Monitoring.
     */
    @Test
    public void testCreateDoc() {
        System.out.println("createDoc");
        Monitoring monitoring = null;
        Monitoring instance = new Monitoring();
        Document expResult = null;
        Document result = instance.createDoc(monitoring);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
