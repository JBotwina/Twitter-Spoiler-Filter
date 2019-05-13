package PageHandlers;

import org.junit.Test;

import junit.framework.TestCase;

public class FullFeedDisplayTest extends TestCase {
	
	@Test
	public void testGetHeader() {
		FullFeedDisplay f = new FullFeedDisplay();
		assertNotNull(f.getHeader()); 
	}

	@Test
	public void testGetHomeButton() {
		FullFeedDisplay f = new FullFeedDisplay();
		assertNotNull(f.getHomeButton()); 
	}

	@Test
	public void testGetBootstrapJS() {
		FullFeedDisplay f = new FullFeedDisplay();
		assertNotNull(f.getBootstrapJS()); 
	}
	
	@Test
	public void testGetRefreshButton() {
		FullFeedDisplay f = new FullFeedDisplay();
		assertNotNull(f.getRefreshButton()); 
	}
}
