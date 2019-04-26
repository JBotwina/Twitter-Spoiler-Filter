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

	public void getBadStatuses() {
		badStatuses = te.getBadStatuses();	
	}
	
	public void fullFeed() {
		fullFeed = te.getUnfilteredStatuses();
	}
	
	public void filteredFeed() {
		filteredFeed = te.getGoodStatuses();
	}
}
