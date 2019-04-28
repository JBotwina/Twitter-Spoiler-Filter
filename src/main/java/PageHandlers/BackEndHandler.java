package PageHandlers;

import java.util.ArrayList;

import backEnd.TwitterExample;
import twitter4j.Status;

public class BackEndHandler {
	private TwitterExample te;

	
	public BackEndHandler() {
		this.te = new TwitterExample();
	}

	public static ArrayList<Status> getBadStatuses() {
		return te.getBadStatuses();	
	}
	
	public static ArrayList<Status> fullFeed() {
		return te.getUnfilteredStatuses();
	}
	
	public static ArrayList<Status> filteredFeed() {
		return te.getGoodStatuses();
	}
}
