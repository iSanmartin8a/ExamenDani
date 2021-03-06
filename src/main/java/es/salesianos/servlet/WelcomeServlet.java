package es.salesianos.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.UserAssembler;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.User;

public class WelcomeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserAssembler assembler = new UserAssembler();
	ConnectionManager manager = new H2Connection();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req,resp);
	}//Metodo que nos permite enviar datos al servlet
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}//Metodo que nos permite obtener datos del servlet
	
	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		User user = assembler.createUserFromRequest(req);	
		manager.insert(user);
		
		redirect(req,resp);
	}//Este metodo nos permite realizar la accion, en este caso la de ejecutar el metodo redirect() para redirigirnos a una pagina.
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(req,resp);
	}//Este metodo nos redireccionara a la pagina welcome.jsp
	

}
