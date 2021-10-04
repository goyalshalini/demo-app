package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
class PrimeNumberServiceTests {

	private PrimeNumberServiceImpl service = new PrimeNumberServiceImpl();
	
	@Test
	void numberCalcEquals() {
		Assert.assertEquals(3, service.numberCalc(5).size());
		Assert.assertEquals(4, service.numberCalc(7).size());
		Assert.assertEquals(0, service.numberCalc(1).size());
	}
	

}
