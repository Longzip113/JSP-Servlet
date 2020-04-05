package com.longnguyen.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.longnguyen.model.NewModel;
import com.longnguyen.service.ICategoryService;
import com.longnguyen.service.INewService;


@WebServlet(urlPatterns = {"/web-hom"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICategoryService iCategoryService;
	
	@Inject
	private INewService newService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		UserModel model = new UserModel();
//		model.setUserName("Longnguyen");
//		req.setAttribute("model",model); // in data ra client
//		Long categoryId = 1L;
//		req.setAttribute("news", newService.findByCategoryId(categoryId));
//		String title = "Bai viet mau";
//		String content = "Content bai viet";
//		NewModel newModel = new NewModel();
//		newModel.setCategoryId(categoryId);
//		newModel.setContent(content);
//		newModel.setTitle(title);
//		newService.save(newModel);
//		req.setAttribute("categorys", iCategoryService.findAll());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/home.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
