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
public class Positions extends BaseEntity implements IEntity {

    private String dateTime;
    private String unitID;
    private String rdx;
    private String rdy;
    private String speed;
    private String course;
    private String numSatellites;
    private String hdop;
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
    public String getUnitID() {
        return unitID;
    }

    /**
     *
     * @param unitID
     */
    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }

    /**
     *
     * @return
     */
    public String getRdx() {
        return rdx;
    }

    /**
     *
     * @param rdx
     */
    public void setRdx(String rdx) {
        this.rdx = rdx;
    }

    /**
     *
     * @return
     */
    public String getRdy() {
        return rdy;
    }

    /**
     *
     * @param rdy
     */
    public void setRdy(String rdy) {
        this.rdy = rdy;
    }

    /**
     *
     * @return
     */
    public String getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     *
     * @return
     */
    public String getCourse() {
        return course;
    }

    /**
     *
     * @param course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     *
     * @return
     */
    public String getNumSatellites() {
        return numSatellites;
    }

    /**
     *
     * @param numSatellites
     */
    public void setNumSatellites(String numSatellites) {
        this.numSatellites = numSatellites;
    }

    /**
     *
     * @return
     */
    public String getHdop() {
        return hdop;
    }

    /**
     *
     * @param hdop
     */
    public void setHdop(String hdop) {
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

    public Positions setAndSplitRowCSV(String[] row) {
        Positions position = new Positions();

        int index = 0;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setDateTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setUnitID((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        double rdx = Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        double rdy = Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        ArrayList<String> result = converter.convertToLatLong(rdx, rdy);

        position.setRdx(result.get(0));
        position.setRdy(result.get(1));

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setSpeed((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setCourse((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setNumSatellites((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        position.setHdop((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].length()));
        position.setQuality((String) row[0].subSequence(index, row[0].length()));

        return position;
    }

    public Positions setAndSplitRowLive(Positions position, String row) {

        int index = 1;

        double rdx = Double.parseDouble((String) row.subSequence(row.indexOf(":") + 2, row.indexOf(",") - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(rdx);
        System.out.println(index);

        double rdy = Double.parseDouble((String) row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index)+ 1;
        System.out.println(rdy);
        System.out.println(index);

        ArrayList<String> result = converter.convertToLatLong(rdx, rdy);
        position.setRdx(result.get(0));
        position.setRdy(result.get(1));

        position.setSpeed((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        position.setCourse((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        position.setNumSatellites((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;

        position.setHdop((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;

        position.setQuality((String) row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;

        position.setDateTime((String) row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;

        position.setUnitID((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));
//        index = row.indexOf(",", index) + 1;

        return position;
    }
}
