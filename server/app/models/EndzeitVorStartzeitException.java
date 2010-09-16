package models;

import java.util.Date;

public class EndzeitVorStartzeitException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EndzeitVorStartzeitException(Date endzeit, Date startzeit) {
		super("Die Endzeit (" + ZeitUtil.formatiereZeit(endzeit)
				+ ") darf nicht kleiner als die Startzeit ("
				+ ZeitUtil.formatiereZeit(startzeit) + ") sein.");
	}

}
