package com.collab.collabapi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	private static EmailValidator instance = new EmailValidator();
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;

	public static EmailValidator getInstance() {
		return instance;
	}

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	/**
	 * Validate email with regular expression
	 * 
	 * @param email
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String email) {
		if (email == null) {
			return false;
		}
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}