package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Termin {

	List<Teilnehmer> teilnehmer = new ArrayList<Teilnehmer>();
	private Date startzeit;
	private Date endzeit;

	public void ladeEin(Teilnehmer teilnehmer) {
		this.teilnehmer.add(teilnehmer);
	}

	public boolean nimmtTeil(Teilnehmer teilnehmer) {
		return this.teilnehmer.contains(teilnehmer);
	}

	/**
	 * @param startzeit
	 *            Stunden und Minuten, wie z.B. 12:00.
	 */
	public void setStartzeit(String startzeit) {
		this.startzeit = ZeitUtil.parseZeit(startzeit);
	}

	/**
	 * @param endzeit
	 *            Stunden und Minuten, wie z.B. 12:00.
	 */
	public void setEndzeit(String endzeit) {
		Date zeit = ZeitUtil.parseZeit(endzeit);
		if (zeit.before(startzeit))
			throw new EndzeitVorStartzeitException(zeit, startzeit);
		this.endzeit = zeit;
	}

	public int getDauer() {
		return extrahiereStunde(endzeit) - extrahiereStunde(startzeit);
	}

	private int extrahiereStunde(Date zeit) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(zeit);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
}