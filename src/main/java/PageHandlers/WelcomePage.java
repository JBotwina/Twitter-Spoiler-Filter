package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * 
 * @author mamaya
 *	handles front end view for user. Provides form for user to enter keyword to filter and button to display full, unfiltered feed
 */
public class WelcomePage implements Route {
	
	//header for website
	private final String header = "<html><head><title>Welcome to Twitter Filter</title></head>\n" + 
			"<div text-align: center class=\"container\"><h1>Welcome to Twitter Filter by</h1>\n" + 
			"<h2>James Botwina, Jhon Valencia, Melissa Amaya</h2>\n" + 
			"<p>For our MCIT 591 Final Class Project, Spring 2019</p>";
	
	// user instructions
	private final String instructions = "<p>You can choose to view your full, unfiltered, Twitter feed, or enter keywords that you want filtered out of your feed for a period of time. </p>";
	
	// form to enter keyword
	private String keyWordForm = "<form action=\"/filteredFeed\" method=get> "
			+ "<input type=\"text\" name=\"keyword\" id=\"keyword\"placeholder=\"enter keyword(s) to filter\" required> "
			+ "<br><input type=\"submit\" value=\"Show me my filtered feed\" class=\"btn btn-primary\"></form>";

	// button to view unfiltered feed
	private String fullFeedButton = "<form action=\"fullFeed\" method=\"get\"> "+
			"<button type=\"submit\" value=\"Show full feed\">Show Full Feed</button>" +
			"</form></div></html>";
	
	// returns objects for front end display
	public Object handle(Request request, Response response) throws Exception {
		return header + instructions + keyWordForm + fullFeedButton;
	}
	
}
