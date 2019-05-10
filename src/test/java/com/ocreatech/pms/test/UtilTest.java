package com.ocreatech.pms.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import com.ocreatech.pms.utils.TokenTool;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UtilTest {

	@Test
	public void creatToken() {
		String token = TokenTool.creatToken();
		assertTrue(StringUtils.hasText(token));
	}

}
