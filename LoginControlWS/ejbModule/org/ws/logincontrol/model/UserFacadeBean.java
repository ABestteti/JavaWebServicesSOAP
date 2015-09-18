package org.ws.logincontrol.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UserFacedeBean
 */
@Stateless
@LocalBean
public class UserFacadeBean implements UserFacadeBeanLocal {

    public UserFacadeBean() {
    }
    
    @PersistenceContext
    private EntityManager em;
    
    public User getUser(String email) {
    	User user = em.find(User.class, email);
    	
    	if (!user.getEmail().isEmpty()) {
    		return user;
    	}
    	
    	return null;
    }

}
