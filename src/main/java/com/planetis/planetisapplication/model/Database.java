/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import com.planetis.planetisapplication.resources.Properties;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Koen
 */
public class Database {

    private final Morphia morphia;
    private final MongoClient mongoClient;
    private final MongoDatabase database;

    public Database() {
        morphia = new Morphia();
        mongoClient = new MongoClient(Properties.dbIp, Properties.dbPort);

        database = mongoClient.getDatabase(Properties.dbName);
    }

    public void saveDoc(String topic, Document doc) {
        MongoCollection<org.bson.Document> collection = database.getCollection(topic);
        collection.insertOne(doc);
    }

}
//    public void saveLiveMonitoring(Monitoring consumable, String collectionName) {
//
//        // map the blog entry to a Mongo DBObject
//        DBObject connectionsEntryDbObj = morphia.toDBObject(consumable);
//
//        // and then save that DBObject in a Mongo collection
//        db.getCollection(collectionName).save(connectionsEntryDbObj);
//
//    }
//
//    public void saveLiveConnections(Connections consumable, String collectionName) {
//
//        // map the blog entry to a Mongo DBObject
//        DBObject connectionsEntryDbObj = morphia.toDBObject(consumable);
//
//        // and then save that DBObject in a Mongo collection
//        db.getCollection(collectionName).save(connectionsEntryDbObj);
//
//    }
//
//    public void saveLiveEvents(Events consumable, String collectionName) {
//
//        // map the blog entry to a Mongo DBObject
//        DBObject connectionsEntryDbObj = morphia.toDBObject(consumable);
//
//        // and then save that DBObject in a Mongo collection
//        db.getCollection(collectionName).save(connectionsEntryDbObj);
//
//    }

