/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.controller;

import com.planetis.planetisapplication.model.ApplicationReceiver;
import com.planetis.planetisapplication.dbmodel.Connections;
import com.planetis.planetisapplication.dbmodel.Events;
import com.planetis.planetisapplication.dbmodel.Monitoring;
import com.planetis.planetisapplication.model.Database;
import com.planetis.planetisapplication.resources.Properties;
import com.planetis.planetisapplication.dbmodel.Positions;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Koen
 */
public class ModelController {

    public Properties config;
    public Database db;
    public ArrayList queue;

    public ModelController() {
        this.config = new Properties();
        this.db = new Database();
        this.queue = new ArrayList();
    }

    /**
     * Method to read the CSV files from the folder specified in de Properties
     * class
     */
    public void readAndSave() {

        String topic = "CONNECTIONS";

        Connections connection = new Connections();

        // Calls a method in the Connections class to parse the CSV files to a List of Strings
        List<String[]> listConnections = connection.fileToList(Properties.csvFolderPath, topic);

        // Loops the list, calls a function the convert the Strings to a Document
        // Then it calls a function to save it to MongoDB
        for (String[] row : listConnections) {
            Document doc = connection.setAndSplitRowCSV(connection, row);
            db.saveDoc(topic, doc);
        }

        topic = "EVENTS";

        Events event = new Events();

        // Calls a method in the Connections class to parse the CSV files to a List of Strings
        List<String[]> listEvents = event.fileToList(Properties.csvFolderPath, topic);

        // Loops the list, calls a function the convert the Strings to a Document
        // Then it calls a function to save it to MongoDB
        for (String[] row : listEvents) {
            Document doc = event.setAndSplitRowCSV(event, row);
            db.saveDoc(topic, doc);
        }

        topic = "POSITIONS";

        Positions position = new Positions();

        // Calls a method in the Connections class to parse the CSV files to a List of Strings
        List<String[]> listPositions = position.fileToList(Properties.csvFolderPath, topic);

        // Loops the list, calls a function the convert the Strings to a Document
        // Then it calls a function to save it to MongoDB
        for (String[] row : listPositions) {
            Document doc = position.setAndSplitRowCSV(position, row);
            db.saveDoc(topic, doc);
        }

        topic = "MONITORING";

        Monitoring monitor = new Monitoring();

        // Calls a method in the Connections class to parse the CSV files to a List of Strings
        List<String[]> listMonitoring = monitor.fileToList(Properties.csvFolderPath, topic);

        // Loops the list, calls a function the convert the Strings to a Document
        // Then it calls a function to save it to MongoDB
        for (String[] row : listMonitoring) {
            Document doc = monitor.setAndSplitRowCSV(monitor, row);
            db.saveDoc(topic, doc);
        }

    }

    /**
     * This method makes the program start listening to the incoming messages
     */
    public void receiver() {
        ApplicationReceiver receiver = new ApplicationReceiver();
        receiver.connectAndListen();

    }

    /**
     * Method to read the CSV files from the folder specified in de Properties
     * class
     */
    public void liveConvertSave(String topic, String message) {

        // If the topic is Positions the following statement will be executed
        if (topic.equalsIgnoreCase("POSITIONS")) {
            Positions position = new Positions();

            // Converts the message to a Document
            Document doc = position.setAndSplitRowLive(position, message);

            // Calls the method which saves the Document to MongoDB
            db.saveDoc(topic, doc);
        }

        // If the topic is Monitoring the following statement will be executed
        if (topic.equalsIgnoreCase("MONITORING")) {
            Monitoring monitor = new Monitoring();

            // Converts the message to a Document
            Document doc = monitor.setAndSplitRowLive(monitor, message);
            // Calls the method which saves the Document to MongoDB
            db.saveDoc(topic, doc);
        }

        // If the topic is Connections the following statement will be executed
        if (topic.equalsIgnoreCase("CONNECTIONS")) {
            Connections connection = new Connections();

            // Converts the message to a Document
            Document doc = connection.setAndSplitRowLive(connection, message);
            // Calls the method which saves the Document to MongoDB
            db.saveDoc(topic, doc);
        }

        // If the topic is Events the following statement will be executed
        if (topic.equalsIgnoreCase("EVENTS")) {
            Events event = new Events();
            // Converts the message to a Document
            Document doc = event.setAndSplitRowLive(event, message);
            // Calls the method which saves the Document to MongoDB
            db.saveDoc(topic, doc);
        }

    }

}
