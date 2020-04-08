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
import com.longnguyen.paging.Pageble;
import com.longnguyen.paging.pageRequest;
import com.longnguyen.service.INewService;
import com.longnguyen.sort.Sorter;
import com.longnguyen.utils.FormUtils;


@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet{

	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameter("page");
		
		NewModel newModel = FormUtils.toModel(NewModel.class, req);
		Pageble pageble = new pageRequest(newModel.getPage(), newModel.getMaxPageItem(),
				new Sorter(newModel.getSortName(), newModel.getSortBy()));
		
		newModel.setListResult(newService.findAll(pageble));
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
