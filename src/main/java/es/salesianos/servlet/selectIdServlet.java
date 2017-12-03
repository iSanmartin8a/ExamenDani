package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConnectionManager;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.User;

public class selectIdServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectionManager manager = new H2Connection();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = manager.selectByNombre("Daniel");
		req.setAttribute("selectByNombre", user);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mostrarUser.jsp");
		dispatcher.forward(req,resp);
	}//Este metodo nos redireccionara a la pagina welcome.jsp
	
	

}
