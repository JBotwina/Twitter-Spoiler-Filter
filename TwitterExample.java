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
	
	public TwitterExample() {
	}
	
	public static void main(String[] args) {
		 try {
	            // gets Twitter instance with default credentials
	            Twitter twitter = new TwitterFactory().getInstance();
	            User user = twitter.verifyCredentials();
	            // statuses we do not want to push to web app.
	            ArrayList<Status> badStatuses = new ArrayList<Status>();
	            //statuses we want to push to web app
	            ArrayList<Status> goodStatuses = new ArrayList<Status>();
	            
	            /*StartTime:
	             * LocalTime.now().plusSeconds(30) is solely used for testing purposes so that the coder only waits 30
	             * seconds for the program to start.
	             * Ideally this variable will take in user input from the app.
	             * If the user inputs a String we can do:
	             * 		LocalTime startTime = LocalTime.parse(userInputStartTime); --> parses string to LocalTime
	             */
	            LocalTime startTime = LocalTime.now().plusSeconds(30);
	            /*EndTime:
	             * Similar to startTime, this is just for testing purposes and would ideally look like:
	             * 		LocalTime startTime = LocalTime.parse(userInputEndTime);
	             */
	            LocalTime endTime = startTime.plusMinutes(2);
	            /*differenceInMili:
	             * records the difference between when the program begins to run and the time we want the Twitter searching
	             * to start. Must be in milliseconds for Thread.sleep().
	             */
	            long differenceInMili = Duration.between(LocalTime.now(), startTime).getSeconds()*1000;
	            
	            /*
	             * Pause the thread until a sufficient time has passed.
	             */
	            try {
					Thread.sleep(differenceInMili);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            /*Searching Twitter:
	             * Using the dateTime .isBefore() method we check that as long as the current time is before the endTime,
	             * we continue to collect data.
	             */
	            while(LocalTime.now().isBefore(endTime)) {
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
		            	String[] tweetedWords = status.getText().split(" ");
		            	for(int x=0; x<tweetedWords.length; x++) {
		            		//in practice these keywords would be inputted by the user.
		            		if( (tweetedWords[x].equals("Melwood")) || (tweetedWords[x].equals("Reds")) ) {
		            			//we do not want to save duplicate statuses
		            			if(!badStatuses.contains(status)) {
		            				//add the status
		            				badStatuses.add(status);
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
		            try {
		            	/*TODO:
		            	 * At this stage we need to write a function that pushes the current batch of "good statuses" to
		            	 * the app for display.
		            	 * Some things to thing about moving forward:
		            	 * 		1) It would be efficient to only push the new statuses to the the web app each time we update
		            	 * 		2) The below Thread.sleep() would realistically be more than 30 seconds. 
		            	 */
		            	
		            	/*We must sleep the calls to the api slightly in order to not exceed out limit of 180 calls per 15 mins.
		            	 * This should not be a problem as the user will have plenty of tweets to read.
		            	 */
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	            /*
	             * Print out the screenname and text of the bad tweets
	             */
	            for(Status status : badStatuses) {
	            	System.out.println(status.getUser().getScreenName()+ "****" + status.getText());
	            }
	            
	            System.out.println("Good screen names of statuses************************************************");
	            
	            /*
	             * Print out the screenname and text of good tweets
	             */
	            for(Status status : goodStatuses) {
	            	System.out.println(status.getUser().getScreenName()+ "****" + status.getText());
	            }
	            
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to get timeline: " + te.getMessage());
	            System.exit(-1);
	        }
	    }
	}



