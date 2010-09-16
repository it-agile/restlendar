package models;

import static org.junit.Assert.*;

import models.EndzeitVorStartzeitException;
import models.Teilnehmer;
import models.Termin;

import org.junit.Test;

public class TerminTest {

	Termin termin = new Termin();

	@Test
	public void laedtBenutzerEin() throws Exception {
		Teilnehmer teilnehmer = new Teilnehmer();
		termin.ladeEin(teilnehmer);
		assertTrue(termin.nimmtTeil(teilnehmer));
	}

	@Test
	public void akzeptiertKeineEndzeitKleinerStartzeit() throws Exception {
		termin.setStartzeit("12:00");
		try {
			termin.setEndzeit("11:00");
			fail();
		} catch (EndzeitVorStartzeitException exception) {
			assertEquals(
					"Die Endzeit (11:00) darf nicht kleiner als die Startzeit (12:00) sein.",
					exception.getMessage());
		}
	}
	
	@Test
	public void rechnetDauerAus() throws Exception {
		termin.setStartzeit("11:00");
		termin.setEndzeit("12:00");
		assertEquals(1, termin.getDauer());
	}
}
