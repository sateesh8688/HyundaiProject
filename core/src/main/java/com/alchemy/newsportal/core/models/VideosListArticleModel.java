package com.alchemy.newsportal.core.models;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alchemy.newsportal.core.listeners.CapstonePath;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class VideosListArticleModel {

	@ValueMapValue
	private String[] youTubeLinks;

	
	List<String> youTubePlayVideList;


	private static final Logger LOG = LoggerFactory.getLogger(VideosListArticleModel.class);

	
	@PostConstruct
	public void init() {
		if (youTubeLinks != null) {
			youTubePlayVideList = new ArrayList<>();
			for (String url : youTubeLinks) {
				
				 // HttpClient can be used to send HTTP requests from client code to server.
				
				    CloseableHttpClient httpClient = HttpClients.createDefault();
					HttpGet request = new HttpGet(CapstonePath.YOUTUBEURL+ url);
					try(CloseableHttpResponse response = httpClient.execute(request)) {
						/*
						 * How to Get Entity ContentType in HttpClient - response.getEntity()
						 */
						HttpEntity entity = response.getEntity();
						if (entity != null) {							
							String result = EntityUtils.toString(entity);
							try(JsonReader jsonReader = Json.createReader(new StringReader(result))){
								JsonObject youtubeResponse = jsonReader.readObject();	
								youTubePlayVideList.add(youtubeResponse.getString("html"));	
							}	
						}
					} 
					
			      catch (IOException e) {
					LOG.info("fetching data from youtube api {}", e.getMessage());
				} finally {
					try {
						httpClient.close();
					} catch (IOException e) {
						LOG.info("closing http client object {}", e.getMessage());
					}
				}
			}
		}
	}

	
	public List<String> getYouTubePlayVideList() {
		return youTubePlayVideList;
	}

	
}
