package com.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.Student;
import com.dao.StudentDao;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024 * 512) // 512MB
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String extractfilename(Part file) {
	    String cd = file.getHeader("content-disposition");
	    System.out.println(cd);//form-data; name="product_image"; filename="shoes1.jpg"
	    String[] items = cd.split(";");
	    for (String string : items) {
	        if (string.trim().startsWith("filename")) {
	            return string.substring(string.indexOf("=") + 2, string.length()-1);
	        }
	    }
	    return "";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action=request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("insert"))
		{
			
			String savePath = "C:\\Users\\Tops\\SpringTak\\Task\\src\\main\\webapp\\product_images";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\Tops\\SpringTak\\Task\\src\\main\\webapp\\product_images";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        int sid=Integer.parseInt(request.getParameter("standard"));
			Student s=new Student();
			s.setSid(sid);
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setDob(request.getParameter("dob"));
			
			s.setCreated_date(java.time.LocalDate.now().toString());
			s.setImage(fileName);
			StudentDao.insertStudent(s);
			request.setAttribute("msg", "Student Added Successfully");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
		}
		
	}

}
