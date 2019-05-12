package backEnd;
/*
 * This class communicates with the Twitter API to receive tweet information from our team's personal Twitter developer account.
 *  The access tokens are located in the twitter4j.properties file
 */

import java.util.ArrayList;


import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class TwitterGenerator {
	// gets Twitter instance with default credentials
    private Twitter twitter;
    //verifies the twitter account
    @SuppressWarnings("unused")
	private User user;
    private ArrayList<Status> unfilteredStatuses;
    // statuses we do not want to push to web app.
    private ArrayList<Status> spoilerTweets;
    //statuses we want to push to web app
    private ArrayList<Status> goodStatuses;
    
	public ArrayList<Status> getUnfilteredStatuses() {
		return unfilteredStatuses;
	}

	public ArrayList<Status> getSpoilerTweets() {
		return spoilerTweets;
	}

	public ArrayList<Status> getGoodStatuses() {
		return goodStatuses;
	}

	public TwitterGenerator() {
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
		
		//Whenever we create a TwitterGenerator object, we will want to have the statuses current timeline's statuses available.
		try {
        	List<Status> statuses = twitter.getHomeTimeline();
            for (Status status : statuses) {
            		unfilteredStatuses.add(status);        	
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
		
    }
	/*
	 * Accept keyword(s) that the user wants to mute and divide the statuses into variables: ones that contain the word(s) 
	 * and ones that do not contain the words.
	 */ 
	public void parseTweets(String keyword) {
		//character we wish to use to partition the tweet text.
		String delimiters = "[-\\t,;.?!:#$%@\\[\\](){}_*/]";
		String[] keywords = keyword.split(" ");
		
		for(Status status : unfilteredStatuses) {
			String[] tweetedWords = status.getText().split(delimiters);
			for(int x=0; x<tweetedWords.length; x++) {
        		if(checkIfKeywordsMatchTweetedWord(tweetedWords[x], keywords)){
        				spoilerTweets.add(status);
        			//if a status contains the keyword, we don't have to check the rest.
        			break;
        		}
        		//if we were able to look through the whole status without finding a keyword, add to good statuses
        		if(x == tweetedWords.length-1) {
        			goodStatuses.add(status);
        		}	
        	}
		}		
	}
	
	/*
	 * Compare a tweeted word with each keyword.
	 */
	public boolean checkIfKeywordsMatchTweetedWord(String tweetedWord, String[] keywords) {
		for(String keyword: keywords) {
			if(tweetedWord.toLowerCase().contains(keyword.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}