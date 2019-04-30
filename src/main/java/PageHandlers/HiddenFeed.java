package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

public class HiddenFeed implements Route{
	private String tweetInfo; 
	
	public HiddenFeed(BackEndHandler backEndHandlerParam) {
		tweetInfo = backEndHandlerParam.tweetToString(backEndHandlerParam.getBadStatuses());
	}

	private final String header = "<html><head><title>Spoiler Tweets</title></head>\n" + 
			"<div text-align: center><h1>These are your spoiler tweets: </h1>\n";
		 
	private final String homeButton = "<button type=\"button\" onclick=\"location.href='/'\">Home</button>";
	
	public Object handle(Request request, Response response) throws Exception {
		return header + homeButton + tweetInfo;
	}
	
}
