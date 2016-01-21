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

    MongoCollection<org.bson.Document> collectionP;
    MongoCollection<org.bson.Document> collectionM;
    MongoCollection<org.bson.Document> collectionE;
    MongoCollection<org.bson.Document> collectionC;

    public Database() {
        morphia = new Morphia();
        mongoClient = new MongoClient(Properties.dbIp, Properties.dbPort);

        database = mongoClient.getDatabase(Properties.dbName);
        collectionP = database.getCollection("POSITIONS");
        collectionM = database.getCollection("MONITORING");
        collectionE = database.getCollection("EVENTS");
        collectionC = database.getCollection("CONNECTIONS");

    }

    public void saveDoc(String topic, Document doc) {
        if ("POSITIONS".equals(topic)) {
            collectionP.insertOne(doc);
        } else if ("MONITORING".equals(topic)) {
            collectionM.insertOne(doc);
        } else if ("EVENTS".equals(topic)) {
            collectionE.insertOne(doc);
        } else if ("CONNECTIONS".equals(topic)) {
            collectionC.insertOne(doc);
        } else {
            System.out.println("Helaas pindakaas!");
        }
    }

}
