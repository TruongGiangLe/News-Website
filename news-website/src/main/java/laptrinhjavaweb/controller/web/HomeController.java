package laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhjavaweb.model.NewsModel;
import laptrinhjavaweb.service.ICategoryService;
import laptrinhjavaweb.service.INewsService;

@WebServlet(urlPatterns =  {"/trang-chu"})
public class HomeController extends HttpServlet{

	/**
	 * 
	 */
	@Inject
	private ICategoryService categoryService;	
	
	@Inject
	private INewsService newsService;

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
//		request.setAttribute("categories", categoryService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		
	}
	
}
