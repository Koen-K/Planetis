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

/**
 * A fat-model class which converts data to a Document
 * 
 * @author Koen
 */
@Entity
public class Events extends BaseEntity implements IEntity {

    private String dateTime;
    private long unitID;
    private String port;
    private int value;

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
     * Receives a row, splits it and calls the createDoc on the return
     * 
     * @param event
     * @param row
     * @return 
     */
    public Document setAndSplitRowCSV(Events event, String[] row) {

        int index = 0;

        event.setDateTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        event.setUnitID(Long.parseLong((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

        event.setPort((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        event.setValue(Integer.parseInt((String) row[0].subSequence(index, row[0].length())));

        return createDoc(event);
    }

    
    /**
     * Receives a row, splits it and converts it to a Document by calling createDoc on the return
     * 
     * @param event
     * @param row
     * @return 
     */
    public Document setAndSplitRowLive(Events event, String row) {

        int index = 1;

        event.setPort((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        event.setValue(Integer.parseInt((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index))));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        event.setDateTime((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        event.setUnitID(Long.parseLong((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index))));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));

        return createDoc(event);
    }

    
    /**
     * Creates a Document of a Events object
     * 
     * @param event
     * @return 
     */
    public Document createDoc(Events event) {
        Document doc = new Document("DateTime", getDateTime())
                .append("UnitId", getUnitID())
                .append("Port", getPort())
                .append("Value", getValue());

        return doc;
    }
}
