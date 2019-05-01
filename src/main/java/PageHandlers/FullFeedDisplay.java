package PageHandlers;

import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;
import twitter4j.Status;

public class FullFeedDisplay implements Route{
	private final String header = "<h1>Full Twitter Feed</h1>";
	private final String homeButton = "<button type=\"button\" onclick=\"location.href='/'\">Home</button>";
	private ArrayList<Status> tweets;
	
	public HiddenFeed(BackEndHandler backEndHandlerParam) {
		tweets = backEndHandlerParam.tweetToString(backEndHandlerParam.getBadStatuses());
	}
//	public FullFeedDisplay() {
//		tweets = BackEndHandler.fullFeed();
//	}
//	
	
	public Object handle(Request request, Response response) throws Exception {
		
		return header + homeButton;
	}

}
