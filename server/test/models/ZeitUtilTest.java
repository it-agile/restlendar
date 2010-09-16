package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import models.ZeitUtil;

import org.junit.Test;

public class ZeitUtilTest {

	Calendar kalender = Calendar.getInstance();
	
	@Test
	public void formatiertDateNachString() throws Exception {
		kalender.set(Calendar.HOUR_OF_DAY, 23);
		kalender.set(Calendar.MINUTE, 59);
		Date zeit = kalender.getTime();
		assertEquals("23:59", ZeitUtil.formatiereZeit(zeit));
	}
	
	@Test
	public void parstStringNachDate() throws Exception {
		Date zeit = ZeitUtil.parseZeit("23:59");
		kalender.setTime(zeit);
		assertEquals(23, kalender.get(Calendar.HOUR_OF_DAY));
		assertEquals(59, kalender.get(Calendar.MINUTE));
	}
	
	@Test
	public void wandeltParseExceptionNachRuntimeExceptionUm() throws Exception {
		try {
			ZeitUtil.parseZeit("unparsbar");
			fail();
		} catch (RuntimeException exception) {
			assertTrue(exception.getCause() instanceof ParseException);
		}
	}
}
