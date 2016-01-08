/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.controller;

import com.planetis.planetisapplication.model.ApplicationReceiver;
import com.planetis.planetisapplication.model.Connections;
import com.planetis.planetisapplication.model.Database;
import com.planetis.planetisapplication.resources.GetConfigPropertyValues;
import com.planetis.planetisapplication.model.IDatabase;
import com.planetis.planetisapplication.model.IRijksdriehoekComponent;
import com.planetis.planetisapplication.model.Positions;
import com.planetis.planetisapplication.model.RijksdriehoekComponent;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author Koen
 */
public class ModelController {

    public GetConfigPropertyValues config;
    public Database db;

    public ModelController() {
        this.config = new GetConfigPropertyValues();
        this.db = new Database();
        
    }

    public ArrayList<Connections> read() {
        Connections con = new Connections();
        List<String[]> rows = con.fileToList(config.getCSVFolderPath(), "Connections");
        ArrayList<Connections> list = new ArrayList<>();
        for (String[] row : rows) {
            System.out.println(con.setAndSplitRow(row).getDateTime());
//            list.add(con.setAndSplitRow(row));

        }

        return list;
    }
    
    public void receiver(){
        ApplicationReceiver receiver = new ApplicationReceiver(db);
          receiver.connectAndListen();
          
    }
    


}
