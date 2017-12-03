package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.User;

public class UserAssembler {
	
	public static User createUserFromRequest(HttpServletRequest req) {
		User user = new User();
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		user.setNombre(nombre);
		user.setApellido(apellido);
		return user;
	}

}
