package PageHandlers;

import java.util.ArrayList;

import backEnd.TwitterExample;
import twitter4j.Status;

public class BackEndHandler {
	private TwitterExample te;
	private static ArrayList<Status> badStatuses;
	private static ArrayList<Status> fullFeed;
	private static ArrayList<Status> filteredFeed;
	
	
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
