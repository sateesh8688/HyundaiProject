package com.alchemy.newsportal.core.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;



@Model (adaptables =  Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class VideoLinkModel {
	
	@ValueMapValue
	private String youTubeLinks;
	
	
	@ValueMapValue
	private String dateStr;
	
	
	@PostConstruct
	public void init() {
		Date date = new Date();  
		SimpleDateFormat formatter =  new SimpleDateFormat("EEEE, dd MMMM yyyy"); 
		dateStr = formatter.format(date);
	}
	
	
	public String getYouTubeLinks() {
		return youTubeLinks;
	}
	
	
	public String getDateStr() {
		return dateStr;
	}
	
}
