package com.niit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.Bean.BorrowRecordBean;
import com.niit.Bean.StockBean;
import com.niit.constants.MessageConstant;
import com.niit.constants.RequestAttribute;
import com.niit.constants.ViewConstant;
import com.niit.dao.AdminDao;
import com.niit.dao.UserDAO;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/Report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid=request.getParameter("userid");
		String st=request.getParameter("submit");
		
		if(st.equals(RequestAttribute.ShowReport))
		{
			request.getRequestDispatcher(ViewConstant.ShowReport).forward(request, response);
			
			
			
		}
		
		
		
		if(st.equals(RequestAttribute.TotalBooks))
		{
		
		 request.setAttribute(MessageConstant.Show, "totalbooks");	
		 request.getRequestDispatcher(ViewConstant.Report).forward(request, response);
		
		
			
		}

		if(st.equals(RequestAttribute.BorrowedBook))
		{
		
		 request.setAttribute(MessageConstant.Show, "borrowedbooks");	
		 request.getRequestDispatcher(ViewConstant.Report).forward(request, response);
		
		
			
		}
		
		
		
		if(st.equals(RequestAttribute.LostBook))
		{
			 request.setAttribute(MessageConstant.Show, "lostbooks");	
			 request.getRequestDispatcher(ViewConstant.Report).forward(request, response);
			
			
			
			
		}
		if(st.equals(RequestAttribute.ReservedBook))
		{
			
			 request.setAttribute(MessageConstant.Show, "reservedbooks");	
			 request.getRequestDispatcher(ViewConstant.Report).forward(request, response);
			
			
		}
		if(st.equals(RequestAttribute.LateReturnBook))
		{
			
			 request.setAttribute(MessageConstant.Show, "latereturnbooks");	
			 request.getRequestDispatcher(ViewConstant.Report).forward(request, response);
			
			
			
		}
		
		if(st.equals(RequestAttribute.FinedBooks))
		{
			
			 request.setAttribute(MessageConstant.Show, "finedbooks");	
			 request.getRequestDispatcher(ViewConstant.Report).forward(request, response);
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
