package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Handles the display of the full, unfiltered twitter feed. Has a single backend end call and 
 * @author mamaya
 *
 */
public class FullFeedDisplay implements Route{
	private final String header = "<h1>Full Twitter Feed</h1>";
	private final String homeButton = "<button type=\"button\" onclick=\"location.href='/'\">Home</button>";
	private String tweets;
	private final String refreshButton = "<form action=\"fullFeed\" method=\"get\"> "+
			"<button type=\"submit\" value=\"feed_refresh\">Refresh my feed</button>" +
			"</form></div></html>";
	
	/**
	 * calls a method in the BackEndHandler class that retrieves a formatted string of unfiltered tweet objects
	 */
	public FullFeedDisplay() {
		tweets = BackEndHandler.fullFeed();
	}

	/**
	 * Returns all the display objects for the browser
	 */
	public Object handle(Request request, Response response) throws Exception {
		
		return header + homeButton + refreshButton + tweets;
	}

}
