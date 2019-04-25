import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwitterExampleTest {

	@Test
	void testGetGoodStatuses() {
		TwitterExample te = new TwitterExample();
		te.setTimes();
		te.retrieveStatuses();
		assertTrue(te.getGoodStatuses().size()>0);
	}

}
