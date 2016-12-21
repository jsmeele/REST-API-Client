package simpleRestClient.simpleRestClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.GreetingModel;
import simpleRestClient.simpleRestClient.client.RestClient;

@SpringBootApplication
public class Client implements CommandLineRunner
{
	
	private static  final Logger logger = LoggerFactory.getLogger(Client.class);
	
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	SpringApplication.run(Client.class, args);
    }
    
    @Autowired
    private RestClient client;
    
    @Override
    public void run(String... args) throws Exception {
    	GreetingModel greeting = client.getGreeting(1, "Jan");
    	//GreetingModel greeting = client.getGreeting();
    	logger.info("Response: {}", greeting.getContent());
    }
}
