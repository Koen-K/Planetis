/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.dbmodel;

import java.awt.Event;
import java.util.List;
import org.bson.Document;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Donovan
 */
public class EventsNGTest {
    
    public EventsNGTest() {
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
     * Test of getDateTime method, of class Events.
     */
    @DataProvider()
    public void testGetDateTime() {
        System.out.println("getDateTime");
        Events instance = new Events();
        String expResult = "";
        String result = instance.getDateTime();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateTime method, of class Events.
     */
    @Test
    public void testSetDateTime() {
        System.out.println("setDateTime");
        String dateTime = "";
        Events instance = new Events();
        instance.setDateTime(dateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitID method, of class Events.
     */
    @Test
    public void testGetUnitID() {
        System.out.println("getUnitID");
        Events instance = new Events();
        long expResult = 0L;
        long result = instance.getUnitID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitID method, of class Events.
     */
    @Test
    public void testSetUnitID() {
        System.out.println("setUnitID");
        long unitID = 0L;
        Events instance = new Events();
        instance.setUnitID(unitID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPort method, of class Events.
     */
    @Test
    public void testGetPort() {
        System.out.println("getPort");
        Events instance = new Events();
        String expResult = null;
        String result = instance.getPort();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPort method, of class Events.
     */
    @Test
    public void testSetPort() {
        System.out.println("setPort");
        String port = null;
        Events instance = new Events();
        instance.setPort(port);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Events.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Events instance = new Events();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Events.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int value = 0;
        Events instance = new Events();
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAndSplitRowCSV method, of class Events.
     */
    @Test
    public void testSetAndSplitRowCSV() {
        System.out.println("setAndSplitRowCSV");
        Events instance = new Events();
        String[] row = new String[]{"1234;2345;3456;4567"};     
        Document expResult = new Document()
                .append("DateTime", "1234")
                .append("UnitId", Long.parseLong("2345"))
                .append("Port", "3456")
                .append("Value", 4567);
        Document result = instance.setAndSplitRowCSV(instance, row);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAndSplitRowLive method, of class Events.
     */
    @Test
    public void testSetAndSplitRowLive() {
        System.out.println("setAndSplitRowLive");
        String row = "{\"port\":\"3456\",\"value\":4567,\"dateTime\":\"1234\",\"unitId\":2345}";
        Events instance = new Events();
        Document expResult = new Document()
                .append("DateTime", "1234")
                .append("UnitId", Long.parseLong("2345"))
                .append("Port", "3456")
                .append("Value", 4567);
        Document result = instance.setAndSplitRowLive(instance, row);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createDoc method, of class Events.
     */
    /**
* Test of createDoc method, of class Events.
*/
    @Test(priority=1)
    public void testCreateDoc() {
        System.out.println("createDoc");
        Events event = null;
        Events instance = new Events();
        instance.setDateTime("1234");
        instance.setUnitID(2345);
        instance.setPort("3456");
        instance.setValue(4567);
        Document expResult = new Document()
                .append("DateTime", "1234")
                .append("UnitId", Long.parseLong("2345"))
                .append("Port", "3456")
                .append("Value", 4567);
        Document result = instance.createDoc(event);
        assertEquals(result, expResult);
        System.out.println(expResult);
        System.out.println(result);
// TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
}
    
}
