/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Koen
 */
public class Database {

    public Morphia morphia;
    public MongoClient mongo;
    public GetConfigPropertyValues config;
    public String dbIP;
    public int dbPort;
    public String dbName;
    public DB db;

    public void intitialize() {
        this.morphia = new Morphia();

        this.config = new GetConfigPropertyValues();

        this.dbIP = config.getDBIP();

        this.dbPort = config.getDBPort();

        this.dbName = config.getDBName();

        this.mongo = new MongoClient(dbIP, dbPort);

        this.db = mongo.getDB(dbName);
    }

    public void save(ArrayList<?> list, String collectionName) {

        for (Object consumable : list) {
            // map the blog entry to a Mongo DBObject
            DBObject connectionsEntryDbObj = morphia.toDBObject(consumable);

            // and then save that DBObject in a Mongo collection
            db.getCollection(collectionName).save(connectionsEntryDbObj);
        }
    }
    

}
