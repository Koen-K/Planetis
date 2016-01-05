/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.controller;

import com.planetis.planetisapplication.model.Connections;
import com.planetis.planetisapplication.model.GetConfigPropertyValues;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koen
 */
public class ModelController {

    public GetConfigPropertyValues config;

    public ModelController() {
        this.config = new GetConfigPropertyValues();

    }

    public ArrayList<Connections> read() {
        Connections con = new Connections();
        List<String[]> rows = con.fileToList(config.getCSVFolderPath(), "Connections");
        ArrayList<Connections> list = new ArrayList<>();
        for (String[] row : rows) {
            System.out.println(con.setAndSplitRow(row).getDateTime());
//            list.add(con.setAndSplitRow(row));

        }

        return list;
    }

}
