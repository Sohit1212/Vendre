package vendre;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vendre.bean.AppUser;
import vendre.dao.AppUserDAO;

/**
 * Servlet implementation class RegSer
 */
@WebServlet("/RegSer")
public class RegSer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppUser u1 = new AppUser();
		u1.setAddress(request.getParameter("address"));
		u1.setEmail(request.getParameter("email"));
		u1.setPass(request.getParameter("pass"));
		u1.setPhoneNo(request.getParameter("pn"));
		u1.setRole(request.getParameter("role"));
		u1.setSans(request.getParameter("sec_a"));
		u1.setSque(request.getParameter("sec_q"));
		if(u1.isSeller()){
			u1.setStatus("new");			
		}
		else {
			u1.setStatus("approved");						
		}
		u1.setUserName(request.getParameter("uname"));
		AppUserDAO.insert(u1);
		request.setAttribute("msg", "Registration Successfull!");
		RequestDispatcher rd = request.getRequestDispatcher("/public/login.jsp");
		rd.forward(request, response);			
	}
}
