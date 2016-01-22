/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.dbmodel;

import com.planetis.planetisapplication.model.BaseEntity;
import com.planetis.planetisapplication.model.IEntity;
import com.planetis.planetisapplication.model.IRijksdriehoekComponent;
import com.planetis.planetisapplication.model.RijksdriehoekComponent;
import java.util.ArrayList;
import org.bson.Document;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * This class is a fat-model and can be used to convert to Documents for MongoDB
 * 
 * @author Koen
 */
@Entity("positions")
public class Positions extends BaseEntity implements IEntity {

    @Id
    private String dateTime;
    private long unitID;
    private double rdx;
    private double rdy;
    private double speed;
    private double course;
    private int numSatellites;
    private int hdop;
    private String quality;
    private IRijksdriehoekComponent converter;

    public Positions() {
        this.converter = new RijksdriehoekComponent();
    }

    /**
     *
     * @return
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     *
     * @param dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     *
     * @return
     */
    public long getUnitID() {
        return unitID;
    }

    /**
     *
     * @param unitID
     */
    public void setUnitID(long unitID) {
        this.unitID = unitID;
    }

    /**
     *
     * @return
     */
    public double getRdx() {
        return rdx;
    }

    /**
     *
     * @param rdx
     */
    public void setRdx(double rdx) {
        this.rdx = rdx;
    }

    /**
     *
     * @return
     */
    public double getRdy() {
        return rdy;
    }

    /**
     *
     * @param rdy
     */
    public void setRdy(double rdy) {
        this.rdy = rdy;
    }

    /**
     *
     * @return
     */
    public double getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     *
     * @return
     */
    public double getCourse() {
        return course;
    }

    /**
     *
     * @param course
     */
    public void setCourse(double course) {
        this.course = course;
    }

    /**
     *
     * @return
     */
    public int getNumSatellites() {
        return numSatellites;
    }

    /**
     *
     * @param numSatellites
     */
    public void setNumSatellites(int numSatellites) {
        this.numSatellites = numSatellites;
    }

    /**
     *
     * @return
     */
    public int getHdop() {
        return hdop;
    }

    /**
     *
     * @param hdop
     */
    public void setHdop(int hdop) {
        this.hdop = hdop;
    }

    /**
     *
     * @return
     */
    public String getQuality() {
        return quality;
    }

    /**
     *
     * @param quality
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    
    /**
     * Receives a row with a topic, splits it and converts it to a Document by calling the createDoc method
     * 
     * @param position
     * @param row
     * @return 
     */
    public Document setAndSplitRowCSV(Positions position, String[] row) {

        int index = 0;

        position.setDateTime((String) row[0]
                .subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        position.setUnitID(Long.parseLong((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

        double rdx = Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        double rdy = Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        ArrayList<Double> result = converter.convertToLatLong(rdx, rdy);

        position.setRdx(result.get(0));
        position.setRdy(result.get(1));

        position.setSpeed(Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

        position.setCourse(Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

        position.setNumSatellites(Integer.parseInt((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

        position.setHdop(Integer.parseInt((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

        position.setQuality((String) row[0].subSequence(index, row[0].length()));

        return createDoc(position);
    }

    /**
     * Receives a row with a MongoDB collection name, splits it and calls createDoc on the return to give a Document
     * 
     * @param position
     * @param row
     * @return 
     */
    public Document setAndSplitRowLive(Positions position, String row) {

        int index = 1;

        double rdx = Double.parseDouble((String) row.subSequence(row.indexOf(":") + 2, row.indexOf(",") - 1));
        index = row.indexOf(",", index) + 1;

        double rdy = Double.parseDouble((String) row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;

        ArrayList<Double> result = converter.convertToLatLong(rdx, rdy);
        position.setRdx(result.get(0));
        position.setRdy(result.get(1));

        position.setSpeed(Double.parseDouble((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index))));
        index = row.indexOf(",", index) + 1;

        position.setCourse(Double.parseDouble((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index))));
        index = row.indexOf(",", index) + 1;

        position.setNumSatellites(Integer.parseInt((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index))));
        index = row.indexOf(",", index) + 1;

        position.setHdop(Integer.parseInt((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index))));
        index = row.indexOf(",", index) + 1;

        position.setQuality((String) row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;

        position.setDateTime((String) row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;

        position.setUnitID(Long.parseLong((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index))));

        return createDoc(position);
    }

    /**
     * Creates a document of a object from Positions
     * 
     * @param position
     * @return 
     */
    public Document createDoc(Positions position) {
        Document doc = new Document("DateTime", getDateTime())
                .append("UnitId", getUnitID())
                .append("Rdx", getRdx())
                .append("Rdy", getRdy())
                .append("Speed", getSpeed())
                .append("Course", getCourse())
                .append("NumSatellites", getNumSatellites())
                .append("HDOP", getHdop())
                .append("Quality", getQuality());
        return doc;
    }
}
