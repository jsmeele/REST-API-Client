package model;

//import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GreetingModel {

	private final long id;
	private final String content;
	
	//@JsonCreator
    public GreetingModel(@JsonProperty("id") long id, @JsonProperty("content") String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
	
	
//    private long id;
//    private String content;
//
//    public GreetingModel(long id, String content) {
//        this.id = id;
//        this.content = content;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//    
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
}