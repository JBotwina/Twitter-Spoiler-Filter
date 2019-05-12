package PageHandlers;

import java.util.ArrayList;
import backEnd.TwitterExample;
import twitter4j.Status;

/**
 * This class handles the communication between the TweetGenerator class (retrieval of the tweets) and the page handler classes.
 * It has getters to retrieve array lists of spoiler tweets, non-spoiler tweets, and a full-feed list, and also applies HTML code
 * to the tweets received for display purposes. 
 * @authors Jhon Valencia, Melissa Amaya, James Botwina
 *
 */

public class BackEndHandler {
	private static TwitterExample te;
	private static String wordsToFilter;

	public static String getWordsToFilter() {
		return wordsToFilter;
	}

	// calls TwitterGenerator class and returns an array list of spoiler tweets
	public static ArrayList<Status> getBadStatuses() {
		return te.getSpoilerTweets();	
	}
	
	// calls TwitterGenerator class and returns an array list of all tweets (full-feed)
	public static String fullFeed() {
		te = new TwitterExample();
		String fullStatuses = tweetToString(te.getUnfilteredStatuses());
		return fullStatuses;
	}
	
	// gets spoiler-free tweets
	public static ArrayList<Status> filteredFeed(String keyword) {
		wordsToFilter = keyword;
		te.parseTweets(keyword);
		return te.getGoodStatuses();
	}
	
	/**
	 * This method takes in an array list of statuses (AKA tweets) and parses them into a StringBuilder object. 
	 * The StringBuilder object then appends HTML code to each tweet text for display purposes on the website.
	 * @param tweets
	 * @return tweetData.toString()
	 */
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
