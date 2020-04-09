package com.longnguyen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.longnguyen.constant.SystemConstant;
import com.longnguyen.model.UserModel;
import com.longnguyen.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI(); // lấy được link khi bạn truy cập vào
		if (url.startsWith("/Study-JSP-Servlet/admin")) {
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if (userModel != null) {
				if(userModel.getRole().getCode().equals(SystemConstant.ADMIN)) {
					chain.doFilter(request, response);
				}else if (userModel.getRole().getCode().equals(SystemConstant.USER)) {
					resp.sendRedirect(req.getContextPath() + "/login?action=login&message=not_permission&alert=danger");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login&message=not_login&alert=danger");
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
