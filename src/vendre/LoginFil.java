package vendre;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vendre.bean.AppUser;
@WebFilter("/secure/*")
public class LoginFil implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession s1 = req.getSession();
		Object ou1 = s1.getAttribute("u1");
		if(ou1!=null){
			chain.doFilter(request, response);			
		}
		else {
			String ctx = req.getServletContext().getContextPath();		
			resp.sendRedirect( ctx + "/public/login.jsp");
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
