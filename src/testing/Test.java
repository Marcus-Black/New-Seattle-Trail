package testing;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		String type = "Weapon";
		int usesLeft = 15;
		String result = String.format(type + "%10 Uses left: " + usesLeft);
		System.out.println(result);
		assertEquals(result , "Weapon          Uses left: 15");
		
	}

}
