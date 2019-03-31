package atj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OraConnTest {

	Connection connection = null;

	public OraConnTest() {
		registerDriver();
	}

	private void registerDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sterownik Oracle JDBC zostal zarejestrowany.");
		} catch (ClassNotFoundException ex) {
			System.out.println("Brak sterownika JDBC.");
		}
	}

	public Connection getConnection(String host, String user, String password) {
		try {
			connection = DriverManager.getConnection(host, user, password);
		} catch (SQLException ex) {
			System.out.println("Blad polaczenia z baza. Sprawdz nazwy hosta, uzytkownika i haslo.");
		}
		return connection;
	}

	public void testConnection() {
		try {
			if (connection != null) {
				System.out.println("Polaczono.");
				connection.close();
				System.out.println("Rozlaczono.");
			} else
				System.out.println("Brak polaczenia z baza!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
