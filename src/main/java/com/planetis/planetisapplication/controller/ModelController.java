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

    public void readAndSave() {

        String topic = "CONNECTIONS";

//        Connections connection = new Connections();
//        List<String[]> listConnections = connection.fileToList(Properties.csvFolderPath, topic);
//
//        for (String[] row : listConnections) {
//            Document doc = connection.setAndSplitRowCSV(connection, row);
//            db.saveDoc(topic, doc);
//        }
//        
//        topic = "EVENTS";
//
//        Events event = new Events();
//        List<String[]> listEvents = event.fileToList(Properties.csvFolderPath, topic);
//
//        for (String[] row : listEvents) {
//            Document doc = event.setAndSplitRowCSV(event, row);
//            db.saveDoc(topic, doc);
//        }
        
//        topic = "POSITIONS";
//
//        Positions position = new Positions();
//        List<String[]> listPositions = position.fileToList(Properties.csvFolderPath, topic);
//
//        for (String[] row : listPositions) {
//            Document doc = position.setAndSplitRowCSV(position, row);
//            db.saveDoc(topic, doc);
//        }

        topic = "MONITORING";

        Monitoring monitor = new Monitoring();
        List<String[]> listMonitoring = monitor.fileToList(Properties.csvFolderPath, topic);

        for (String[] row : listMonitoring) {
            Document doc = monitor.setAndSplitRowCSV(monitor, row);
            db.saveDoc(topic, doc);
        }

        
    }

    public void receiver() {
        ApplicationReceiver receiver = new ApplicationReceiver();
        receiver.connectAndListen();

    }

    public void liveConvertSave(String topic, String message) {

        if (topic.equalsIgnoreCase("POSITIONS")) {
            Positions position = new Positions();
            Document doc = position.setAndSplitRowLive(position, message);
            db.saveDoc(topic, doc);
        }

        if (topic.equalsIgnoreCase("MONITORING")) {
            Monitoring monitor = new Monitoring();
            Document doc = monitor.setAndSplitRowLive(monitor, message);
            db.saveDoc(topic, doc);
        }

        if (topic.equalsIgnoreCase("CONNECTIONS")) {
            Connections connection = new Connections();
            Document doc = connection.setAndSplitRowLive(connection, message);
            db.saveDoc(topic, doc);
        }

        if (topic.equalsIgnoreCase("EVENTS")) {
            Events event = new Events();
            Document doc = event.setAndSplitRowLive(event, message);
            db.saveDoc(topic, doc);
        }

    }

}
