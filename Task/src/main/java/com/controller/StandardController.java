package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Standard;
import com.dao.StudentDao;

@WebServlet("/StandardController")
public class StandardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("Insert Standard"))
		{
			Standard s=new Standard();
			s.setName(request.getParameter("sname"));
			s.setStatus(request.getParameter("status"));
			StudentDao.insertStandard(s);
			response.sendRedirect("insert_standard.jsp");
		}
	}

}
