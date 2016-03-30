/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
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
public class ApplicationReceiverNGTest {
    
    public ApplicationReceiverNGTest() {
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
     * Test of main method, of class ApplicationReceiver.
     */
    @Test(enabled=false)
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ApplicationReceiver.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connectAndListen method, of class ApplicationReceiver.
     */
    @Test(enabled=false)
    public void testConnectAndListen() {
        System.out.println("connectAndListen");
        ApplicationReceiver instance = new ApplicationReceiver();
        instance.connectAndListen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connectionLost method, of class ApplicationReceiver.
     */
    @Test(enabled=false)
    public void testConnectionLost() {
        System.out.println("connectionLost");
        Throwable cause = null;
        ApplicationReceiver instance = new ApplicationReceiver();
        instance.connectionLost(cause);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of messageArrived method, of class ApplicationReceiver.
     */
    @Test(enabled=false)
    public void testMessageArrived() {
        System.out.println("messageArrived");
        String topic = "";
        MqttMessage message = null;
        ApplicationReceiver instance = new ApplicationReceiver();
        instance.messageArrived(topic, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deliveryComplete method, of class ApplicationReceiver.
     */
    @Test(enabled=false)
    public void testDeliveryComplete() {
        System.out.println("deliveryComplete");
        IMqttDeliveryToken token = null;
        ApplicationReceiver instance = new ApplicationReceiver();
        instance.deliveryComplete(token);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
