package org.ws.logincontrol.model;

import javax.ejb.Local;

@Local
public interface UserFacadeBeanLocal {
	User getUser(String email);
}
