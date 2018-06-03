package com.application.monitoringApp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Formatter;



public class CurlDemo1 {

	public static void main(String[] args) {
		
		
		sendRequest();
	}
	
	public static String[] sendRequest(){
		
		String comp_status = null;
		Formatter formatter = new Formatter();
	    System.out.println(formatter.format("%20s %20s %20s %20s", "timestamp_epoch", "status_check", "URL", "response_time_ms"));
	    
		String[] urls = {"https://www.youtube.com", 
						"https://www.google.com", 
						"https://www.mkyong.com",
						"https://www.journaldev.com/7148/java-httpurlconnection-example-java-http-request-get-post",
						"http://sub-second.blogspot.com/2012/08/how-to-measure-response-times-in-java.html",
						"https://alvinalexander.com/java/java-string-array-reference-java-5-for-loop-syntax",
						"http://grails.asia/java-string-array-declaration",
						"http://www.freelinuxconsole.info/terminal/"};
		
		for (String s: urls)
        {
          //System.out.println(s);
			long milliStart = System.currentTimeMillis();
          try {
  			
  			//System.out.println("URL= "+s);
  			URL url = new URL(s);
  	        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
  	        connection.setRequestMethod("GET");
  	        connection.connect();

  	       int code = connection.getResponseCode();
  	      
  	       /*Map<String, List<String>> map= connection.getHeaderFields();
  	       
  	       for (Map.Entry<String, List<String>> entry : map.entrySet()) {
  	   		System.out.println("Key : " + entry.getKey() + 
  	                    " ,Value : " + entry.getValue());
  	   	}*/
  	       
  	       //System.out.println(" "); 
  	       //System.out.println("Response code is "+code);
  	        
  	        if (code==200)
  	        {
  	        	comp_status="GREEN";
  	           // System.out.println("Component Status-"+comp_status);
  	        }
  	        else {
  	        	//System.out.println("Not responding very well");
  	        	comp_status="RED";
  	        }
  		 
  		    } catch (Exception e) {
  		    e.printStackTrace();
  		    }
          
        
  		long milliEnd = System.currentTimeMillis();
  		long milliTime = milliEnd - milliStart;
  		String res_time=reportResponseTimes(milliTime);
  		
  		
  		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       // System.out.println("Current timestamp= "+timestamp);
       // System.out.println("");
        
        formatter = new Formatter();
        //String rowData = "info" + i;
        System.out.println(formatter.format("%20s %20s %20s %20s ", timestamp, comp_status, s, res_time));
          
        }
		return urls;
		
    }
	
	private static String reportResponseTimes(long milliTime)
    {
        // convert nanoseconds to milliseconds and display both times with three digits of precision (microsecond)
        String milliFormatted = String.format("%,.3f", milliTime / 1.0 );
        //System.out.println("Responce time in Milliseconds: " + milliFormatted);
        return milliFormatted;
    }

	
	
	

}

