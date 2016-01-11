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
 * @author Koen
 */
public class IRijksdriehoekComponentNGTest {
    
    public IRijksdriehoekComponentNGTest() {
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
     * Test of convertToLatLong method, of class IRijksdriehoekComponent.
     */
    @Test
    public void testConvertToLatLong() {
        System.out.println("convertToLatLong");
        double x = 0.0;
        double y = 0.0;
        IRijksdriehoekComponent instance = new IRijksdriehoekComponentImpl();
        ArrayList expResult = null;
        ArrayList result = instance.convertToLatLong(x, y);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    public class IRijksdriehoekComponentImpl implements IRijksdriehoekComponent {

        public ArrayList<String> convertToLatLong(double x, double y) {
            return null;
        }
    }
    
}
