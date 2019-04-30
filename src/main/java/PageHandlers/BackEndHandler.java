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
	
	public static ArrayList<Status> fullFeed() {
		te.getUnfilteredStatuses();
		return te.getUnfilteredStatuses();
	}
	
	public static ArrayList<Status> filteredFeed() {
		te.getGoodStatuses();
		return te.getGoodStatuses();
	}
	
	public String tweetToString(ArrayList<Status> tweets) {
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
