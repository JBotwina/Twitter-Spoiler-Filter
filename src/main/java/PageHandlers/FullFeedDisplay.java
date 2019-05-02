package PageHandlers;

import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Handles the display of the full, unfiltered twitter feed
 * @author mamaya
 *
 */
public class FullFeedDisplay implements Route{
	private final String header = "<h1>Full Twitter Feed</h1>";
	private final String homeButton = "<button type=\"button\" onclick=\"location.href='/'\">Home</button>";
//	private final String seeHiddenFeedBtn = "<button type=\"button\" onclick=\"location.href='/hiddenFeed'\">All Clear. See What I Missed</button>";
	private String tweets;
	

	public FullFeedDisplay() {
		tweets = BackEndHandler.fullFeed();
	}
//	
	
	public Object handle(Request request, Response response) throws Exception {
		
		return header + homeButton +  tweets;
	}

}
