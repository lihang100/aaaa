package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import link.DataBase;
public class BaseDao {

	Connection con;
	PreparedStatement prs;
	ResultSet rs;
	public int update(String sql,Object...objects) {
		try {
			prs = DataBase.Userjdbc().prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				prs.setObject(i+1, objects[i]);
			}
			int flag = prs.executeUpdate();
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DataBase.close(con, prs);
		}
		return -1;
	}
}
