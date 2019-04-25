
import static spark.Spark.*;

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
    	get("/hiddenTweets", hiddenTweets); //what I missed
    	get("/viewTweets", homePageHandler); //may not need
    	
    	get("/hello", (req, res) -> "Hello World said the dog to Carla");
    }
}