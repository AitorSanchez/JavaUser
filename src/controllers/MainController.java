package controllers;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MainController {
	
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final String APIUrl = "https://gorest.co.in/public-api/users/";

    //main method of the controller
	public User getUserById(int id) {
		
		String url = APIUrl + id;
		User result = null;
		
		//FIRST: obtain the JSON string
		String json = "";
		try {
			json = this.sendGet(url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//SECOND: map the JSON into a User Object
		if (json != "") {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				result = objectMapper.readValue(json, User.class);
				
				//THIRD: changes some User attributes
				result.getModified();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		return result;
	}
	
	//sends a GET Request against the given url
	private String sendGet(String url) throws ClientProtocolException, IOException {
		String response = "";
		HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse httpResp = httpClient.execute(request)) {
            HttpEntity entity = httpResp.getEntity();
            if (entity != null) {
            	response = EntityUtils.toString(entity);
            }
        }
		
		return response;
	}


}
