package PageHandlers;
import static spark.Spark.*;

import PageHandlers.FilteredFeed;
import PageHandlers.HiddenFeed;
import PageHandlers.HomePageHandler;
import PageHandlers.WelcomePage;
import backEnd.TweetFeed;


/**
 * This is the main runner for the program. It will consolidate the back-end methods and push 
 * it to the front end web app.
 * @authors Jhon Valencia, Melissa Amaya, James Botwina
 *
 */

public class Main {
    public static void main(String[] args) {
    	port(8080);
    	
    	WelcomePage welcomePage = new WelcomePage();
    	TweetFeed tweetFeed = new TweetFeed();
    	FilteredFeed filteredFeed = new FilteredFeed();
    	HiddenFeed hiddenFeed = new HiddenFeed();
    	HomePageHandler homePageHandler = new HomePageHandler();
    	/**
    	 * Input: String
    	 * Output: string
    	 * Practice get request to the local page, first argument is the page to make the request to
    	 * Second argument is what is being placed on the page.
    	 */
        
    	get("/", welcomePage); //user interface
    	get("/tweetFeed", tweetFeed); //unfiltered
    	get("/filteredFeed", filteredFeed); // protected
    	get("/hiddenFeed", hiddenFeed); //what I missed
    	get("/viewTweets", homePageHandler); //may not need
    	
    	get("/hello", (req, res) -> "Hello World said the dog to Carla");
    }
}