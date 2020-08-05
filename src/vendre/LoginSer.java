package vendre;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vendre.bean.AppUser;
import vendre.dao.AppUserDAO;

@WebServlet("/LoginSer")
public class LoginSer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		AppUser u1 = AppUserDAO.validate(email, pass);
		if(u1!=null){
			HttpSession s1 = request.getSession();
			s1.setMaxInactiveInterval(60*60*3);
			s1.setAttribute("u1", u1);
			RequestDispatcher rd = request.getRequestDispatcher("/public/index.jsp");
			rd.forward(request, response);
		}		
		else {
			request.setAttribute("err", "Incorrect Username or password!");
			RequestDispatcher rd = request.getRequestDispatcher("/public/login.jsp");
			rd.forward(request, response);			
		}
	}
}
