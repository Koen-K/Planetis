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
public class Monitoring extends BaseEntity implements IEntity {

    @Id
    private long unitID;
    private String beginTime;
    private String endTime;
    private String type;
    private double min;
    private double max;
    private String sum;

    public long getUnitID() {
        return unitID;
    }

    public void setUnitID(long unitID) {
        this.unitID = unitID;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setDateTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public Document setAndSplitRowCSV(Monitoring monitor, String[] row) {

        int index = 0;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setUnitID(Long.parseLong((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setDateTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setEndTime((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        //            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setType((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        //            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setMin(Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

        //            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setMax(Double.parseDouble((String) row[0].subSequence(index, row[0].indexOf(";", index))));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].length()));
        monitor.setSum((String) row[0].subSequence(index, row[0].length()));

        return createDoc(monitor);
    }

    public Document setAndSplitRowLive(Monitoring monitor, String row) {

        int index = 1;

        monitor.setUnitID(Long.parseLong((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1))));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        monitor.setDateTime((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        monitor.setEndTime((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        monitor.setType((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        monitor.setMin(Double.parseDouble((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index))));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        monitor.setMax(Double.parseDouble((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index))));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        monitor.setSum((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));

        return createDoc(monitor);
    }

    public Document createDoc(Monitoring monitoring) {
        Document doc = new Document("UnitId", getUnitID())
                .append("BeginTime", getBeginTime())
                .append("EndTime", getEndTime())
                .append("Type", getType())
                .append("Min", getMin())
                .append("Max", getMax())
                .append("Sum", getSum());

        return doc;
    }
}
