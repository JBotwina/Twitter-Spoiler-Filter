package PageHandlers;

/**
 * This class handles the display for the FilteredFeed page. It contains buttons for site navigation and actions and a method called by Main.java that interacts with BackEndHandler to retrieve filtered tweets.
 * @author mamaya
 *
 */
public class FilteredFeed {

	private String tweetInfo;
	private String keyword;
	
	// page header
	private final String header =
			"<html><head><title>Spoiler Free Tweets</title><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" + 
			"</head>" +
					"<div text-align: center><h1>These are your spoiler free tweets: </h1></div>\n";

	// home button
	private final String homeButton = "<div><button type=\"button\" onclick=\"location.href='/home'\" class=\"btn btn-primary\">Home</button></form></div>";
	
	// bootstrap import
	private static String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";

	// refresh button
	String refreshButton = "<div><form action=\"filteredFeed?keyword=" + keyword + "\\ + method=\"get\"> "+
			"<button type=\"submit\" value=\"feed_refresh\" class=\"btn btn-outline-primary\">Refresh my feed</button>" +
			"</form></div></div></html>";
	
	public String getBootstrapJS() {
		return bootstrapJS;
	}

	public String getKeywordDisplay() {
		return "<div><span style=\"font-weight:600;\">We are filtering for the following word(s): </span>" + getKeyword()  + "</div><br/>" ;
	}
	
	// button to display spoiler tweets
	private String hiddenFeedButton =
			"<form action=\"hiddenFeed\" method=\"get\">" +
					"<button type=\"submit\" value=\"hiddenFeed\" class=\"btn btn-warning\">Spoiler Feed</button>"
					+ "</form></html>";
	
	
	public String getRefreshButton() {
		return refreshButton;
	}

	// retrieves tweet feed filtering out the keyword
	public String getTweetInfo(String keyword) {
		tweetInfo = "";
		tweetInfo = BackEndHandler
				.tweetToString(BackEndHandler.filteredFeed(keyword));
		return tweetInfo;
	}

	public String getHeader() {
		return header;
	}

	public String getHomeButton() {
		return homeButton;
	}

	public String getHiddenFeedButton() {
		return hiddenFeedButton;
	}

	// display to indicate the keyword entered
	public String getKeywordDiv() {
		System.out.println("hello" + getKeyword());
		return "<div><h4>We are filtering for the following word(s): </h4><p> " + getKeyword() + "</p></div>";
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
