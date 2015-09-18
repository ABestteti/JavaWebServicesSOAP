package org.ws.logincontrol.webservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.ws.logincontrol.model.User;
import org.ws.logincontrol.model.UserFacadeBeanLocal;

@WebService()
@Stateless()
public class UserWs {
	@EJB
	private UserFacadeBeanLocal userFacadeBeanLocal;
	@WebMethod(operationName = "findUser")
	public String findUser(@WebParam(name = "email") String email,
			               @WebParam(name = "senha") String senha) {
		
		User user = userFacadeBeanLocal.getUser(email);
		if (user != null) {
			if (senha.equals(user.getSenha())) {
				return user.getNome();
			}
		}
		return null;
	}
}
