package link;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import encapsulation.News;
import link.configuration;

public class DataBase {
	 static Connection connection ;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ppst;
	
	public static Connection Userjdbc() {

		try {
			Class.forName(configuration.get("Drivet"));
			String url = configuration.get("name");
			connection = DriverManager.getConnection(url, configuration.get("ro"), configuration.get("passwor"));
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<News> selectAll() {
		connection = Userjdbc();

		String sql = "select * from news";

		try {

			ppst = connection.prepareStatement(sql);
			rs = ppst.executeQuery();
			List<News> list = new ArrayList<News>();
			while (rs.next()) {
				News s = new News();
				s.setNid(rs.getInt("nid"));
				s.setNtitle(rs.getString("ntitle"));
				s.setNconcent(rs.getString("ncontent"));
				list.add(s);
			}

			return list;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	
	public int deletee(int uid) {
		connection = Userjdbc();
		try {
			ppst = connection.prepareStatement("delete from news where nid=?");
			ppst.setInt(1, uid);
			//受影响的行数
			int i = ppst.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 关闭连接
	public static void close(Connection connection, PreparedStatement ppst, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ppst != null) {
				ppst.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection connection, PreparedStatement ppst) {
		try {
			if (ppst != null) {
				ppst.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
