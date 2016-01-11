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
    private String unitID;
    private String beginTime;
    private String endTime;
    private String type;
    private String min;
    private String max;
    private String sum;

    public String getUnitID() {
        return unitID;
    }

    public void setUnitID(String unitID) {
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

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
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
        monitor.setUnitID((String) row[0].subSequence(index, row[0].indexOf(";", index)));
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
        monitor.setMin((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

        //            System.out.println(row[0].subSequence(index, row[0].indexOf(";", index)));
        monitor.setMax((String) row[0].subSequence(index, row[0].indexOf(";", index)));
        index = row[0].indexOf(";", index) + 1;

//            System.out.println(row[0].subSequence(index, row[0].length()));
        monitor.setSum((String) row[0].subSequence(index, row[0].length()));

        return createDoc(monitor);
    }
    
    public Document setAndSplitRowLive(Monitoring monitor, String row) {

        int index = 1;

        monitor.setUnitID((String) (row.subSequence(row.indexOf(":", index) + 2, row.indexOf(",", index) - 1)));
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

        monitor.setMin((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        monitor.setMax((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf(",", index)));
        index = row.indexOf(",", index) + 1;
        System.out.println(index);

        monitor.setSum((String) row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));
        System.out.println(row.subSequence(row.indexOf(":", index) + 1, row.indexOf("}", index)));

        return createDoc(monitor);
    }
    public Document createDoc(Monitoring monitoring) {
        Document doc = new Document("UnitID", getUnitID())
                .append("beginTime", getBeginTime())
                .append("endTime", getEndTime())
                .append("type", getType())
                .append("min", getMin())
                .append("max", getMax())
                .append("sum", getSum());
        
        return doc;
}
}
