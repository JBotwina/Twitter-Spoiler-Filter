package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

public class HiddenFeed implements Route{
	private String tweetInfo; 
	
	public HiddenFeed() {
//		tweetInfo = backEndHandlerParam.tweetToString(backEndHandlerParam.getBadStatuses());
	}

	private final String header = "<html><head><title>Spoiler Tweets</title></head>\n" + 
			"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"></head>" + 
			"<div text-align: center><h1>These are your spoiler tweets: </h1>\n";
	
	private final String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
		 
	private final String homeButton = "<button type=\"button\" onclick=\"location.href='/'\">Home</button>";
	
	public String getTweetInfo() {
		tweetInfo = BackEndHandler.tweetToString(BackEndHandler.getBadStatuses());
		return tweetInfo;
	}
	
	public Object handle(Request request, Response response) throws Exception {
		return header + homeButton + "<body>" + tweetInfo + bootstrapJS + "</body></html>";
	}
	
}
