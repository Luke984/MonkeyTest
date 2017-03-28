package com.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;

//provaRead.MonkeyWrite();
//provaRead.monkeyCSVWriteClose();
	

public class Executer {

	public static void main(String[] args) throws Exception
	{
		MonkeyTest test = new MonkeyTest();
		//java.lang.reflect.Method method = null;
		//String provaarr[];
		//int i = 0;

		MonkeyDocumentation documentazione = new MonkeyDocumentation(new MonkeyCSV("tests.csv"));
		// DA provare a commentare e richiamare -> documentazione.MonkeyMakerDocs(MonkeyTest prova);
			//	int q ;
				documentazione.MonkeyWriteDoc("ilvalore.txt");

				documentazione.MonkeyMakerDocs(test);
		documentazione.MonkeyCloser();
					
					
				
				

		
		
		/*String[] arr = new String[2];
		arr[0]="http://www.corriere.it";
		arr[1]="http://www.gazzetta.it";
		while(n<2)
		{ System.out.println(arr[n]);
			prova.site=arr[n];			
			try { 
				prova.startup();
				prova.monkeyErrorLog();
				prova.monkeyCheckListpos();
				
			} catch(Exception e) {
		        System.out.println("puppa");
		    }
			n++;
			
		}*/
		
	
}
}

