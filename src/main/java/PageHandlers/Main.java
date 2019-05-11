package PageHandlers;
import static spark.Spark.*;

import PageHandlers.FilteredFeed;
import PageHandlers.HiddenFeed;
import PageHandlers.WelcomePage;

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
    	FullFeedDisplay fullFeed = new FullFeedDisplay();
    	FilteredFeed filteredFeed = new FilteredFeed();
    	HiddenFeed hiddenFeed = new HiddenFeed();
    	
    	/**
    	 * Input: String
    	 * Output: string
    	 * Practice get request to the local page, first argument is the page to make the request to
    	 * Second argument is what is being placed on the page.
    	 */ 
        
    	get("/", welcomePage); //user interface
    	
    	get("/home", (req, res) -> {
    		res.redirect("/");
    		return "home";
    	});
    	

    	get("/filteredFeed", (req, res) -> {	
    		String keyword;
    		
    		if (!req.queryParams().isEmpty()) { 
	    		 keyword = req.queryParams("keyword");
	    		filteredFeed.setKeyword(req.queryParams("keyword"));
    		}
    		
    		keyword = filteredFeed.getKeyword();
    		System.out.println("key: " + keyword);
    		System.out.println(filteredFeed.getKeyword());
    		return "<div class = \"container\">" + filteredFeed.getHeader() + filteredFeed.getKeywordDisplay() + filteredFeed.getHomeButton() + 
    				"<div><br>"+filteredFeed.getHiddenFeedButton() + "</div>" + filteredFeed.getBootstrapJS() + filteredFeed.getRefreshButton() +
    				"</div>" + filteredFeed.getTweetInfo(keyword);
    	});
    	
    	get("/fullFeed", (req, res) -> {
    		String tweets = fullFeed.PullTweets();
    		return "<div class = \"container\">" + fullFeed.getHeader() + fullFeed.getHomeButton() + "<div><br>"+fullFeed.getRefreshButton() + "</div>" + fullFeed.getBootstrapJS() + "</div>" + tweets;
    	});
    	
    	get("/hiddenFeed", hiddenFeed); //the spoiler tweets that the user wanted hidden for a time
    }
}