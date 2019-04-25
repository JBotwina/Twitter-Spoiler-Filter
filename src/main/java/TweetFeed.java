import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;
import twitter4j.Status;

public class TweetFeed implements Route{

	//@Override
	private String display = "<h1>Hello</h1><p>We are glad you are here.</p>";
	private String feed;
	
	
	public Object handle(Request request, Response response) throws Exception {
		getBadStatuses();
		System.out.println(feed);
		return feed;
	}
	
	public void getBadStatuses() {
		TwitterExample te = new TwitterExample();
		ArrayList<Status> badStatuses = te.getBadStatuses();
		this.feed = badStatuses.get(0).getUser().toString();
		
	}

}
