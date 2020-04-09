package com.longnguyen.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.longnguyen.model.UserModel;
import com.longnguyen.service.ICategoryService;
import com.longnguyen.service.INewService;
import com.longnguyen.service.IUserService;
import com.longnguyen.utils.FormUtils;
import com.longnguyen.utils.SessionUtil;

@WebServlet(urlPatterns = { "/web-home", "/login" ,"/logout"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService iCategoryService;

	@Inject
	private INewService newService;

	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(message != null && alert != null)
			{
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
			requestDispatcher.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/web-home");
		} else {
			req.setAttribute("categorys", iCategoryService.findAll());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/home.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel userModel = FormUtils.toModel(UserModel.class, req);
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			userModel = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassWord(),1);
			if (userModel != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
				if (userModel.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/web-home");
				} else if (userModel.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
			}
		}
	}

}
