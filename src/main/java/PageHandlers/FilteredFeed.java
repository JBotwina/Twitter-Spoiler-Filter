package PageHandlers;

public class FilteredFeed {

	private String tweetInfo;
	private String keyword;

	public FilteredFeed() {
//		 tweetInfo =
//		 backEndHandlerParam.tweetToString(backEndHandlerParam.filteredFeed());
	}

	private final String header =
			"<html><head><title>Spoiler Free Tweets</title><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" + 
			"</head>" +
					"<div text-align: center><h1>These are your spoiler free tweets: </h1></div>\n";

	private final String homeButton = "<div><button type=\"button\" onclick=\"location.href='/home'\" class=\"btn btn-primary\">Home</button></form></div>";
	
//	private final String homeButton = "<div><form action=\'\\' method =\"get\"><button type=\"submit\" class=\"btn btn-primary\">Home</button></form></div>";
	
	private static String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
	
	public String getBootstrapJS() {
		return bootstrapJS;
	}

	private String hiddenFeedButton =
			"<form action=\"hiddenFeed\" method=\"get\">" +
					"<button type=\"submit\" value=\"hiddenFeed\" class=\"btn btn-warning\">Spoiler Feed</button>"
					+ "</form></html>";
	
	private String refreshButton = "<div><form action=\"filteredFeed\" name=\"keyword\" id=\"keyword\" value=" + keyword + " method=\"get\"> "+
			"<button type=\"submit\" value=\"feed_refresh\" class=\"btn btn-outline-primary\">Refresh my feed</button>" +
			"</form></div></div></html>";
	
//	"<form class=\"form-inline\" action=\"/filteredFeed\" method=get><label class=\"sr-only\" for=\"inlineFormInputName2\">Words to Filter</label>" 
//	+ "<input type=\"text\" class=\"form-control mb-2 mr-sm-2\" name=\"keyword\" id=\"keyword\"placeholder=\"words to filter\" required> "
//	+ "<br><input type=\"submit\" value=\"Show me my filtered feed\" class=\"btn btn-primary mb-2\"></form>";

	public String getRefreshButton() {
		return refreshButton;
	}

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

	public String getKeywordDiv() {
		return "<div><h4>We are filtering for the following word(s): </h4><p> " + getKeyword() + "</p></div>";
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
