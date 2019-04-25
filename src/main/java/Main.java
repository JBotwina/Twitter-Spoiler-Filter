
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
    	
    	/**
    	 * Input: String
    	 * Output: string
    	 * Practice get request to the local page, first argument is the page to make the request to
    	 * Second argument is what is being placed on the page.
    	 */
        get("/hello", (req, res) -> "Hello World said the dog to Carla");
    }
}