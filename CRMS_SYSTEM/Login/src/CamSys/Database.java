package CamSys;

import java.sql.*;

public class Database {
	
	    String path = "jdbc:mysql://localhost/java_project?useSSL=false";
		static Connection con;
		Statement st;

		public void setPath(String p)
		{
			path = p;
		}
		

		public void closeCon() throws SQLException
		{
			con.close();
		}
		
		public int Save_Del_Update(String query) throws SQLException
		{
			con = DriverManager.getConnection(path,"root","");
			st = con.createStatement();

			int rows = st.executeUpdate(query);
			closeCon();
			return rows;
		}
		
		public ResultSet GetData(String query) throws SQLException
		{
			con = DriverManager.getConnection(path,"root","");
			st = con.createStatement();

			ResultSet rs = st.executeQuery(query);
			return rs;
		}
}



