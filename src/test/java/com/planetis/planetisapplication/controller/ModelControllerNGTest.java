/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.controller;

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
     * Test of readAndSave method, of class ModelController.
     */
    @Test(enabled=false)
    public void testReadAndSave() {
        System.out.println("readAndSave");
        ModelController instance = new ModelController();
        instance.readAndSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiver method, of class ModelController.
     */
    @Test(enabled=false)
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
    @Test(enabled=false)
    public void testLiveConvertSave() {
        System.out.println("liveConvertSave");
        String topic = "";
        String message = "";
        ModelController instance = new ModelController();
        instance.liveConvertSave(topic, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
