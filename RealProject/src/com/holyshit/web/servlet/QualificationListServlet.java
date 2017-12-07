package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Qualification;
import com.holyshit.service.QualificationService;
import com.holyshit.service.impl.QualificationServiceImpl;


/**
 * Servlet implementation class QualificationListServlet
 */
@WebServlet("/qualificationListServlet")
public class QualificationListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffno=request.getParameter("staffno");//��Ҫ��ȡ��ǰ��staffno��ֵ
		QualificationService qfsi = new QualificationServiceImpl();
		List<Qualification> Qualifications = qfsi.findAllQualifications(staffno);
		request.setAttribute("Qualification", Qualifications);
		request.setAttribute("staffno", staffno);
		request.getRequestDispatcher("/hr_main.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}