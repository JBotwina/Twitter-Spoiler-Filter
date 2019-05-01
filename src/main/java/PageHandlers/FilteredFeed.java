package PageHandlers;

import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;

public class FilteredFeed implements Route{
	
	private String tweetInfo; 
	
	public FilteredFeed() {
		// tweetInfo = backEndHandlerParam.tweetToString(backEndHandlerParam.filteredFeed());
	}

	private final String header = "<html><head><title>Spoiler Free Tweets</title></head>\n" + 
			"<div text-align: center><h1>These are your spoiler free tweets: </h1>\n";
		 
	private final String homeButton = "<button type=\"button\" onclick=\"location.href='/'\">Home</button>";
	
	private String hiddenFeedButton = "<form action=\"hiddenFeed\" method=\"get\"> "+
			"<button type=\"submit\" value=\"hiddenFeed\">Spoiler Feed</button>" +
			"</form></div></html>";
	
	public String getTweetInfo() {
		BackEndHandler.tweetToString()
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

	public Object handle(Request request, Response response) throws Exception {
		return header + homeButton + hiddenFeedButton + tweetInfo;
	}
	
}
