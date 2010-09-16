package models;

import java.util.ArrayList;
import java.util.List;

public class Kalender {
	
	List<Termin> termine = new ArrayList<Termin>();
	private Teilnehmer teilnehmer;

	public void trageEin(Termin termin) {
		if(hat(termin)) throw new TerminDoppeltEingetragenException();
		termin.ladeEin(teilnehmer);
		termine.add(termin);
	}

	public boolean hat(Termin termin) {
		return termine.contains(termin);
	}

	public void setBesitzer(Teilnehmer teilnehmer) {
		this.teilnehmer = teilnehmer;
	}
}
