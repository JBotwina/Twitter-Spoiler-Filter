package PageHandlers;

/**
 * Handles the display of the full, unfiltered twitter feed. Has a single backend end call and 
 * @author mamaya
 *
 */
public class FullFeedDisplay {
	private final String header = "<head><h1>Full Twitter Feed</h1><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"></head>";
	
	private final String homeButton = "<div><button type=\"button\" onclick=\"location.href='/home'\" class=\"btn btn-primary\">Home</button></form></div>";
//	private final String homeButton = "<div><form action=\'\\' method =\"get\"><button type=\"submit\" class=\"btn btn-primary\">Home</button></form></div>";
	private final String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
	private final String refreshButton = "<div><form action=\"fullFeed\" method=\"get\"> "+
			"<button type=\"submit\" value=\"feed_refresh\" class=\"btn btn-outline-primary\">Refresh my feed</button>" +
			"</form></div></div></html>";
	private String tweets;
	
	
	public String getHeader() {
		return header;
	}

	public String getHomeButton() {
		return homeButton;
	}

	public String getTweets() {
		return tweets;
	}

	public String getBootstrapJS() {
		return bootstrapJS;
	}

	public String getRefreshButton() {
		return refreshButton;
	}

//	
//	
//	/**
//	 * calls a method in the BackEndHandler class that retrieves a formatted string of unfiltered tweet objects
//	 */
//	public FullFeedDisplay() {
//		System.out.println("posting");
////		tweets = BackEndHandler.fullFeed();
//	}
//	
	public String PullTweets() {
		return BackEndHandler.fullFeed();
	}

}
