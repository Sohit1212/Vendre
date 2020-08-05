package vendre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import ECUtils.BaseDAO;
import vendre.bean.Kart;
//id, buyer_id, order_date, status
public class KartDAO extends BaseDAO{

	public static List<Kart> search(String buyerId){
		LinkedList<Kart> res = new LinkedList<>();
		Connection con = null;
		try{
			con = getCon();
			String sql = "select * from kart ";
			if(buyerId!=null){
				sql = sql + " where buyer_id = '" + buyerId + "' ; ";
			}
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Kart p1 = new Kart();
				p1.setId(rs.getString("id"));
				p1.setBuyerId(rs.getString("buyer_id"));
				p1.setOrderDate(rs.getDate("order_date"));
				p1.setStatus(rs.getString("status"));
				res.add(p1);
			}
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
		return res;
	}

	public static Kart searchById(String id){
		Kart res = null;
		Connection con = null;
		try{
			con = getCon();
			String sql = "select * from kart where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Kart p1 = new Kart();
				p1.setId(rs.getString("id"));
				p1.setBuyerId(rs.getString("buyer_id"));
				p1.setOrderDate(rs.getDate("order_date"));
				p1.setStatus(rs.getString("status"));				
				res = p1;
			}
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
		return res;
	}


	public static void insert(Kart p1){
		Connection con = null;
		try{
			con = getCon();
			String sql = "insert into kart(buyer_id, order_date, status) values (?, ?, ?) ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getBuyerId());
			st.setDate(i++, p1.getOrderDate());
			st.setString(i++, p1.getStatus());
			st.executeUpdate();
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
	}

	public static void update(Kart p1){
		Connection con = null;
		try{
			con = getCon();
//			String sql = "update kart set buyer_id=?, order_date=?, status=? where id = ? ";
			String sql = "update kart set status=? where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getStatus());
			st.setString(i++, p1.getId());
			st.executeUpdate();
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
	}


	public static void delete(String id){
		Connection con = null;
		try{
			con = getCon();
			String sql = "delete from kart where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, id);
			st.executeUpdate();
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
	}
}
