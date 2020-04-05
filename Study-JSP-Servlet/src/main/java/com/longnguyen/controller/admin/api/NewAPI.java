package com.longnguyen.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.longnguyen.model.NewModel;
import com.longnguyen.service.INewService;
import com.longnguyen.utils.HttpUtisl;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet{
	@Inject
	
	private INewService newService;

	private static final long serialVersionUID = 1L;
	
	
	//Sua bai viet post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewModel newModel = HttpUtisl.of(req.getReader()).toModel(NewModel.class); // chuyen file json qua model
		newModel = newService.save(newModel);
		System.out.println(newModel);
		objectMapper.writeValue(resp.getOutputStream(), newModel);
	}
	
	

}
