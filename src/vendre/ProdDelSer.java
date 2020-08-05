package vendre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vendre.bean.AppUser;
import vendre.bean.Products;
import vendre.dao.AppUserDAO;
import vendre.dao.ProductsDAO;

/**
 * Servlet implementation class RegSer
 */
@MultipartConfig
@WebServlet("/secure/seller/ProdDelSer")
public class ProdDelSer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
		HttpSession s1 = request.getSession();
		AppUser u1 =  (AppUser)s1.getAttribute("u1");        
		ProductsDAO.delete(id, u1.getId());
		request.setAttribute("msg", "Delete Successfull!");		
        String fn =  request.getServletContext().getRealPath("upload/prod/"+id+".jpg") ;
        File f1 = new File(fn);
        if(f1.exists()){
            f1.delete();        	
        }
		RequestDispatcher rd = request.getRequestDispatcher("/secure/seller/seller.jsp");
		rd.forward(request, response);			
	}
}
