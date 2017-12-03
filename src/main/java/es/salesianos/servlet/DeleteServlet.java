package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConnectionManager;
import es.salesianos.connection.H2Connection;

public class DeleteServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	ConnectionManager manager = new H2Connection();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		loginRedirect(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("nombre", req.getParameter("nombre"));
		confirmationRedirect(req, resp);
	}


	protected void confirmationRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirmation.jsp");
		dispatcher.forward(req, resp);
	}

	protected void loginRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(req, resp);
	}
}
