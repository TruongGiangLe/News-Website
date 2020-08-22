package laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import laptrinhjavaweb.model.NewsModel;
import laptrinhjavaweb.service.INewsService;
import laptrinhjavaweb.utils.HttpUtils;

@WebServlet(urlPatterns = { "/api-admin-news" })
public class NewsAPI extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private INewsService newsService;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// tránh lỗi phông tiếng việt
		request.setCharacterEncoding("UTF-8");

		// định nghĩa kiểu dữ liệu mà server trả về cho client là kiểu json
		response.setContentType("application/json");

		// truyền chuổi json nhận đc từ client cho server, mapping nó với đối tượng
		NewsModel newsModel = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
		newsModel = newsService.save(newsModel);

		// chuyển đối tượng thành json gửi lại cho client
		mapper.writeValue(response.getOutputStream(), newsModel);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// sử dụng đối tượng này để mapper dữ liệu với model
		ObjectMapper mapper = new ObjectMapper();

		// tránh lỗi phông tiếng việt
		request.setCharacterEncoding("UTF-8");

		// định nghĩa kiểu dữ liệu mà server trả về cho client là kiểu json
		response.setContentType("application/json");

		// truyền chuổi json nhận đc từ client cho server, mapping nó với đối tượng
		NewsModel updateNews = HttpUtils.of(request.getReader()).toModel(NewsModel.class);

		updateNews = newsService.update(updateNews);
		// chuyển đối tượng thành json gửi lại cho client
		mapper.writeValue(response.getOutputStream(), updateNews);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// sử dụng đối tượng này để mapper dữ liệu với model
		ObjectMapper mapper = new ObjectMapper();

		// tránh lỗi phông tiếng việt
		request.setCharacterEncoding("UTF-8");

		// định nghĩa kiểu dữ liệu mà server trả về cho client là kiểu json
		response.setContentType("application/json");

		// truyền chuổi json nhận đc từ client cho server, mapping nó với đối tượng
		NewsModel newsModel = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
		
		newsService.delete(newsModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}

}
