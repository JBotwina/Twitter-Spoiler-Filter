package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class handles the formatting for the hidden feed page. The spoiler tweets get populated to this page. 
 * It implements the Route interface which is what is used to load and create the page on the website (localhost8080).
 * It collaborates with the BackEndHandler class, to get the proper HTML code for viewing purposes.
 * @authors Jhon Valencia, Melissa Amaya, James Botwina
 *
 */

public class HiddenFeed implements Route{
	private String tweetInfo; 

	//header for hidden page website 
	private final String header = "<html><head><title>Spoiler Tweets</title><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">" + 
			"</head>" + "<div text-align: center><h1>These are your spoiler tweets </h1></div>\n";
	
	//additional formatting for page
	private final String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
	
	// creates home button
	private final String homeButton = "<div><form action=\'\\' method =\"get\"><button type=\"submit\" class=\"btn btn-primary\">Home</button></form></div>";
	
	/***
	 * Input: null
	 * Output: String
	 * This method calls the static tweetToString method on the BackEndHandler class for the spoiler tweets.
	 * The length of 136 characters is how long the header is for the header on the page (see rows 32 to 36 below).
	 * Therefore if we don't have any tweets the length of the tweetInfo string will always be 135 characters.
	 * If length is less than 136 characters, then no spoiler tweets were found and we should replace the header with No Spoilers. 
	 * @return tweetInfo
	 */
	public String getTweetInfo() {
		tweetInfo = BackEndHandler.tweetToString(BackEndHandler.getBadStatuses());
		if (tweetInfo.length() < 136) {
			tweetInfo = ("<div class=\"container\">\r\n" + 
					"  <div class=\"page-header\">\r\n" + 
					"    <h1 id=\"timeline\">No Spoiler Tweets!</h1>\r\n" + 
					"  </div>\r\n" + 
					"  <ul class=\"timeline\">");
		}
		return tweetInfo;
	}
	
	// Default handle method for routes
	public Object handle(Request request, Response response) throws Exception {
		return "<div class = \"container\">" + header + getKeyword() + homeButton + "</div><body>" + getTweetInfo() + bootstrapJS + "</body></html>";
	}
	
	// getter for keyword on page
	private String getKeyword() {
		return "<div><span style=\"font-weight:600;\">These are the tweets that contained your keyword(s): </span>" + BackEndHandler.getWordsToFilter() + "</div></br>";
	}
	
}
