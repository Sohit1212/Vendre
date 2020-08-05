package vendre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import ECUtils.BaseDAO;
import vendre.bean.ComboValue;
import vendre.bean.OrderItems;

//id, c_type, c_value
public class ComboValueDAO extends BaseDAO{
	public static List<ComboValue> search(String type){
		LinkedList<ComboValue> res = new LinkedList<>();
		Connection con = null;
		try{
			con = getCon();
			String sql = "select * from combo_values where c_type = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, type);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				ComboValue p1 = new ComboValue();
				p1.setId(rs.getString("id"));
				p1.setType(rs.getString("c_type"));
				p1.setValue(rs.getString("c_value"));
				res.add(p1);
			}
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
		return res;
	}

}
