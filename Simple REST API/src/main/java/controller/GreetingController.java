package controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.GreetingModel;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value="/greeting", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public GreetingModel greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
    	return new GreetingModel(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(value="/greettrue", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public String greettrue(@RequestParam(value="name", required=false, defaultValue="greettrue") String name) {
        GreetingModel greet = new GreetingModel(counter.incrementAndGet(), String.format(template, name));
    	return prettyJSON(greet, true);
    }
    
    @RequestMapping(value="/greetfalse", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public String greetfalse(@RequestParam(value="name", required=false, defaultValue="greetfalse") String name) {
        GreetingModel greet = new GreetingModel(counter.incrementAndGet(), String.format(template, name));
    	return prettyJSON(greet, false);
    }


	private String prettyJSON(Object obj, boolean enable) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			String jsonInString;
			if (enable) {
				// Convert object to JSON string and pretty print
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
				System.out.println(enable + "  " + jsonInString);
		    } else {
				// Convert object to JSON string
				jsonInString = mapper.writeValueAsString(obj);
				System.out.println(enable + "  " + jsonInString);
		    } 
			return jsonInString;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}