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
import com.planetis.planetisapplication.model.IDatabase;
import com.planetis.planetisapplication.model.IRijksdriehoekComponent;
import com.planetis.planetisapplication.dbmodel.Positions;
import com.planetis.planetisapplication.model.RijksdriehoekComponent;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import org.bson.Document;
import org.eclipse.paho.client.mqttv3.MqttMessage;

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

    public ArrayList<Connections> read() {
        Connections con = new Connections();
        List<String[]> rows = con.fileToList(Properties.csvFolderPath, "Connections");
        ArrayList<Connections> list = new ArrayList<>();
        for (String[] row : rows) {
            System.out.println(con.setAndSplitRow(row).getDateTime());
//            list.add(con.setAndSplitRow(row));

        }

        return list;
    }

    public void receiver() {
        ApplicationReceiver receiver = new ApplicationReceiver();
        receiver.connectAndListen();

    }

    public void liveConvertSave(String topic, MqttMessage message) {
        
        if (topic.equalsIgnoreCase("POSITIONS")) {
            Positions position = new Positions();
            Document doc = position.setAndSplitRowLive(position, message.toString());
            db.saveDoc(topic, doc);
        }

        if (topic.equalsIgnoreCase("MONITORING")) {
            Monitoring monitor = new Monitoring();
            monitor.setAndSplitRowLive(monitor, message.toString());
        }

        if (topic.equalsIgnoreCase("CONNECTIONS")) {
            Connections connection = new Connections();
            connection.setAndSplitRowLive(connection, message.toString());
        }

        if (topic.equalsIgnoreCase("EVENTS")) {
            Events event = new Events();
            event.setAndSplitRowLive(event, message.toString());
        }
        
    }

}
