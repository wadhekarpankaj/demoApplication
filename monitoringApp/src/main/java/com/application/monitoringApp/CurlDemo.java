package com.application.monitoringApp;


import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;


public class CurlDemo {

	public static void main(String[] args) {
		
		sendRequest();
	}
	
	private static void sendRequest(){
		
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
  			
  			System.out.println("URL= "+s);
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
  	       System.out.println("Response code is "+code);
  	        
  	        if (code==200)
  	        {
  	            System.out.println("Component Status- GREEN");
  	        }
  	        else {
  	        	System.out.println("Not responding very well");
  	        }
  		 
  		    } catch (Exception e) {
  		    e.printStackTrace();
  		    }
          
        
  		long milliEnd = System.currentTimeMillis();
  		long milliTime = milliEnd - milliStart;
  		reportResponseTimes(milliTime);
  		
  		
  		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Current timestamp= "+timestamp);
        System.out.println("");
        
          
        }
		
    }
	
	private static void reportResponseTimes(long milliTime)
    {
        // convert nanoseconds to milliseconds and display both times with three digits of precision (microsecond)
        String milliFormatted = String.format("%,.3f", milliTime / 1.0 );
        System.out.println("Responce time in Milliseconds: " + milliFormatted);
    }
	
	

}
