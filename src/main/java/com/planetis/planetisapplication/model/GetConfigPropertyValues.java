/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Koen
 */
public class GetConfigPropertyValues {

    private InputStream inputStream;

    public String getDBIP() {

        String result = new String();

        try {
            Properties prop = new Properties();
            String propFileName = "resources/config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            result = prop.getProperty("dbip");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(GetConfigPropertyValues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public int getDBPort() {

        int result = 0;

        try {
            Properties prop = new Properties();
            String propFileName = "resources/config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            result = Integer.parseInt(prop.getProperty("dbport"));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(GetConfigPropertyValues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public String getDBName() {

        String result = new String();

        try {
            Properties prop = new Properties();
            String propFileName = "resources/config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            result = prop.getProperty("dbname");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(GetConfigPropertyValues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public String getDBUserName() {

        String result = new String();

        try {
            Properties prop = new Properties();
            String propFileName = "resources/config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            result = prop.getProperty("dbuser");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(GetConfigPropertyValues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public String getDBPassword() {

        String result = new String();

        try {
            Properties prop = new Properties();
            String propFileName = "resources/config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            result = prop.getProperty("dbpass");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(GetConfigPropertyValues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public String getCSVFolderPath() {

        String result = new String();

        try {
            Properties prop = new Properties();
            String propFileName = "resources/config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            result = prop.getProperty("csvfolderpath");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(GetConfigPropertyValues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

}
