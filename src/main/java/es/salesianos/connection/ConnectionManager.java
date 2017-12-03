package es.salesianos.connection;

import java.sql.Connection;
import java.util.List;

import es.salesianos.model.User;

public interface ConnectionManager {
	
	public Connection open(String jdbcUrl);
	
	
	public void close(Connection conn);


	void insert(User userFormulario);


	public List<User> searchAll();

}
