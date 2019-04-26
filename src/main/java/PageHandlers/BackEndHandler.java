package PageHandlers;

import java.util.ArrayList;

import backEnd.TwitterExample;
import twitter4j.Status;

public class BackEndHandler {

	public void getBadStatuses() {
		
		TwitterExample te = new TwitterExample();
		ArrayList<Status> badStatuses = te.getBadStatuses();	
	}
}
