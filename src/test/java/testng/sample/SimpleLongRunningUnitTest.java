package testng.sample;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class SimpleLongRunningUnitTest {

	private int number = 10;

	@Test
	public void givenNumber_whenEven_thenTrue() {
		assertEquals(number % 2 == 0, true);
	}

}
