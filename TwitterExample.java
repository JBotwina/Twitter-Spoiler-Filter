import java.util.HashMap;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
//make hashmap to count the favorites for each screen name on our timeline
public class TwitterExample {
	
	public TwitterExample() {
	}
	
	public static void main(String[] args) {
		 try {
	            // gets Twitter instance with default credentials
	            Twitter twitter = new TwitterFactory().getInstance();
	            User user = twitter.verifyCredentials();
	            List<Status> statuses = twitter.getHomeTimeline();
	            //System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
	            HashMap<String, Integer> countFav = new HashMap<>();
	            for (Status status : statuses) {
	                //System.out.println("@" + status.getUser().getScreenName() + " - " + status.getFavoriteCount());
	            	
	            		System.out.println(status.getUser().getScreenName() + " "+ status.getFavoriteCount());
	            	
	            	if( countFav.containsKey(status.getUser().getScreenName()) ) {
	            		countFav.put(status.getUser().getScreenName(), countFav.get(status.getUser().getScreenName()) + status.getFavoriteCount() );
	            	}
	            	else {
	            		countFav.put(status.getUser().getScreenName(), status.getFavoriteCount());
	            	}
	            }
	            
	            System.out.println(countFav);
	            
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to get timeline: " + te.getMessage());
	            System.exit(-1);
	        }
	    }
	}


