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
public class PositionsNGTest {
    
    public PositionsNGTest() {
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
     * Test of getDateTime method, of class Positions.
     */
    @Test(enabled=false)
    public void testGetDateTime() {
        System.out.println("getDateTime");
        Positions instance = new Positions();
        String expResult = "";
        String result = instance.getDateTime();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateTime method, of class Positions.
     */
    @Test
    public void testSetDateTime() {
        System.out.println("setDateTime");
        String dateTime = "";
        Positions instance = new Positions();
        instance.setDateTime(dateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitID method, of class Positions.
     */
    @Test
    public void testGetUnitID() {
        System.out.println("getUnitID");
        Positions instance = new Positions();
        long expResult = 0L;
        long result = instance.getUnitID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitID method, of class Positions.
     */
    @Test
    public void testSetUnitID() {
        System.out.println("setUnitID");
        long unitID = 0L;
        Positions instance = new Positions();
        instance.setUnitID(unitID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRdx method, of class Positions.
     */
    @Test
    public void testGetRdx() {
        System.out.println("getRdx");
        Positions instance = new Positions();
        double expResult = 0.0;
        double result = instance.getRdx();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRdx method, of class Positions.
     */
    @Test
    public void testSetRdx() {
        System.out.println("setRdx");
        double rdx = 0.0;
        Positions instance = new Positions();
        instance.setRdx(rdx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRdy method, of class Positions.
     */
    @Test
    public void testGetRdy() {
        System.out.println("getRdy");
        Positions instance = new Positions();
        double expResult = 0.0;
        double result = instance.getRdy();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRdy method, of class Positions.
     */
    @Test
    public void testSetRdy() {
        System.out.println("setRdy");
        double rdy = 0.0;
        Positions instance = new Positions();
        instance.setRdy(rdy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeed method, of class Positions.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        Positions instance = new Positions();
        int expResult = 0;
        int result = instance.getSpeed();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeed method, of class Positions.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        int speed = 0;
        Positions instance = new Positions();
        instance.setSpeed(speed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourse method, of class Positions.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        Positions instance = new Positions();
        int expResult = 0;
        int result = instance.getCourse();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCourse method, of class Positions.
     */
    @Test
    public void testSetCourse() {
        System.out.println("setCourse");
        int course = 0;
        Positions instance = new Positions();
        instance.setCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumSatellites method, of class Positions.
     */
    @Test
    public void testGetNumSatellites() {
        System.out.println("getNumSatellites");
        Positions instance = new Positions();
        int expResult = 0;
        int result = instance.getNumSatellites();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumSatellites method, of class Positions.
     */
    @Test
    public void testSetNumSatellites() {
        System.out.println("setNumSatellites");
        int numSatellites = 0;
        Positions instance = new Positions();
        instance.setNumSatellites(numSatellites);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHdop method, of class Positions.
     */
    @Test
    public void testGetHdop() {
        System.out.println("getHdop");
        Positions instance = new Positions();
        int expResult = 0;
        int result = instance.getHdop();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHdop method, of class Positions.
     */
    @Test
    public void testSetHdop() {
        System.out.println("setHdop");
        int hdop = 0;
        Positions instance = new Positions();
        instance.setHdop(hdop);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuality method, of class Positions.
     */
    @Test(enabled=false)
    public void testGetQuality() {
        System.out.println("getQuality");
        Positions instance = new Positions();
        String expResult = "";
        String result = instance.getQuality();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuality method, of class Positions.
     */
    @Test
    public void testSetQuality() {
        System.out.println("setQuality");
        String quality = "";
        Positions instance = new Positions();
        instance.setQuality(quality);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAndSplitRowCSV method, of class Positions.
     */
    @Test
    public void testSetAndSplitRowCSV() {
        System.out.println("setAndSplitRowCSV");
        String[] row = new String[]{"123;234;345;456;567;678;789;890;901"};
        Positions instance = new Positions();
        Document expResult = new Document("DateTime", "123")
                .append("UnitId", Long.parseLong("234"))
                .append("Rdx", Double.parseDouble("47.97894290818148"))
                .append("Rdy", Double.parseDouble("3.3179859977348243"))
                .append("Speed", 567)
                .append("Course", 678)
                .append("NumSatellites", 789)
                .append("HDOP", 890)
                .append("Quality", "901");
        Document result = instance.setAndSplitRowCSV(instance, row);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAndSplitRowLive method, of class Positions.
     */
    @Test(enabled=false)
    public void testSetAndSplitRowLive() {
        System.out.println("setAndSplitRowLive");
        Positions position = null;
        String row = "";
        Positions instance = new Positions();
        Document expResult = null;
        Document result = instance.setAndSplitRowLive(position, row);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDoc method, of class Positions.
     */
    /**
* Test of createDoc method, of class Positions.
*/
     @Test
     public void testCreateDoc() {
        System.out.println("createDoc");
        Positions position = null;
        Positions instance = new Positions();
        instance.setCourse(678);
        instance.setDateTime("123");
        instance.setHdop(890);
        instance.setNumSatellites(789);
        instance.setQuality("901");
        instance.setRdx(345);
        instance.setRdy(456);
        instance.setSpeed(567);
        instance.setUnitID(234);
        Document expResult = new Document("DateTime", "123")
                .append("UnitId", Long.parseLong("234"))
                .append("Rdx", Double.parseDouble("345"))
                .append("Rdy", Double.parseDouble("456"))
                .append("Speed", 567)
                .append("Course", 678)
                .append("NumSatellites", 789)
                .append("HDOP", 890)
                .append("Quality", "901");
        Document result = instance.createDoc(position);
        assertEquals(result, expResult);
         System.out.println(expResult);
         System.out.println(result);
// TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
}
    
    
}
