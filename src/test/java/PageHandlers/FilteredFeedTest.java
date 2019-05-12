package PageHandlers;

import junit.framework.TestCase;

public class FilteredFeedTest extends TestCase {
	public void testGetHeader() {
		FilteredFeed f = new FilteredFeed();
		assertNotNull(f.getHeader()); 
	}

	public void testGetRefreshButton() {
		FilteredFeed f = new FilteredFeed();
		assertNotNull(f.getRefreshButton()); 
	}

	public void testGetHiddenFeedButton() {
		FilteredFeed f = new FilteredFeed();
		assertNotNull(f.getHiddenFeedButton()); 
	}


}
