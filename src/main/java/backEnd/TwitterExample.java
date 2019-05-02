package backEnd;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class TwitterExample {
	// gets Twitter instance with default credentials
    private Twitter twitter;
    private User user;
    //unfiltered statuses
    private ArrayList<Status> unfilteredStatuses;
    // statuses we do not want to push to web app.
    private ArrayList<Status> spoilerTweets;
    //statuses we want to push to web app
    private ArrayList<Status> goodStatuses;
    //time that we want to start running the program
    private LocalTime startTime;
    //time we want to stop the program
    private LocalTime endTime;
    //the time that we need to wait to run the program
    long differenceInMili;
    
	public ArrayList<Status> getUnfilteredStatuses() {
		return unfilteredStatuses;
	}

	public ArrayList<Status> getSpoilerTweets() {
		System.out.println("getting the bad stuff" + spoilerTweets.toString());
		return spoilerTweets;
	}
	//
	public ArrayList<Status> getGoodStatuses() {
		//TODO
		/*
		 * need String keyword
		 * from within here call retrieve statuses and pass in keyword
		 */
		System.out.println("getting the goods" + goodStatuses.toString());
		return goodStatuses;
	}

	public TwitterExample() {
		twitter = new TwitterFactory().getInstance();
		try {
			user = twitter.verifyCredentials();
		} catch (TwitterException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		unfilteredStatuses = new ArrayList<Status>();
		spoilerTweets = new ArrayList<Status>();
		goodStatuses = new ArrayList<Status>();
		retrieveStatuses();
		
    }
	public void setTimes() {
		/*StartTime:
	     * LocalTime.now().plusSeconds(30) is solely used for testing purposes so that the coder only waits 30
	     * seconds for the program to start.
	     * Ideally this variable will take in user input from the app.
	     * If the user inputs a String we can do:
	     * 		LocalTime startTime = LocalTime.parse(userInputStartTime); --> parses string to LocalTime
	     */
	     startTime = LocalTime.now().plusSeconds(30);
	    /*EndTime:
	     * Similar to startTime, this is just for testing purposes and would ideally look like:
	     * 		LocalTime startTime = LocalTime.parse(userInputEndTime);
	     */
	     endTime = startTime.plusMinutes(2);
	    /*differenceInMili:
	     * records the difference between when the program begins to run and the time we want the Twitter searching
	     * to start. Must be in milliseconds for Thread.sleep().
	     */
	     differenceInMili = Duration.between(LocalTime.now(), startTime).getSeconds()*1000;
	}
	
	public void parseTweets(String keyword) {
		for(Status status : unfilteredStatuses) {
			String[] tweetedWords = status.getText().split(" ");
			for(int x=0; x<tweetedWords.length; x++) {
        		//in practice these keywords would be inputted by the user.
        		//keyword param
				
				System.out.println(keyword.toLowerCase().contains(tweetedWords[x].toLowerCase()) + " " + "Tweet: " + tweetedWords[x].toLowerCase() );
        		if(tweetedWords[x].toLowerCase().contains(keyword.toLowerCase())){
        			//we do not want to save duplicate statuses
        			if(!spoilerTweets.contains(status)) {
        				//add the status
        				spoilerTweets.add(status);
        			}
        			//if a status contains the keyword, we don't have to check the rest.
        			break;
        		}
        		//if we were able to look through the whole status without finding a keyword, add to good statuses
        		if(x == tweetedWords.length-1) {
        			//don't add duplicates
        			if(!goodStatuses.contains(status)) {
        				goodStatuses.add(status);
        			}	
        		}
        	}
		}
	}
	
	
	public void retrieveStatuses() {
		try {
            /*
             * Pause the thread until a sufficient time has passed.
             */
            //try {
			//	Thread.sleep(differenceInMili);
			//} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			//}
            /*Searching Twitter:
             * Using the dateTime .isBefore() method we check that as long as the current time is before the endTime,
             * we continue to collect data.
             */
           // while(LocalTime.now().isBefore(endTime)) {
            	/* Get the 20 most recent statuses from the authenticated user's timeline.
            	 * The status class save a plethora of information about the status and the poster of the status such
            	 * as: location, text, tweetID, userID, and userScreenName. 
            	 */
            	List<Status> statuses = twitter.getHomeTimeline();
            	/*For Loop:
            	 * Loop through each status in the homeTimeline statuses.
            	 * Check if each tweet has a keyword 
            	 */
	            for (Status status : statuses) {
	            	//grab the statuses before they are filtered.
	            	if(!unfilteredStatuses.contains(status)) {
	            		unfilteredStatuses.add(status);
	            	}
	            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
	}
	/*
     * Print out the screenname and text of the bad tweets
     */
	public void printBadStatuses() {
		
        for(Status status : spoilerTweets) {
        	System.out.println(status.getUser().getScreenName()+ "****" + status.getText());
        }
        System.out.println("End of bad Statuses******************************");
	}
	
	public void printGoodStatuses() {
		
        for(Status status : goodStatuses) {
        	System.out.println(status.getUser().getScreenName()+ "****" + status.getText());
        }
        System.out.println("End of good Statuses******************************");
	}
	
	//public static void main(String[] args) {
	//	TwitterExample te = new TwitterExample();
//		te.setTimes();
//		te.retrieveStatuses();
//		te.printBadStatuses();
	//	te.printGoodStatuses();
	//}
}
	



