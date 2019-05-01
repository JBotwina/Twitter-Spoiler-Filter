package PageHandlers;

import java.util.ArrayList;

import backEnd.TwitterExample;
import twitter4j.Status;

public class BackEndHandler {
	private static TwitterExample te;


	public BackEndHandler() {
		te = new TwitterExample();
	}

	public static ArrayList<Status> getBadStatuses() {
		te.getBadStatuses();
		return te.getBadStatuses();	
	}
	
	// Melissa (notation so that I don't forget which method I'm working on and don't change Jhon's code -- which I think I already did, but don't quite remember!!)
	public static String fullFeed() {
		String fullStatuses = tweetToString(te.getUnfilteredStatuses());
		return fullStatuses;
	}
	
	public static String filteredFeed() {
//		String statuses = jsonparser.parseJson(te.getGoodStatuses());
		String statuses = tweetToString(te.getGoodStatuses());
		return statuses;
	}
	
	public static String tweetToString(ArrayList<Status> tweets) {
		StringBuilder tweetData = new StringBuilder();
		tweetData.append("<div><ul>");
		for (Status status : tweets) {
			tweetData.append("<li>User: " + status.getUser().getName() + "</li>");
			tweetData.append("<li>Created At: " + status.getCreatedAt() + "</li>");
			tweetData.append("<li>Tweet: " + status.getText() + "<br/><br/></li>");
		}
		tweetData.append("</ul></div>");		
		return tweetData.toString();
	}
}
