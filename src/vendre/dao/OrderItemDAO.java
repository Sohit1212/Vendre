package vendre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import ECUtils.BaseDAO;
import vendre.bean.OrderItems;

public class OrderItemDAO extends BaseDAO{
//id , kart_id , product_id , status

	public static List<OrderItems> search(String kartId){
		LinkedList<OrderItems> res = new LinkedList<>();
		Connection con = null;
		try{
			con = getCon();
			String sql = "select * from order_items ";
			if(kartId!=null){
				sql = sql + " where kart_id = '" + kartId + "' ; ";
			}
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				OrderItems p1 = new OrderItems();
				p1.setId(rs.getString("id"));
				p1.setKartId(rs.getString("kart_id"));
				p1.setProductId(rs.getString("product_id"));
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

	public static OrderItems searchById(String id){
		OrderItems res = null;
		Connection con = null;
		try{
			con = getCon();
			String sql = "select * from order_items where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				OrderItems p1 = new OrderItems();
				p1.setId(rs.getString("id"));
				p1.setKartId(rs.getString("kart_id"));
				p1.setProductId(rs.getString("product_id"));
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


	public static void insert(OrderItems p1){
		Connection con = null;
		try{
			con = getCon();
			String sql = "insert into order_items(kart_id , product_id , status) values (?, ?, ?) ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getKartId());
			st.setString(i++, p1.getProductId());
			st.setString(i++, p1.getStatus());
			st.executeUpdate();
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
	}

	public static void update(OrderItems p1){
		Connection con = null;
		try{
			con = getCon();
//			String sql = "update kart set buyer_id=?, order_date=?, status=? where id = ? ";
			String sql = "update order_items set status=? where id = ? ";
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
			String sql = "delete from order_items where id = ? ";
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
