package com.ocreatech.pms.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BasicDateUtil {

	private BasicDateUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static String formatCurrDate() {
		return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
	}
}
