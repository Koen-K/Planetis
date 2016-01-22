/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.dbmodel;

import com.planetis.planetisapplication.model.BaseEntity;
import com.planetis.planetisapplication.model.IEntity;
import org.bson.Document;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * A fat-model class which converts data to a Document
 * 
 * @author Koen
 */
@Entity
public class Connections extends BaseEntity implements IEntity {

    @Id
    private String dateTime;
    private long unitID;
    private String port;
    private int value;

    /**
     * 
     * @return 
     */
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public long getUnitID() {
        return unitID;
    }

    public void setUnitID(long unitID) {
        this.unitID = unitID;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Receives a row and converts it using the createDoc class
     * 
     * @param connection
     * @param row
     * @return 
     */
    public Document setAndSplitRowCSV(Connections connection, String[] row) {

        int index = 0;

        connection.setDateTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        connection.setUnitID(Long.parseLong((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

        connection.setPort((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        connection.setValue(Integer.parseInt((String) row[0].subSequence(index, row[0].length())));

        return createDoc(connection);
    }

    /**
     * Receives a row, splits the row and create a Document by calling the createDoc class on the return
     * 
     * @param connection
     * @param row
     * @return 
     */
    public Document setAndSplitRowLive(Connections connection, String row) {

        int index = 1;

        connection.setPort((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        connection.setValue(Integer.parseInt((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index))));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        connection.setDateTime((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        connection.setUnitID(Long.parseLong((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index))));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));

        return createDoc(connection);
    }

    /**
     * Create a Document from a Connections object
     * @param connection
     * @return 
     */
    public Document createDoc(Connections connection) {
        Document doc = new Document("DateTime", getDateTime())
                .append("UnitId", getUnitID())
                .append("Port", getPort())
                .append("Value", getValue());
        return doc;
    }

}
