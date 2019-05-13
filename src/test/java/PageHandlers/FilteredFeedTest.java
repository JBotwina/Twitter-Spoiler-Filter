package PageHandlers;

import org.junit.Test;

import junit.framework.TestCase;

public class FilteredFeedTest extends TestCase {
	@Test
	public void testGetHeader() {
		FilteredFeed f = new FilteredFeed();
		assertNotNull(f.getHeader()); 
	}

	@Test
	public void testGetRefreshButton() {
		FilteredFeed f = new FilteredFeed();
		assertNotNull(f.getRefreshButton()); 
	}

	@Test
	public void testGetHiddenFeedButton() {
		FilteredFeed f = new FilteredFeed();
		assertNotNull(f.getHiddenFeedButton()); 
	}


}
