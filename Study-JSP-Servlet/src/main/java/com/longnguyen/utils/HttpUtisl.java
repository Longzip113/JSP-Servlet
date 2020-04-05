package com.longnguyen.utils;

import java.io.BufferedReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtisl {
	private String value;

	public HttpUtisl(String value) {
		this.value = value;
	};

	//Chuyển file json thành  String 
	public static HttpUtisl of(BufferedReader bufferedReader) {

		StringBuilder sb = new StringBuilder();
		try {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new HttpUtisl(sb.toString());
	}
	
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
