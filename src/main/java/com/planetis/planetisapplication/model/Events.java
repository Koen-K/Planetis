/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import java.util.ArrayList;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author Koen
 */
@Entity
public class Events extends BaseEntity implements IEntity {

    private String dateTime;
    private String unitID;
    private String port;
    private String value;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUnitID() {
        return unitID;
    }

    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Events setAndSplitRow(String[] row, int occurences) {
        Events event = new Events();

        int index = 0;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        event.setDateTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        event.setUnitID((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        event.setPort((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].length()));
        event.setValue((String) row[0].subSequence(index, row[0].length()));

        return event;
    }

    public Events setAndSplitRowLive(Events event, String row) {

        int index = 1;

        event.setPort((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        event.setValue((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        event.setDateTime((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);
        
        event.setUnitID((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));
        

        return event;
    }
}
