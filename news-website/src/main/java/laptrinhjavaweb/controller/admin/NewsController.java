package laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhjavaweb.constant.SystemConstant;
import laptrinhjavaweb.model.NewsModel;
import laptrinhjavaweb.paging.IPagable;
import laptrinhjavaweb.paging.PageRequest;
import laptrinhjavaweb.service.ICategoryService;
import laptrinhjavaweb.service.INewsService;
import laptrinhjavaweb.sort.Sorter;
import laptrinhjavaweb.utils.FormUtils;
import laptrinhjavaweb.utils.MessageUtils;

@WebServlet(urlPatterns = { "/admin-news" })
public class NewsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;
	
	@Inject
	private ICategoryService categoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// map đối tượng với các giá trị tương ứng trên url
		NewsModel newsModel = FormUtils.toModel(NewsModel.class, request);
		String view = "";
		
		if(newsModel.getType().equals(SystemConstant.LIST)) {
			IPagable pageble = new PageRequest(newsModel.getPage(), newsModel.getMaxPageItem(),
					new Sorter(newsModel.getSortName(),newsModel.getSortBy()));

			newsModel.setListResult(newsService.findAll(pageble));
			newsModel.setTotalItems(newsService.getTotalItems());
			newsModel.setTotalPage((int) Math.ceil((double) newsModel.getTotalItems() / newsModel.getMaxPageItem()));

			view = "/views/admin/news/list.jsp";
		} else if(newsModel.getType().equals(SystemConstant.EDIT)) {
			if(newsModel.getId() != null) {
				newsModel = newsService.findOne(newsModel.getId());
			}
			
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/news/edit.jsp";
		}

		MessageUtils.showMessage(request);
		
		request.setAttribute(SystemConstant.MODEL, newsModel);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {

	}

}
