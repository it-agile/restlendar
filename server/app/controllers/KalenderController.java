package controllers;

import java.util.List;

import models.Kalender;
import models.Termin;
import play.mvc.Controller;

public class KalenderController extends Controller {

    private static Kalender kalender = new Kalender();
    
    public static void alleTermine() {
        List<Termin> termine = kalender.termine();
        render(termine);
    }
    
    public static void fuegeTerminHinzu() {
        kalender.trageEin(new Termin());
    }
    
    public static void entleeren() {
    	kalender = new Kalender();
    }
}
