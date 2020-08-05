package vendre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import ECUtils.BaseDAO;
import vendre.bean.AppUser;
import vendre.bean.ComboValue;
import vendre.bean.Kart;
import vendre.bean.OrderItems;
//id, email , pass, user_name, phone_no , address , s_que, s_ans, role,status	

public class AppUserDAO extends BaseDAO{
	public static AppUser validate(String email, String pass){
		AppUser res = null;
		Connection con = null;
		try{
			con = getCon();
			String sql = "select * from app_users where email = ? and pass = ? and status = 'approved' ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, email);
			st.setString(i++, pass);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				AppUser p1 = new AppUser();
				p1.setId(rs.getString("id"));
				p1.setAddress(rs.getString("address"));
				p1.setEmail(rs.getString("email"));
				p1.setPass(rs.getString("pass"));
				p1.setUserName(rs.getString("user_name"));
				p1.setPhoneNo(rs.getString("phone_no"));
				p1.setSque(rs.getString("s_que"));
				p1.setSans(rs.getString("s_ans"));
				p1.setRole(rs.getString("role"));
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
	
	public static void insert(AppUser p1){
		Connection con = null;
		try{
			con = getCon();
			String sql = "insert into app_users(email , pass, user_name, "
					+ " phone_no , address , s_que, s_ans, role,status) "
					+ " values (?, ?, ?, "
					+ "	?, ?, ?, ?, ?, ? ) ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getEmail());
			st.setString(i++, p1.getPass());
			st.setString(i++, p1.getUserName());
			st.setString(i++, p1.getPhoneNo());
			st.setString(i++, p1.getAddress());
			st.setString(i++, p1.getSque());
			st.setString(i++, p1.getSans());
			st.setString(i++, p1.getRole());
			st.setString(i++, p1.getStatus());
			st.executeUpdate();
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
	}
	
	
	public static List<AppUser> search(){
		LinkedList<AppUser> res = new LinkedList<>();
		Connection con = null;
		try{
			con = getCon();
			String sql = "select * from app_users where role = 'seller' order by status desc ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				AppUser p1 = new AppUser();
				p1.setId(rs.getString("id"));
				p1.setAddress(rs.getString("address"));
				p1.setEmail(rs.getString("email"));
				p1.setPass(rs.getString("pass"));
				p1.setUserName(rs.getString("user_name"));
				p1.setPhoneNo(rs.getString("phone_no"));
				p1.setSque(rs.getString("s_que"));
				p1.setSans(rs.getString("s_ans"));
				p1.setRole(rs.getString("role"));
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


	public static AppUser searchById(String id){
		AppUser res = null;
		Connection con = null;
		try{
			con = getCon();
			String sql = "select * from app_users where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				AppUser p1 = new AppUser();
				p1.setId(rs.getString("id"));
				p1.setAddress(rs.getString("address"));
				p1.setEmail(rs.getString("email"));
				p1.setPass(rs.getString("pass"));
				p1.setUserName(rs.getString("user_name"));
				p1.setPhoneNo(rs.getString("phone_no"));
				p1.setSque(rs.getString("s_que"));
				p1.setSans(rs.getString("s_ans"));
				p1.setRole(rs.getString("role"));
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


	public static void update(AppUser p1){
		Connection con = null;
		try{
			con = getCon();
//			String sql = "update kart set buyer_id=?, order_date=?, status=? where id = ? ";
			String sql = "update app_users set email =? , pass = ?, user_name = ?, phone_no =? , "
					+ " address = ?, s_que =? , s_ans =? , role =? ,status = ? where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getEmail());
			st.setString(i++, p1.getPass());
			st.setString(i++, p1.getUserName());
			st.setString(i++, p1.getPhoneNo());
			st.setString(i++, p1.getAddress());
			st.setString(i++, p1.getSque());
			st.setString(i++, p1.getSans());
			st.setString(i++, p1.getRole());
			st.setString(i++, p1.getStatus());			
			st.setString(i++, p1.getId());
			st.executeUpdate();
		} catch(Exception e){
		   e.printStackTrace();
		} finally{
			closeCon(con);
		}
	}

	

}
