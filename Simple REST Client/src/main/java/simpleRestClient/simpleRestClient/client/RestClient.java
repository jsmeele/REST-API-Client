package simpleRestClient.simpleRestClient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import model.GreetingModel;


@Component
public class RestClient {

	@Autowired
	private RestOperations restoperations;
	
	private final String url;
	
	@Autowired
	public RestClient (@Value("${greeting.service.url}")final String url) {
		this.url = url;
	}
	
	public GreetingModel getGreeting(final long id, final String content) {
		return restoperations.getForObject(url, GreetingModel.class, id, content);
	}
	
	public GreetingModel getGreeting() {
		return restoperations.getForObject(url, GreetingModel.class);
	}
}
