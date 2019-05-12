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

	public void testGetTweets() {
		FullFeedDisplay f = new FullFeedDisplay();
	assertNotNull(f.getTweets()); 
	}

}
