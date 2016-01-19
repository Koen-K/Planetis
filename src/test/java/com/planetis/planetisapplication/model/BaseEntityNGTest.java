/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import java.io.Reader;
import java.util.List;
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
public class BaseEntityNGTest {
    
    public BaseEntityNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("setUpClass is executing");
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
     * Test of fileToList method, of class BaseEntity.
     */
    @Test
    public void testFileToList() {
        System.out.println("fileToList");
        String csvFolderPath = "c:/csvFiles";
        String fileName = "c:/csvFiles";
        BaseEntity instance = new BaseEntity();
        List expResult = null;
        List result = instance.fileToList(csvFolderPath, fileName);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getReader method, of class BaseEntity.
     */
    @Test
    public void testGetReader() throws Exception {
        System.out.println("getReader");
        String csvFolderPath = "";
        BaseEntity instance = new BaseEntity();
        Reader expResult = null;
        Reader result = instance.getReader(csvFolderPath);
        assertEquals(result, expResult);
    }
    
}
