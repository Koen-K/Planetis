/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import com.planetis.planetisapplication.dbmodel.Events;
import com.planetis.planetisapplication.dbmodel.Connections;
import com.planetis.planetisapplication.dbmodel.Positions;
import com.planetis.planetisapplication.dbmodel.Monitoring;
import java.util.ArrayList;

/**
 *
 * @author Koen
 */
public interface IDatabase {

    public void intitialize();

    public void saveList(ArrayList<?> list, String collectionName);
    
    public void saveLivePositions(Positions consumable, String collectionName);

    public void saveLiveConnections(Connections consumable, String collectionName);
    
    public void saveLiveMonitoring(Monitoring consumable, String collectionName);
    
    public void saveLiveEvents(Events consumable, String collectionName);
}
