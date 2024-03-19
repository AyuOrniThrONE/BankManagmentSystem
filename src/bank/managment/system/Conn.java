package bank.managment.system;

import java.sql.*;

public class Conn {
	Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","Ayushpt$4");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
