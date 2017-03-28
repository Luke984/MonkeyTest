package com.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.lang3.*;

import org.apache.commons.lang3.ArrayUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;



public class MonkeyDocumentation {

	private String title;
	public String Browsers[];
	public String Tests[];
	public String Sites[];
	public String Kws[];
	public String Search[];
	public String Target[];
	
	public int n;
	private String results[]; 
	private MonkeyCSV csv;
	public String PROTOCOL = "http";
	public Boolean proxied;
	
	public MonkeyDocumentation(MonkeyCSV ciessevu){
		
		this.csv = ciessevu;
		int i = 0;
		ArrayList<ArrayList<String>> provaarr ;
		try {
			provaarr= this.csv.monkeyRead();
			System.out.println(provaarr.size());
			while(i<provaarr.size()){
				switch(provaarr.get(i).get(0).toString()){
				case "PROXIED" : this.proxied = Boolean.parseBoolean(provaarr.get(i).get(1));
				case "TITOLO":this.title = provaarr.get(i).get(1).toString();
				break;
				case "SITES": 
					this.Sites = provaarr.get(i).toArray(new String[0]);
				break;
				case "BROWSERS":this.Browsers = provaarr.get(i).toArray(new String[0]);
				break;
				case "KWS":this.Kws = provaarr.get(i).toArray(new String[0]);
				break;
				case "NVOLTE": this.n = Integer.parseInt(provaarr.get(i).get(1));
				break;
				case "TESTS" : this.Tests = provaarr.get(i).toArray(new String[0]);
				break;
				case "SEARCH" : this.Search = provaarr.get(i).toArray(new String[0]);
				break; 
				case "TARGET" : this.Target = provaarr.get(i).toArray(new String[0]);
				break;
				case "XML" : ;
				
				}
				
				i++;
			}
			provaarr.clear();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void MonkeyWriteData(String Method, Object value) throws IOException{
		this.csv.monkeyCSVData(Method);
		this.csv.monkeyCSVColumn();
		this.csv.monkeyCSVData(value.toString());
		this.csv.monkeyCSVNewLine();
	}
	
	public void MonkeyWriteDoc(String nomefile) throws SecurityException, IOException{
		if (nomefile.isEmpty())
			this.csv.MonkeyWrite();
		else
			this.csv.MonkeyWrite(nomefile);
		this.csv.monkeyCSVData(this.title);
		this.csv.monkeyCSVNewLine();
		
		
	}
	public void MonkeyMakerDocs(MonkeyTest test) throws Exception{
	
		java.lang.reflect.Method method = null;
		int q ;
		//ArrayUtils prova = new ArrayUtils();
		ArrayList provaXML = new ArrayList<String>();
		NodeList p ; 
		System.out.println(this.Sites.length);
		System.out.println(this.Sites[1].contains("["));
		System.out.println(this.Sites[1].replace("[", "").replace("]", ""));
		if(this.Sites.length == 2 && this.Sites[1].contains("[")){
		MonkeyXML mxml = new MonkeyXML();
		this.Sites = mxml.MonkeyXML(test.monkeySitemap(this.Sites[1].replace("[", "").replace("]", "")));
		System.out.println("prova : "+test.monkeySitemap(this.Sites[1].replace("[", "").replace("]", "")));
		}
		
		//System.exit(1);
	    //driver
		//mxml.MonkeyXML(test.monkeySitemap("http://www.exagoonlus.it"));
		//System.out.println(test.monkeySitemap("http://www.formulapassion.it"));
		
		/*for(int i = 0 ; i<p.getLength();i++)
		{
			System.out.println("qua : "+p.item(i).getNodeValue());
			provaXML.add(p.item(i).getNodeValue());
		}*/
		
		//System.out.println();
		
		for(String site:this.Sites){
			if(!site.contentEquals("SITES") ){
			for (String kws:this.Kws){
				if(!kws.contentEquals("KWS") )
			for(q = 0;q<this.n;q++){
					
					
						if(this.proxied)
							test.setProxy();
						for(int b = 1; b < this.Browsers.length ; b++){//\[(.*?)\]
							//cambiare con reg exp
							//System.out.println("questo e' browser : "+this.Browsers[b].substring(this.Browsers[b].indexOf("[")).replace("[", "").replace("]", ""));
							
							
							/*switch(this.Browsers[b].substring(this.Browsers[b].indexOf("[")).replace("[", "").replace("]", "").toLowerCase()){
							case "iphone" : System.out.println("sono dentro iphono"); System.exit(0); break;
							case "android" : break;
							case "win": break;
							case "apple": break;
							}*/
						test.DriverSTD(this.Browsers[b]);
						System.out.println(site);
						
						test.site =site.contains("http")?site+""+kws: PROTOCOL+"://"+site+""+kws;
						System.out.println(test.site);
						test.startup();
						System.out.println("0 :"+this.Tests[0]);
						for(int i=1;i<this.Tests.length;i++)
						{ 
							System.out.println(this.Tests[i]);
							
							if(this.Tests[i].toString().compareTo("monkeyScreenyTarget")!=0){
								method = test.getClass().getMethod(this.Tests[i]);
						this.MonkeyWriteData(this.Tests[i], method.invoke(test)); }
							else{
								try{
								method = test.getClass().getMethod(this.Tests[i], String[].class);
							} catch (SecurityException e) { System.out.println("ERROR SECURITY"); }
							  catch (NoSuchMethodException e) { System.out.println("ERROR METHOD NOT EXIST"); }
								this.MonkeyWriteData(this.Tests[i], method.invoke(test,(Object) this.Target)); 								
							}
						
						}
						
					}
						
					
					System.out.println("QUESTO E' Q : "+q);
			}
					
					
					
		}
		}
		}
		
	}
	
	public void MonkeyCloser() throws IOException{ this.csv.monkeyCSVWriteClose();}
	
}
