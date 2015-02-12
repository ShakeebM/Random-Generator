package com.shak.random;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;

public class CSVInserter {
	CsvWriter csvOutput;

		public void openCSV(){
			String outputFile = "passwords.csv";
			// before we open the file check to see if it already exists
			boolean alreadyExists = new File(outputFile).exists();
			
			try {
				// use FileWriter constructor that specifies open for appending
				 csvOutput= new CsvWriter(new FileWriter(outputFile, true), ',');
				
				// if the file didn't already exist then we need to write out the header line
				if (!alreadyExists)
				{
					
					//csvOutput.write("id");
					csvOutput.write("code");
					csvOutput.endRecord();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
		public void insertToCSV(int id,String pwd){
			try {
			//csvOutput.write(id+"");
			csvOutput.write(pwd);
			csvOutput.endRecord();

			} catch (IOException e) {
				e.printStackTrace();
			}			

			
		}
		public void commit(){
			csvOutput.close();
		}
	
}
