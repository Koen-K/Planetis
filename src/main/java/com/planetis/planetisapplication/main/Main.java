/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.main;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.planetis.planetisapplication.controller.ModelController;
import com.planetis.planetisapplication.dbmodel.Events;
import com.planetis.planetisapplication.model.ApplicationReceiver;
import com.planetis.planetisapplication.resources.Properties;
import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Koen
 */
public class Main {

    public static void main(String[] args) {
        
        ModelController controller = new ModelController();
//        controller.receiver();
        controller.readAndSave();


    }
}
