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
		return te.getBadStatuses();	
	}
	
	public static ArrayList<Status> fullFeed() {
		System.out.println(te);
		te.getUnfilteredStatuses();
		return te.getUnfilteredStatuses();
	}
	
	public static ArrayList<Status> filteredFeed() {
		return te.getGoodStatuses();
	}
}
