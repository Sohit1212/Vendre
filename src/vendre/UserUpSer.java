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
@WebServlet("/secure/admin/UserUpSer")
public class UserUpSer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = request.getParameter("id");
		AppUser u1 = AppUserDAO.searchById(id);
		u1.setStatus(request.getParameter("status"));
		AppUserDAO.update(u1);
		request.setAttribute("msg", "Successfully updated!");
		RequestDispatcher rd = request.getRequestDispatcher("/secure/admin/admin.jsp");
		rd.forward(request, response);					
	}
}
