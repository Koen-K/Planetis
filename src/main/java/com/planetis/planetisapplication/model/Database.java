/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import com.planetis.planetisapplication.resources.GetConfigPropertyValues;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Koen
 */
public class Database {

//    public Morphia morphia;
//    public MongoClient mongo;
    public GetConfigPropertyValues config;
    public String dbIP;
    public int dbPort;
    public String dbName;
    public DB db;
    public Datastore datastore;
    public Morphia morphia;

    public Database() {
//        this.morphia = new Morphia();

        this.config = new GetConfigPropertyValues();

//        this.dbIP = config.getDBIP();
//        this.dbPort = config.getDBPort();
//        this.dbName = config.getDBName();
//        this.mongo = new MongoClient(dbIP, dbPort);
//        this.db = mongo.getDB(dbName);
        this.morphia = new Morphia();

        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase database = mongo.getDatabase("Planetis1");
        this.datastore = morphia.createDatastore(mongo, "Planetis1");
        datastore.ensureIndexes();

    }

    public void saveList(ArrayList<?> list, String collectionName) {

        for (Object consumable : list) {
            // map the blog entry to a Mongo DBObject
            DBObject connectionsEntryDbObj = morphia.toDBObject(consumable);

            // and then save that DBObject in a Mongo collection
            db.getCollection(collectionName).save(connectionsEntryDbObj);
        }
    }

    public void saveLivePositions(Positions consumable, String collectionName) {

//        System.out.println("Not yet :(");
//        System.out.println(consumable.getDateTime());

        // map the blog entry to a Mongo DBObject
        DBObject consumableEntryDbObj = morphia.toDBObject(consumable);
//        datastore.save(consumable);
//        System.out.println("Ja?");

        // and then save that DBObject in a Mongo collection
        db.getCollection("Positions").save(consumableEntryDbObj);
//        System.out.println("Succes");
    }

    public void saveLiveMonitoring(Monitoring consumable, String collectionName) {

        // map the blog entry to a Mongo DBObject
        DBObject connectionsEntryDbObj = morphia.toDBObject(consumable);

        // and then save that DBObject in a Mongo collection
        db.getCollection(collectionName).save(connectionsEntryDbObj);

    }

    public void saveLiveConnections(Connections consumable, String collectionName) {

        // map the blog entry to a Mongo DBObject
        DBObject connectionsEntryDbObj = morphia.toDBObject(consumable);

        // and then save that DBObject in a Mongo collection
        db.getCollection(collectionName).save(connectionsEntryDbObj);

    }

    public void saveLiveEvents(Events consumable, String collectionName) {

        // map the blog entry to a Mongo DBObject
        DBObject connectionsEntryDbObj = morphia.toDBObject(consumable);

        // and then save that DBObject in a Mongo collection
        db.getCollection(collectionName).save(connectionsEntryDbObj);

    }

}
