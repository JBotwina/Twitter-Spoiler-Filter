package PageHandlers;

import java.util.ArrayList;

import twitter4j.Status;

public class BackEndHandler {

	public void getBadStatuses() {
		default.TwitterExample te = new TwitterExample();
		ArrayList<Status> badStatuses = te.getBadStatuses();	
	}
}
