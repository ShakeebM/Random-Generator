package com.shak.random;

import java.util.Scanner;

public class MakeMeRandom {
public static void main(String[] args) {
	   int noOfCAPSAlpha = 0;
       int noOfDigits = 12;
       int noOfSplChars = 0;
       int minLen = 12;
       int maxLen = 12;
       DBInserter dbInserter=new DBInserter();
       CSVInserter csvInserter=new CSVInserter();
       String[] toppings = new String[10000];
       System.out.println("DB or CSV? (1/2)");
       Scanner sc=new Scanner(System.in);
       switch (sc.nextInt()) {
	case 1:
		for (int i = 0; i < 10000; i++) {
	           char[] pswd = RandomCodeGenerator.generatePswd(minLen, maxLen,
	                   noOfCAPSAlpha, noOfDigits, noOfSplChars);
	           toppings[i]=new String(pswd);
	           dbInserter.insertMe(new String(pswd));
	           System.out.println(/*"Len = " + pswd.length + ", " + */new String(pswd));
	       }
		break;
	case 2:
		for (int i = 0; i < 10000; i++) {
	           char[] pswd = RandomCodeGenerator.generatePswd(minLen, maxLen,
	                   noOfCAPSAlpha, noOfDigits, noOfSplChars);
	           toppings[i]=new String(pswd);
	           csvInserter.openCSV();
	           csvInserter.insertToCSV(i, new String(pswd));
	           csvInserter.commit();
	           System.out.println(/*"Len = " + pswd.length + ", " + */new String(pswd));
	       }
		break;
	default:
		break;
	}
       
       
       for(int i=0;i<5000;i++)
    	   for(int j=i+1;j<5000-i;j++)
    	   {
    		   if(toppings[i].equals(toppings[j])){
//    			   if(i!=j){
    				   System.out.println("error!!!: i:"+i+"and j:"+j);
    				   System.out.println(toppings[i]+" &"+toppings[j]);
//    			   }
    		   }
    	   }
}
}
