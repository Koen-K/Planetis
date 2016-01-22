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

/**
 * The main method start 2 functions of the program.
 *  - writing a CSV file to MongoDB
 *  - receive messages from Docker and write them to MongoDB
 * 
 * @param args 
 */
    public static void main(String[] args) {
        
        // creates the controller
        ModelController controller = new ModelController();
        
        // start reading the CSV files, converting them and then put it away the MongoDB
        controller.readAndSave();
        
        // start receiving the messages from Docker, converting them and writing them to MongoDB
        controller.receiver();



    }
}
