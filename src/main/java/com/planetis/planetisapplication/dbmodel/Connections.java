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
 *
 * @author Koen
 */
@Entity
public class Connections extends BaseEntity implements IEntity {

    @Id
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

    public Document setAndSplitRowCSV(Connections connection, String[] row) {

        int index = 0;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        connection.setDateTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        connection.setUnitID((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        connection.setPort((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].length()));
        connection.setValue((String) row[0].subSequence(index, row[0].length()));

        return createDoc(connection);
    }

    public Document setAndSplitRowLive(Connections connection, String row) {

        int index = 1;

        connection.setPort((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        connection.setValue((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        connection.setDateTime((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        connection.setUnitID((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));

        return createDoc(connection);
    }

    public Document createDoc(Connections connection) {
        Document doc = new Document("DateTime", getDateTime())
                .append("UnitId", getUnitID())
                .append("Port", getPort())
                .append("Value", getValue());
        return doc;
    }

}
