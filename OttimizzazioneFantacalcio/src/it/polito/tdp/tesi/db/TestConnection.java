package it.polito.tdp.tesi.db;
import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		
		try {
			Connection connection = DBConnect.getConnection();
			connection.close();
			System.out.println("Test PASSED");

		} catch (Exception e) {
			System.err.println("Test FAILED");
		}
	}

}
