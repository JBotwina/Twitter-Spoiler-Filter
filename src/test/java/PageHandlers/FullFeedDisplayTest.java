package PageHandlers;

import junit.framework.TestCase;

public class FullFeedDisplayTest extends TestCase {

	public void testGetHeader() {
		FullFeedDisplay f = new FullFeedDisplay();
		assertNotNull(f.getHeader()); 
	}

	public void testGetHomeButton() {
		FullFeedDisplay f = new FullFeedDisplay();
		assertNotNull(f.getHomeButton()); 
	}

	public void testGetBootstrapJS() {
		FullFeedDisplay f = new FullFeedDisplay();
		assertNotNull(f.getBootstrapJS()); 
	}
	
	public void testGetPullTweets() {
		FullFeedDisplay f = new FullFeedDisplay();
		assertNotNull(f.PullTweets()); 
	}

}
