/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import java.util.ArrayList;

/**
 *
 * @author Koen
 * @author http://www.roelvanlisdonk.nl/?p=2950
 */
public interface IRijksdriehoekComponent {

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public ArrayList<String> convertToLatLong(double x, double y);

}


