package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * 
 * @author mamaya
 *	handles front end view for user.
 */
public class WelcomePage implements Route {
// why is /n not working??
//	private String hello = "Welcome to the Twitter Filter. \n What word(s) do you want to filter out?";
	
	private final String header = "<html><head><title>Welcome to Twitter Filter</title></head>\n" + 
			"<div text-align: center><h1>Welcome to Twitter Filter by</h1>\n" + 
			"<h2>James Botwina, Jhon Valencia, Melissa Amaya</h2>\n" + 
			"<p>For our MCIT 591 Final Class Project, Spring 2019</p>";
	private final String instructions = "<p>You can choose to view your full, unfiltered, Twitter feed, or enter keywords that you want filtered out of your feed for a period of time. </p>";
	private String keyWordForm = "<form action=\"/filteredFeed\" method=\"post\"><input type=\"text\" name=\"keyword\"placeholder=\"enter keyword(s) to filter\" ><br><input type=\"submit\" value=\"Show me my filtered feed\"></form>";
	
	private 
//	
//	String buttonFullFeed = "<button onclick = "+
//			"location.href = '/fullFeed;'"  +
//			"id='fullFeedButton'";
////	
//	
	String fullFeedButton = "<form action=\"fullFeed\" method=\"get\"> "+
			"<button type=\"submit\" value=\"Show full feed\">Show Full Feed</button>" +
			"</form></div></html>";
	
	public Object handle(Request request, Response response) throws Exception {
		return header + instructions + keyWordForm + fullFeedButton;
	}
	
}
