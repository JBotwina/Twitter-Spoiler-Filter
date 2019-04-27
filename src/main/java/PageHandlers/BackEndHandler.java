package PageHandlers;

import java.util.ArrayList;

import backEnd.TwitterExample;
import twitter4j.Status;

public class BackEndHandler {
	private TwitterExample te;
	private ArrayList<Status> badStatuses;
	private ArrayList<Status> fullFeed;
	private ArrayList<Status> filteredFeed;
	
	
	public BackEndHandler() {
		this.te = new TwitterExample();
	}

	public static void getBadStatuses() {
		badStatuses = te.getBadStatuses();	
	}
	
	public static void fullFeed() {
		fullFeed = te.getUnfilteredStatuses();
	}
	
	public static void filteredFeed() {
		filteredFeed = te.getGoodStatuses();
	}
}
