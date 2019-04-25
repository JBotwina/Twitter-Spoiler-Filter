import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;
import twitter4j.Status;

/**
 * 
 * @author mamaya
 *	calls back end method to retrieve full tweet feed
 *	formats data and returns html in string form
 */
public class TweetFeed implements Route{

	//@Override
	private String display = "<h1>Hello</h1><p>We are glad you are here.</p>";
	private String feed;
	
	/**
	 * returns html in string form for display
	 */
	public Object handle(Request request, Response response) throws Exception {
		getBadStatuses();
		System.out.println(feed);
		return feed;
	}
	
	/**
	 * retrieves list of tweets from back end
	 */
	public void getBadStatuses() {
		TwitterExample te = new TwitterExample();
		ArrayList<Status> badStatuses = te.getBadStatuses();
		this.feed = badStatuses.get(0).getUser().toString();
		
	}

}
