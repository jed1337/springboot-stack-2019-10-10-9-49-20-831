package com.tw.apistackbase;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApiStackBaseApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertEquals(1, 1);
	}

}
