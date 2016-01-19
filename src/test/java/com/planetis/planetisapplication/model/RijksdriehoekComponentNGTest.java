/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import java.util.ArrayList;
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
public class RijksdriehoekComponentNGTest {
    
    public RijksdriehoekComponentNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("setUpClass is executing");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("tearDownClass is executing");
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.out.println("setUpMethod is executing");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        System.out.println("tearDownMethod is executing");
    }

    /**
     * Test of convertToLatLong method, of class RijksdriehoekComponent.
     */
    @Test(priority=1)
    public void testConvertToLatLong() {
        System.out.println("convertToLatLong");
        double x = 122202.0;
        double y = 487250.0;
        RijksdriehoekComponent instance = new RijksdriehoekComponent();
        ArrayList expResult = instance.convertToLatLong(x, y);
        //Wat ik verwacht terug te krijgen is "52.37214383811702, 4.905597604352241"
        ArrayList result = instance.convertToLatLong(x, y);
        System.out.println(instance.convertToLatLong(x, y));
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(result, expResult);
        
    }
    
}
