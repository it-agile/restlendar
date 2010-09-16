package models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KalenderTest {

	private Kalender kalender = new Kalender();
	private Termin termin = new Termin();

	@Test
	public void traegtTerminEin() {
		kalender.trageEin(termin);
		assertTrue(kalender.hat(termin));
	}

	@Test
	public void traegtBesitzerInTerminEin() throws Exception {
		Teilnehmer teilnehmer = new Teilnehmer();
		kalender.setBesitzer(teilnehmer);
		kalender.trageEin(termin);
		assertTrue(termin.nimmtTeil(teilnehmer));
	}
	
	@Test(expected=TerminDoppeltEingetragenException.class)
	public void schmeisstExceptionWennTerminDoppeltEingetragenWird() throws Exception {
		kalender.trageEin(termin);
		kalender.trageEin(termin);
	}
}
