/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.main;

import com.planetis.planetisapplication.controller.ModelController;

/**
 *
 * @author Koen
 */
public class Main {

    public static void main(String[] args) {
        
        ModelController controller = new ModelController();
        controller.receiver();
        controller.readAndSave();


    }
}
