import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;
public class Database {
	
	private Connection conn= null;
	private Statement st = null;
	private ResultSet rs = null;
	
	private String Sql = "";
	private String strconn = "jdbc:mysql://localhost:3306/";
	
	public void DB_Connection(String db_name) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			strconn+=db_name;
			conn=DriverManager.getConnection(strconn,"root", db_name);
			System.out.println("Connection Successful");
			
		} catch (Exception e) {
			System.out.println("Error 101: DB_Connector");
		}
	}// end of the class 

	public void displayRecords(String strQuery, JTable table) {
		try {
			st =conn.createStatement();
			rs = st.executeQuery(strQuery);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println("Error 102: displayRecords\n"+e.getMessage());
		}
		
	}
}

