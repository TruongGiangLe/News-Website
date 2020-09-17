package laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhjavaweb.model.UserModel;
import laptrinhjavaweb.service.IUserService;
import laptrinhjavaweb.utils.FormUtils;
import laptrinhjavaweb.utils.SessionUtils;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 1L;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if(message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtils.getInstance().removeValue(request, "USERMODEL");
			// redirect tới trang chủ
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel userModel = FormUtils.toModel(UserModel.class, request);
			userModel = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(),1);
			if(userModel != null) {
				// lưu user model vào session
				SessionUtils.getInstance().putValue(request, "USERMODEL", userModel);
				if(userModel.getRole().getCode().equals("USER")) {
					reponse.sendRedirect(request.getContextPath() + "/trang-chu");
				} else if(userModel.getRole().getCode().equals("ADMIN")) {
					reponse.sendRedirect(request.getContextPath() + "/admin-home");
				}
			} else {
				// redirect tới 1 controller nào đó nếu không có tồn tại user
				// getcontext...: lấy phần tên miền
				reponse.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		}
	}

}
