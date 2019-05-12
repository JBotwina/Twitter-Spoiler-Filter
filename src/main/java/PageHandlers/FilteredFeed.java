package PageHandlers;

/**
 * This class handles the display for the filtered feed page. The spoiler-free tweets get populated to this page. 
 * It contains buttons for site navigation and actions and a method called by Main.java that interacts with BackEndHandler to retrieve filtered tweets.
 * It implements the Route interface which is what is used to load and create the page on the website (localhost8080).
 * @authors Jhon Valencia, Melissa Amaya, James Botwina
 *
 */

public class FilteredFeed {

	private String tweetInfo;
	private String keyword;

	//header for filtered feed page website 
	private final String header =
			"<html><head><title>Spoiler Free Tweets</title><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" + 
			"</head>" +
					"<div text-align: center><h1>These are your spoiler free tweets: </h1></div>\n";

	//code for home button
	private final String homeButton = "<div><button type=\"button\" onclick=\"location.href='/home'\" class=\"btn btn-primary\">Home</button></form></div>";
	
	//additional code for site formatting
	private static String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
	
	//header for user input keywords
	String keywordDisplay = "<div><span style=\"font-weight:600;\">We are filtering for the following word(s): </span>" + keyword  + "</div><br/>" ;
	
	//creates refresh button
	String refreshButton = "<div><form action=\"filteredFeed?keyword=" + keyword + "\\ + method=\"get\"> "+
			"<button type=\"submit\" value=\"feed_refresh\" class=\"btn btn-outline-primary\">Refresh my feed</button>" +
			"</form></div></div></html>";
	
	// getter for bootstrap code
	public String getBootstrapJS() {
		return bootstrapJS;
	}

	// getter for keyword display
	public String getKeywordDisplay() {
		return keywordDisplay;
	}
	
	// getter for hidden feed button
	private String hiddenFeedButton =
			"<form action=\"hiddenFeed\" method=\"get\">" +
					"<button type=\"submit\" value=\"hiddenFeed\" class=\"btn btn-warning\">Spoiler Feed</button>"
					+ "</form></html>";
	
	//getter for refresh button
	public String getRefreshButton() {
		return refreshButton;
	}

	/**
	 * Input: String
	 * Output: String
	 * This method calls the static tweetToString static method in the BackEndHandler class. It passes in a keyword
	 * for tweets to get filtered by. 
	 * @param keyword
	 * @return tweetInfo
	 */
	public String getTweetInfo(String keyword) {
		tweetInfo = "";
		tweetInfo = BackEndHandler.tweetToString(BackEndHandler.filteredFeed(keyword));
		return tweetInfo;
	}

	//getter for header
	public String getHeader() {
		return header;
	}

	//getter for home button
	public String getHomeButton() {
		return homeButton;
	}

	//getter for hidden feed button
	public String getHiddenFeedButton() {
		return hiddenFeedButton;
	}

	//getter for keyword header
	public String getKeywordDiv() {
		return "<div><h4>We are filtering for the following word(s): </h4><p> " + getKeyword() + "</p></div>";
	}
	
	//getter for keyword
	public String getKeyword() {
		return keyword;
	}

	//setter for keyword
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
