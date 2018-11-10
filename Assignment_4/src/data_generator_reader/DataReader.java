/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_generator_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author harshalneelkamal
 */
public class DataReader {
    
    private Scanner scanner;
    private String[] header;
    
    public DataReader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scanner = new Scanner(file);
        if(!file.exists())
            throw new FileNotFoundException("File not found at the path specified: "+fileName);
    }
    
    public String[] getNextRow() throws IOException{
        if (header == null)
            header = getFileHeader();
        String line = "";
        if(scanner.hasNextLine()){
            String[] rows = scanner.nextLine().split(",");
            return rows;
        }
        return null;
    }
    
    public String[] getFileHeader() throws IOException{
        String line = "";
        if(scanner.hasNextLine()){
            String[] rows = scanner.nextLine().split(",");
            return rows;
        }
        return null;
    }
    
}
