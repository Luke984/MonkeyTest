package com.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MonkeyCSV {
	private Path nomeFile;
	private FileWriter writer;
	private BufferedReader reader;

	
	public MonkeyCSV(String nf){
		this.nomeFile =  Paths.get(nf);
	}
	public ArrayList<ArrayList<String>> monkeyRead() throws FileNotFoundException{
		ArrayList <ArrayList<String>> fileLetto = new ArrayList<ArrayList<String>>();
		try{
			String line;
			
		this.reader = new BufferedReader(new FileReader(this.nomeFile.getFileName().toString()));
		while ((line = this.reader.readLine())!=null){
			System.out.println(line);
			fileLetto.add(this.monkeyCSVtoArray(line));		
		}
		
		this.reader.close();
		
		}catch(IOException e){
			e.printStackTrace();
		}
		return(fileLetto);
		
	}
	private ArrayList<String> monkeyCSVtoArray(String Line){
		ArrayList<String> risultato = new ArrayList<String>();
		if (Line != null) {
			String[] splitData = Line.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) 
			{
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) 
				{
					risultato.add(splitData[i].trim());
				 risultato.removeAll(Collections.singleton(""));
				}
			}
		}
		return(risultato);
	} 
	

	public void MonkeyWrite(String nf ) throws SecurityException, IOException{
	
			this.writer = new FileWriter(nf, true);
		
	}
	public void MonkeyWrite() throws SecurityException, IOException{

		this.writer = new FileWriter(this.nomeFile.getFileName().toString());
		
	}
	public void monkeyCSVNewLine() throws IOException{
		this.writer.write("\r");
		this.writer.write("\n");
	}
	public void monkeyCSVColumn() throws IOException{
		this.writer.write(',');
	}
	public void monkeyCSVData(String data) throws IOException{
		this.writer.write(data);
	}
	public void monkeyCSVWriteClose() throws IOException{
		this.writer.close();
	}
	
}

