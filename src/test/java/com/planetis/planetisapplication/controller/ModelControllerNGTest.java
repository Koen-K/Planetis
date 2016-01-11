/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.controller;

import java.util.ArrayList;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Koen
 */
public class ModelControllerNGTest {
    
    public ModelControllerNGTest() {
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
     * Test of read method, of class ModelController.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        ModelController instance = new ModelController();
        ArrayList expResult = null;
        ArrayList result = instance.read();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiver method, of class ModelController.
     */
    @Test
    public void testReceiver() {
        System.out.println("receiver");
        ModelController instance = new ModelController();
        instance.receiver();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of liveConvertSave method, of class ModelController.
     */
    @Test
    public void testLiveConvertSave() {
        System.out.println("liveConvertSave");
        String topic = "";
        String message = null;
        ModelController instance = new ModelController();
        instance.liveConvertSave(topic, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
