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
public class ConnectionsNGTest {
    
    public ConnectionsNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //System.out.println("setUpClass is executing");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        //System.out.println("tearDownClass is executing");
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        //System.out.println("setUpMethod is executing");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        //System.out.println("tearDownMethod is executing");
    }

    /**
     * Test of getDateTime method, of class Connections.
     */
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        Connections instance = new Connections();
        String expResult = instance.getDateTime();
        String result = instance.getDateTime();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDateTime method, of class Connections.
     */
    @Test
    public void testSetDateTime() {
        System.out.println("setDateTime");
        String dateTime = "";
        Connections instance = new Connections();
        instance.setDateTime(dateTime);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitID method, of class Connections.
     */
    @Test
    public void testGetUnitID() {
        System.out.println("getUnitID");
        Connections instance = new Connections();
        long expResult = 0L;
        long result = instance.getUnitID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitID method, of class Connections.
     */
    @Test
    public void testSetUnitID() {
        System.out.println("setUnitID");
        long unitID = 0L;
        Connections instance = new Connections();
        instance.setUnitID(unitID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPort method, of class Connections.
     */
    @Test
    public void testGetPort() {
        System.out.println("getPort");
        Connections instance = new Connections();
        String expResult = null;
        String result = instance.getPort();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPort method, of class Connections.
     */
    @Test
    public void testSetPort() {
        System.out.println("setPort");
        String port = "";
        Connections instance = new Connections();
        instance.setPort(port);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Connections.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Connections instance = new Connections();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Connections.
     */
    @Test()
    public void testSetValue() {
        System.out.println("setValue");
        int value = 0;
        Connections instance = new Connections();
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAndSplitRowCSV method, of class Connections.
     */
    @Test(enabled=false)
    public void testSetAndSplitRowCSV() {
        System.out.println("setAndSplitRowCSV");
        Connections connection = null;
        String[] row = null;
        Connections instance = new Connections();
        Document expResult = null;
        Document result = instance.setAndSplitRowCSV(connection, row);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAndSplitRowLive method, of class Connections.
     */
    @Test(enabled=false)
    public void testSetAndSplitRowLive() {
        System.out.println("setAndSplitRowLive");
        Connections connection = null;
        String row = "";
        Connections instance = new Connections();
        Document expResult = null;
        Document result = instance.setAndSplitRowLive(connection, row);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createDoc method, of class Connections.
     */
    @Test(priority=1)
    public void testCreateDoc() {
        System.out.println("createDoc");
        Connections connection = null;
        Connections instance = new Connections();
        instance.setDateTime("2015-12-15 00:47:24"); //String
        instance.setUnitID(125L);                    //Long
        instance.setPort("Connection");              //String
        instance.setValue(0);                        //Int
        Document expResult = new Document("DateTime","2015-12-15 00:47:24")
                .append("UnitId", 125L)
                .append("Port", "Connection")
                .append("Value", 0);
        Document result = instance.createDoc(connection);
        assertEquals(result, expResult);
        System.out.println(expResult);
        System.out.println(result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
