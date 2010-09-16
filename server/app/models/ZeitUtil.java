package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZeitUtil {

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("kk:mm");

	public static Date parseZeit(String zeit) {
		try {
			return ZeitUtil.FORMAT.parse(zeit);
		} catch (ParseException exception) {
			throw new RuntimeException(exception);
		}
	}

	public static String formatiereZeit(Date zeit) {
		return ZeitUtil.FORMAT.format(zeit);
	}
}
