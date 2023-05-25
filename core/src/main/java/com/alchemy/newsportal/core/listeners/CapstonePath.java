package com.alchemy.newsportal.core.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CapstonePath {

	private CapstonePath() {
	    throw new IllegalStateException("ConstantPaths class");
	    
	  }

	
	
	public static final String YOUTUBEURL="https://www.youtube.com/oembed?" +"url=";
	
	
	public static final String SUB_SERVICE_NAME = "cpservice";
	
	public static String getDateF(Date date) {
		if(date !=null) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("EEE,dd MMMM yyyy");	
			return  formatter.format(date);
		}
		
		return null;

	}
	
	
}
