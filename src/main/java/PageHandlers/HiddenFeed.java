package PageHandlers;

import spark.Request;
import spark.Response;
import spark.Route;

public class HiddenFeed implements Route{
	private String tweetInfo; 

	//header for hidden page website 
	private final String header = "<html><head><title>Spoiler Tweets</title><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">" + 
			"</head>" + "<div text-align: center><h1>These are your spoiler tweets </h1></div>\n";
	
	
	private final String bootstrapJS = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
		 
	private final String homeButton = "<div><form action=\'\\' method =\"get\"><button type=\"submit\" class=\"btn btn-primary\">Home</button></form></div>";
	
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
	
	public Object handle(Request request, Response response) throws Exception {
		return "<div class = \"container\">" + header + getKeyword() + homeButton + "</div><body>" + getTweetInfo() + bootstrapJS + "</body></html>";
	}

	private String getKeyword() {
		return "<div><span style=\"font-weight:600;\">These are the tweets that contained your keyword(s): </span>" + BackEndHandler.getWordsToFilter() + "</div></br>";
	}
	
}
