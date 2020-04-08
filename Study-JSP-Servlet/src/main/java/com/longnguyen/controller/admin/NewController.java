package com.longnguyen.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.longnguyen.constant.SystemConstant;
import com.longnguyen.model.NewModel;
import com.longnguyen.service.INewService;


@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet{

	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewModel newModel = new NewModel();
		String pageString = req.getParameter("page");
		String maxPageItem = req.getParameter("maxPageItem");
		if (pageString != null) {
			newModel.setPage(Integer.parseInt(pageString));
		} else {
			newModel.setPage(1);
		}
		
		if (maxPageItem != null) {
			newModel.setMaxPageItem(Integer.parseInt(maxPageItem));
		}
		Integer offset = (newModel.getPage() - 1) * newModel.getMaxPageItem();
		newModel.setListResult(newService.findAll(offset, newModel.getMaxPageItem()));
		newModel.setTotalItem(newService.getTotalItem());
		newModel.setTotalPage((int) Math.ceil((double) newModel.getTotalItem() / newModel.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL,newModel);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/new/list.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
