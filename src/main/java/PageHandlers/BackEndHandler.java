package PageHandlers;

import java.util.ArrayList;
import backEnd.TwitterExample;
import twitter4j.Status;

public class BackEndHandler {
	private static TwitterExample te;
	private static String wordsToFilter;


	public static String getWordsToFilter() {
		return wordsToFilter;
	}

	public BackEndHandler() {
		te = new TwitterExample();
	}

	public static ArrayList<Status> getBadStatuses() {
		return te.getSpoilerTweets();	
	}
	
	public static String fullFeed() {
		te = new TwitterExample();
		String fullStatuses = tweetToString(te.getUnfilteredStatuses());
		return fullStatuses;
	}
		
	public static ArrayList<Status> filteredFeed(String keyword) {
		wordsToFilter = keyword;
		te.parseTweets(keyword);
		return te.getGoodStatuses();
	}
	
	public static String tweetToString(ArrayList<Status> tweets) {
		StringBuilder tweetData = new StringBuilder();
		
		tweetData.append("<div class=\"container\">\r\n" + 
				"  <div class=\"page-header\">\r\n" + 
				"    <h1 id=\"timeline\">Timeline</h1>\r\n" + 
				"  </div>\r\n" + 
				"  <ul class=\"timeline\">");
		for (Status status : tweets) {
	
			tweetData.append("<li><div class=\"timeline-badge\"><i class=\"glyphicon glyphicon-check\"></i></div>\r\n" + 
					"      <div class=\"timeline-panel\">\r\n" + 
					"        <div class=\"timeline-heading\">");
			tweetData.append("<h4 class=\"timeline-title\">" + status.getUser().getName() + "</h4>");
			tweetData.append("<p><small class=\"text-muted\"><i class=\"glyphicon glyphicon-time\"></i>" + status.getCreatedAt() + "</small></p>\r\n" + 
					"        </div>");
			tweetData.append("<div class=\"timeline-body\">\r\n" + 
					"          <p>" + status.getText() + "</p>\r\n" + 
							"        </div>\r\n" + 
							"      </div>\r\n" + 
							"    </li>");
			
		}
		tweetData.append("</ul></div>");		
		return tweetData.toString();
	}

}
