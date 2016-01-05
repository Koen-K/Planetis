/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planetis.planetisapplication.model;

import com.mongodb.MongoClient;
import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Koen
 */
public class BaseEntity {

    public RowListProcessor rowProcessor;
    public CsvParserSettings parserSettings;
    public CsvParser parser;
    

    public BaseEntity() {
        // A RowListProcessor stores each parsed row in a List.
        this.rowProcessor = new RowListProcessor();

        // The settings object provides many configuration options
        this.parserSettings = new CsvParserSettings();

        //You can configure the parser to automatically detect what line separator sequence is in the input
        parserSettings.setLineSeparatorDetectionEnabled(true);

        // You can configure the parser to use a RowProcessor to process the values of each parsed row.
        // You will find more RowProcessors in the 'com.univocity.parsers.common.processor' package, but you can also create your own.
        parserSettings.setRowProcessor(rowProcessor);

        // Let's consider the first parsed row as the headers of each column in the file.
        parserSettings.setHeaderExtractionEnabled(true);

        // creates a parser instance with the given settings
        this.parser = new CsvParser(parserSettings);
        
        
    }



    public List<String[]> fileToList(String csvFolderPath, String fileName) {

        try {
            parser.parse(getReader(csvFolderPath + "/" + fileName + ".csv"));
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, null, ex);
        }

        // get the parsed records from the RowListProcessor here.
        // Note that different implementations of RowProcessor will provide different sets of functionalities.
//        String[] headers = rowProcessor.getHeaders();
        List<String[]> rows = rowProcessor.getRows();
//        ArrayList<Connections> list = new ArrayList<>();
//
//        for (String[] row : rows) {
//            list.add((Connections) setAndSplitRow(row));
//        }

//        System.out.println(Arrays.toString(headers));
//        System.out.println(rows.size());
        return rows;
    }

    public Reader getReader(String csvFolderPath) throws UnsupportedEncodingException, FileNotFoundException {
        return new InputStreamReader(new FileInputStream(new File(csvFolderPath)), "UTF-8");
    }

}
