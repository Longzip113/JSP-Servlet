package com.longnguyen.utils;

import javax.servlet.http.HttpServletRequest;

import com.longnguyen.constant.SystemConstant;

public class MessageUtil {
	public static void showMessage(HttpServletRequest req) {
		if (req.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = req.getParameter(SystemConstant.MESSAGE);
			if (message.equals("insert_success")) {
				messageResponse = "Insert success";
				alert = "success";
			} else if (message.equals("updata_success")) {
				messageResponse = "Updata success";
				alert = "success";
			} else if (message.equals("delete_success")) {
				messageResponse = "Delete success";
				alert = "success";
			} else if (message.equals("error_success")) {
				messageResponse = "Error System";
				alert = "danger";
			}
			req.setAttribute(SystemConstant.MESSAGE_RESPONSE, messageResponse);
			req.setAttribute(SystemConstant.ALERT, alert);
		}

	}
}
