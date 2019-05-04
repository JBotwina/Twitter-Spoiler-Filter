package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

public class FilteredFeed implements Route {

	private String tweetInfo;

	public FilteredFeed() {
		// tweetInfo =
		// backEndHandlerParam.tweetToString(backEndHandlerParam.filteredFeed());
	}

	private final String header =
			"<html><head><title>Spoiler Free Tweets</title>\"<link rel=\\\"stylesheet\\\" href=\\\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\\\" integrity=\\\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\\\" crossorigin=\\\"anonymous\\”></head>\n" +
					"<div text-align: center><h1>These are your spoiler free tweets: </h1>\n";

	private final String homeButton =
			"<button type=\"button\" onclick=\"location.href='/'\" class=\"btn btn-outline-primary\">Home</button>";

	private static String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
	
	public String getBootstrapJS() {
		return bootstrapJS;
	}

	private String hiddenFeedButton =
			"<form action=\"hiddenFeed\" method=\"get\"> " +
					"<button type=\"submit\" value=\"hiddenFeed\" class=\"btn btn-outline-primary”>Spoiler Feed</button>"
					+
					"</form></div></html>";

	private static String keyword;

	public String getTweetInfo(String keyword) {
		tweetInfo = BackEndHandler
				.tweetToString(BackEndHandler.filteredFeed(keyword));
		this.keyword = keyword;
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

	public Object handle(Request request, Response response)
			throws Exception {
		return header + homeButton + hiddenFeedButton + tweetInfo;
	}

	public String getKeywordDiv() {
		System.out.println(getKeyword());
		return "<div><h4>We are filtering for the following word(s): </h4><p> " + getKeyword() + "</p></div>";
	}
	public static String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
