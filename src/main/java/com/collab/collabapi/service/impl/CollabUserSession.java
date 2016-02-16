package com.collab.collabapi.service.impl;

import javax.servlet.http.HttpSession;

public class CollabUserSession {

	public void setUserSession(Object obj, HttpSession session) {
		session.setAttribute("user", obj);
	}

}
