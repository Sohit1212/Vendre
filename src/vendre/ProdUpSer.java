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
@WebServlet("/secure/seller/ProdUpSer")
public class ProdUpSer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession s1 = request.getSession();
		AppUser u1 =  (AppUser)s1.getAttribute("u1");
		String id = request.getParameter("id");		
		Products p1 = ProductsDAO.searchById(id);
		p1.setName(request.getParameter("name"));
		p1.setCategory(request.getParameter("category"));
		p1.setItemDesc(request.getParameter("description"));
		p1.setPrice( Double.parseDouble(request.getParameter("price")));
//		p1.setSellerId(u1.getId());
		p1.setStatus(request.getParameter("status"));
		ProductsDAO.update(p1);
		request.setAttribute("msg", "Updated Successfull!");
		
		Collection<Part> parts = request.getParts();
        Part filePart = request.getPart("at1");
        if(filePart != null){
            String fn =  request.getServletContext().getRealPath("upload/prod/"+id+".jpg") ;
            File f1 = new File(fn);
            if(f1.exists()){
                f1.delete();        	
            }
            f1.createNewFile();
            System.out.println(f1.getAbsolutePath());
            filePart.write(fn);                	
        }		
		RequestDispatcher rd = request.getRequestDispatcher("/secure/seller/seller.jsp");
		rd.forward(request, response);			
	}
}
