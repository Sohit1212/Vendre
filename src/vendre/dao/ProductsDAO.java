package vendre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import ECUtils.BaseDAO;
import vendre.bean.AppUser;
import vendre.bean.Products;

///INSERT INTO products (id, seller_id, name,  price, item_desc, category, status) VALUES (NULL, NULL,NULL, NULL, NULL, NULL, NULL);
//id, seller_id, name, price, item_desc, category, status
public class ProductsDAO extends BaseDAO{
	public static void insert(Products p1){
		Connection con = null;
		try{
			con = getCon();
			String sql = " INSERT INTO products (seller_id, name,  price, "
					+ " item_desc, category, status)  "
					+ " values (?, ?, ?, "
					+ "	?, ?, ? ) ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getSellerId());
			st.setString(i++, p1.getName());
			st.setDouble(i++, p1.getPrice());
			st.setString(i++, p1.getItemDesc());
			st.setString(i++, p1.getCategory());
			st.setString(i++, p1.getStatus());
			st.executeUpdate();			
			//SELECT LAST_INSERT_ID( )
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
	}	
	
	public static int getInsertedId(){
		int res = -1;
		Connection con = null;
		try{
			con = getCon();
			String sql = " SELECT max(id) as lid from products";
			PreparedStatement st = con.prepareStatement(sql);			
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				res = rs.getInt("lid");
			}
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
		return res;
	}	

	
	public static List<Products> search(String si, String cate, String sid){
		LinkedList<Products> res = new LinkedList<>();
		Connection con = null;
		try{
			con = getCon();
			String whr = "";
			if(si != null && !"".equalsIgnoreCase(si)){
				whr  += " and (name like '%"+si+"%' or item_desc like '%"+si+"%') ";
			}
			if(cate != null && !"".equalsIgnoreCase(cate)){
				whr  += " and category = '"+cate+"' ";
			}
			if(sid != null && !"".equalsIgnoreCase(sid)){
				whr  += " and seller_id = "+sid+" ";
			}
			String sql = "select * from products where id > 0 " + whr +" order by id desc ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Products p1 = new Products();
				p1.setId(rs.getString("id"));
				p1.setCategory(rs.getString("category"));
				p1.setItemDesc(rs.getString("item_desc"));
				p1.setName(rs.getString("name"));
				p1.setPrice(rs.getDouble("price"));
				p1.setSellerId(rs.getString("seller_id"));
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

	
	public static Products searchById(String id){
		Products res = null;
		Connection con = null;
		try{
			con = getCon();
			String whr = "";
			String sql = "select * from products where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Products p1 = new Products();
				p1.setId(rs.getString("id"));
				p1.setCategory(rs.getString("category"));
				p1.setItemDesc(rs.getString("item_desc"));
				p1.setName(rs.getString("name"));
				p1.setPrice(rs.getDouble("price"));
				p1.setSellerId(rs.getString("seller_id"));
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

	
	
	public static void delete(String id, String sid){
		Connection con = null;
		try{
			con = getCon();
			String sql = "delete from products where id = ? ";
			if(sid != null && !"".equalsIgnoreCase(sid)){
				sql = sql + " and seller_id = "+sid+" ";
			}
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

	
	public static void update(Products p1){
		Connection con = null;
		try{
			con = getCon();
			String sql = " update products set seller_id = ? , name = ?,  price = ?, "
					+ " item_desc = ?, category =?, status =?  "
					+ "	where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getSellerId());
			st.setString(i++, p1.getName());
			st.setDouble(i++, p1.getPrice());
			st.setString(i++, p1.getItemDesc());
			st.setString(i++, p1.getCategory());
			st.setString(i++, p1.getStatus());
			st.setString(i++, p1.getId());
			st.executeUpdate();			
			//SELECT LAST_INSERT_ID( )
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
	}	


}
