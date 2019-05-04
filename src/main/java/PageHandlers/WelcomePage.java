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
	private final String header = "<html><head><title>Welcome to Twitter Filter</title></head>\n" + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"></head>" + 
			"<div text-align: center class=\"container\"><h1>Welcome to Twitter Filter by</h1>\n" + 
			"<h2>James Botwina, Jhon Valencia, Melissa Amaya</h2>\n" + 
			"<p>For our MCIT 591 Final Class Project, Spring 2019</p>";
	
	private final String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
	
	// user instructions
	private final String instructions = "<p>You can choose to view your full, unfiltered, Twitter feed, or enter keywords that you want filtered out of your feed for a period of time. </p>";
	
	// form to enter keyword
	private String keyWordForm = "<form action=\"/filteredFeed\" method=get> "
			+ "<input type=\"text\" name=\"keyword\" id=\"keyword\"placeholder=\"enter keyword(s) to filter\" required> "
			+ "<br><input type=\"submit\" value=\"Show me my filtered feed\" class=\"btn btn-outline-secondary\"></form>";

	// button to view unfiltered feed
	private String fullFeedButton = "<form action=\"fullFeed\" method=\"get\"> "+
			"<button type=\"submit\" value=\"Show full feed\" class=\"btn btn-outline-primary\">Show Full Feed</button>" +
			"</form>"+bootstrapJS+"</div></html>";
	
	// returns objects for front end display
	public Object handle(Request request, Response response) throws Exception {
		return header + instructions + keyWordForm + fullFeedButton;
	}
	
}
