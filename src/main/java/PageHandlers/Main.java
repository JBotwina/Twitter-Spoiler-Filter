package PageHandlers;
import static spark.Spark.*;


import PageHandlers.FilteredFeed;
import PageHandlers.HiddenFeed;
import PageHandlers.HomePageHandler;
import PageHandlers.WelcomePage;
import spark.Request;

/**
 * This is the main runner for the program. It will consolidate the back-end methods and push 
 * it to the front end web app.
 * @authors Jhon Valencia, Melissa Amaya, James Botwina
 *
 */

/**
 * Launches the app.
 * Handles all routes for app
 * @author mamaya
 *
 */
public class Main {
    public static void main(String[] args) {
    	port(8080);
    	
    	BackEndHandler backEndHandler = new BackEndHandler();
    	WelcomePage welcomePage = new WelcomePage();
    	FullFeedDisplay fullFeed = new FullFeedDisplay();
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
    	
    	get("/filteredFeed", (req, res) -> {	
    		String keyword = req.queryParams("keyword");
    		String keywordDisplay = "<div><span style=\"font-weight:600;\">We are filtering for the following word(s): </span>" + keyword  + "</div><br/>" ;
    		return filteredFeed.getHeader() + keywordDisplay  + filteredFeed.getBootstrapJS() + filteredFeed.getHomeButton() + filteredFeed.getHiddenFeedButton() + filteredFeed.getTweetInfo(keyword);
    	});
    	
    	get("/fullFeed", fullFeed); //unfiltered
    	get("/hiddenFeed", hiddenFeed); //what I missed
//    	get("/viewTweets", homePageHandler); //may not need
    }
}