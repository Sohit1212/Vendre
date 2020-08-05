package vendre;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vendre.bean.AppUser;
@WebFilter("/secure/seller/*")
public class SellerFil implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession s1 = req.getSession();
		Object ou1 = s1.getAttribute("u1");
		if(ou1!=null){
			AppUser u1 = (AppUser) ou1;
			if(u1.isSeller()){
				chain.doFilter(request, response);							
			}
			else {				
				request.setAttribute("err", "Please login as Seller!");
				RequestDispatcher rd = request.getRequestDispatcher("/public/login.jsp");
				rd.forward(req, resp);							
			}
		}
		else {
			String ctx = req.getServletContext().getContextPath();			
			resp.sendRedirect(ctx + "/public/login.jsp");
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
