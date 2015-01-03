package com.jenaneggs.random;

public class MakeMeRandom {
public static void main(String[] args) {
	   int noOfCAPSAlpha = 1;
       int noOfDigits = 1;
       int noOfSplChars = 0;
       int minLen = 7;
       int maxLen = 7;
       DBInserter dbInserter=new DBInserter();
       String[] toppings = new String[200000];
       for (int i = 0; i < 200000; i++) {
           char[] pswd = RandomCodeGenerator.generatePswd(minLen, maxLen,
                   noOfCAPSAlpha, noOfDigits, noOfSplChars);
           toppings[i]=new String(pswd);
           dbInserter.insertMe(new String(pswd));
           System.out.println(/*"Len = " + pswd.length + ", " + */new String(pswd));
       }
       for(int i=0;i<200000;i++)
    	   for(int j=i+1;j<200000-i;j++)
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
