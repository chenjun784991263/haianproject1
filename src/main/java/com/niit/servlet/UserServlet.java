package com.niit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.css.ViewCSS;

import com.niit.Bean.BookBean;
import com.niit.Bean.BorrowRecordBean;
import com.niit.Bean.ReserveRecordBean;
import com.niit.constants.FlagConstants;
import com.niit.constants.MessageConstant;
import com.niit.constants.RequestAttribute;
import com.niit.constants.UrlConstant;
import com.niit.constants.ViewConstant;
import com.niit.dao.AdminDao;
import com.niit.dao.UserDAO;
import com.niit.model.Account;
import com.niit.model.AccountRecord;
import com.niit.model.Book;
import com.niit.model.BorrowRecord;
import com.niit.model.LoseRecord;
import com.niit.model.ReserveRecord;
import com.niit.model.Stock;
import com.niit.model.User;
import com.niit.service.UserService;
import com.niit.supportclasses.EmailConfig;
import com.niit.supportclasses.GeneralSupport;
import com.niit.supportclasses.RejectBorrowEmail;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		
		String userid=request.getParameter("userid");
		String bookid=request.getParameter("bookid");
		String role=request.getParameter("role");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String gender=request.getParameter("gender");
		String tel=request.getParameter("tel");
		String submt=request.getParameter("submit");
		String loc=request.getParameter("loc");
	    String email=request.getParameter("email");
		String borrowlength=request.getParameter("borrowlength");
		String borrowrecordid=request.getParameter("borrowrecordid");
		String bookname=request.getParameter("bookname");
		String reserverecordid=request.getParameter("reserverecordid");
		
		
		if(submt.equalsIgnoreCase(UrlConstant.Login_User)) {
			User user=new User(name,pass);
			try {
				Integer flag=UserService.login(user);
				if(flag==MessageConstant.LOGIN_SUCCESS) {
					User usermodel=UserDAO.getUser(user);
					request.setAttribute(MessageConstant.User, usermodel);
					request.setAttribute(RequestAttribute.MSG, MessageConstant.LOGIN_USER_SUCCESS);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.User_WELCOMEPAGE);
					rd.forward(request, response);
				}else if(flag==MessageConstant.LOGIN_FAIL) {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.LOGIN_USER_FAIL);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.UserLOGINPAGE);
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		if(submt.equalsIgnoreCase("Register")) {
	
			User user=new User(name,gender,role,tel,loc,email,pass);
			try {
			
				Integer flag=UserService.addUser(user);
				if(flag==MessageConstant.USER_ISNULL) {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.USER_CREATE_FAIL);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.INDEXPAGE);
					rd.forward(request, response);
				}else if(flag==MessageConstant.USER_CREATE_SUCCESS) {
					EmailConfig.sendEmail(user);
					request.setAttribute(RequestAttribute.MSG, MessageConstant.USER_CREATE);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.UserLOGINPAGE);
					rd.forward(request, response);
				}else {
					request.setAttribute(RequestAttribute.MSG, MessageConstant.SOMETHING_WENT_WRONG);
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.INDEXPAGE);
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(submt.equals(RequestAttribute.Borrow_Book))
		{
			request.setAttribute(MessageConstant.UserID,Integer.parseInt(userid));
			request.getRequestDispatcher(ViewConstant.Borrow_Book).forward(request, response);
			
		}
		
		if(submt.equals(RequestAttribute._Borrow_Book))
		{
			String borrowdate=GeneralSupport.getDate();
	        Calendar cal=GeneralSupport.getCalTime(borrowdate);
			cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(borrowlength));
			String shouldreturndate=GeneralSupport.getDate(cal);
			int borrownum=0;
			BorrowRecord br=new BorrowRecord(userid,bookid,borrowdate,shouldreturndate);
			
			try {
				borrownum = (UserDAO.QueryBorrowRecord(Integer.parseInt(userid)).size());
				Stock stock=UserDAO.getStock(Integer.parseInt(bookid));
				int booknum=stock.getQuantity();
				if(borrownum<5&&booknum>0)
				{
					UserDAO.AddBorrowRecord(br);
				    UserDAO.changeStockForBorrowOrReserveOrLose(stock);
					User user=AdminDao.getUser(Integer.parseInt(userid));
				    request.setAttribute(MessageConstant.User,user);
					request.getRequestDispatcher(ViewConstant.User_WELCOMEPAGE).forward(request, response);
					
				}
				else if(borrownum>=5&&booknum>0){
					
					request.setAttribute(MessageConstant.message1,MessageConstant.ExcessiveBorrowingWarning);
					request.getRequestDispatcher(ViewConstant.Error_page).forward(request, response);
					
				}
				else if(borrownum<5&&booknum==0)
				{
					request.setAttribute(MessageConstant.message2,MessageConstant.StackLackingWarning);
					request.getRequestDispatcher(ViewConstant.Error_page).forward(request, response);
				}
			
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		
	   if(submt.equals(RequestAttribute._Return_Book)){
		  
		  
		   try {
			BorrowRecord br=UserDAO.getBorrowRecord(Integer.parseInt(borrowrecordid));
			Date now=new Date();
	        Date shouldreturndate=GeneralSupport.getTime(br.getShouldreturndate());
			int timelength=GeneralSupport.differentDaysByMillisecond(shouldreturndate, now);
		 	int bookid1=br.getBookid();
			if(timelength<=0)
			{
				UserDAO.DeleteBorrowRecord(Integer.parseInt(borrowrecordid));
				Stock stock=UserDAO.getStock(bookid1);
		    	UserDAO.changeStockForReturnOrCancelReserve(stock);
		    	User user=AdminDao.getUser(Integer.parseInt(userid));
		    	request.setAttribute(MessageConstant.User, user);
				request.getRequestDispatcher(ViewConstant.User_WELCOMEPAGE).forward(request, response);
			}
			else if(timelength>0)
		    {
		   
		    	Account account=UserDAO.getAcccount(Integer.parseInt(userid));
		    	int accountid=account.getId();
		    	AccountRecord ar=new AccountRecord(bookid1,accountid,timelength,timelength*0.5);
		    	UserDAO.addAccountRecord(ar);
		    	UserDAO.fine(accountid, ar.getOverduefine());
		    	UserDAO.DeleteBorrowRecord(Integer.parseInt(borrowrecordid));
		    	Stock stock=UserDAO.getStock(bookid1);
		    	UserDAO.changeStockForReturnOrCancelReserve(stock);
		    	request.setAttribute(MessageConstant.User, AdminDao.getUser(Integer.parseInt(userid)));
		    	request.getRequestDispatcher(ViewConstant.User_WELCOMEPAGE).forward(request, response);
		    	
		    }
			
			
			
			
			
		   } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
		   
	    }
		if(submt.equals(RequestAttribute.Reserve_Book))
		{
		try {
			Stock stock=UserDAO.getStock(Integer.parseInt(bookid));
			int booknum=stock.getQuantity();
			
			int num1=UserDAO.queryreserverecordbyBook(Integer.parseInt(bookid)).size();
		    int num2=UserDAO.queryreserverecordbyUser(Integer.parseInt(userid)).size();
		    if(num1>=1)
		    {
		    	request.setAttribute(MessageConstant.message3,MessageConstant.DepulicateReserveWarnning);
		    	request.getRequestDispatcher(ViewConstant.Error_page).forward(request, response);
		    	
		    }
		    else if(num1<1&&num2>=3)
		    {
		    	request.setAttribute(MessageConstant.message4,MessageConstant.ExcessiveReserveWarning);
		    	request.getRequestDispatcher(ViewConstant.Error_page).forward(request, response);
		    	
		    	
		    }
		    else if(booknum<1)
		    {
		    	request.setAttribute(MessageConstant.message2,MessageConstant.StackLackingWarning);
				request.getRequestDispatcher(ViewConstant.Error_page).forward(request, response);
		    	
		    }
		    
		    else if(num1<1&&num2<3&&booknum>=1)
		    {
		    	ReserveRecord rr=new ReserveRecord(Integer.parseInt(userid),Integer.parseInt(bookid));
		    	UserDAO.changeStockForBorrowOrReserveOrLose(stock);
		    	UserDAO.addReserveRecord(rr);
		    	User user=AdminDao.getUser(Integer.parseInt(userid));
		    	request.setAttribute(MessageConstant.User, user);
		    	request.getRequestDispatcher(ViewConstant.User_WELCOMEPAGE).forward(request, response);
		    }
		    
		    
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
			
		}
	   
	   
	   
		if(submt.equals(RequestAttribute.Return_Book)||submt.equals(RequestAttribute.Report_Loss))
		{
		try {
			List<BorrowRecordBean> list=UserDAO.QueryBorrowRecord(Integer.parseInt(userid));
			request.setAttribute(MessageConstant.UserID, Integer.parseInt(userid));
			request.setAttribute(MessageConstant.BorrowRecord, list);
		    request.getRequestDispatcher(ViewConstant.ReturnOrLose_Book).forward(request, response);
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
		}
		
		
		
	

	if(submt.equals(RequestAttribute._Search_Borrow))
	{
		try {
			List<Book>list=UserDAO.SelectBookByInf(bookname);
		    request.setAttribute(MessageConstant.BookList, list);
		    request.setAttribute(MessageConstant.UserID, Integer.parseInt(userid));
		    request.getRequestDispatcher(ViewConstant.Search_BookList).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	if(submt.equals(RequestAttribute.Lose_Book)) {
		
		try {
			BorrowRecord br=UserDAO.getBorrowRecord(Integer.parseInt(borrowrecordid));
	        int bookid2=br.getBookid();
		    LoseRecord lr=new LoseRecord(Integer.parseInt(userid),bookid2);
	        UserDAO.AddLoseRecord(lr);
	        LoseRecord lr1=UserDAO.getLoseRecord(Integer.parseInt(userid), bookid2);
	        int loserecordid=lr1.getId();
	        Book book1=AdminDao.getBook(bookid2);
		    double price=book1.getPrice();
			Account account=UserDAO.getAcccount(Integer.parseInt(userid));
		    int accountid=account.getId();
		    AccountRecord ar=new AccountRecord(accountid,bookid2,price,loserecordid);
		    UserDAO.addAccountRecord(ar);
		    UserDAO.fine(accountid,price); 
		    Stock stock=UserDAO.getStock(bookid2);
            UserDAO.changeStockForBorrowOrReserveOrLose(stock);
		    UserDAO.DeleteBorrowRecord(Integer.parseInt(borrowrecordid));
			User user=AdminDao.getUser(Integer.parseInt(userid));
	    	request.setAttribute(MessageConstant.User, user);
	    	request.getRequestDispatcher(ViewConstant.User_WELCOMEPAGE).forward(request, response);
	    
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	if(submt.equals(RequestAttribute.Cancel_Reserve))
	{
	  try {
		List<ReserveRecordBean>list=UserDAO.QueryReserveRecord(Integer.parseInt(userid));
		request.setAttribute(MessageConstant.UserID,Integer.parseInt(userid));
		request.setAttribute(MessageConstant.ReserveRecord, list);
		request.getRequestDispatcher(ViewConstant.CancelReserve).forward(request, response);
		
		
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
		
		
		
		
	}
	if(submt.equals(RequestAttribute._Cancel_Reserve))
	{
		try {
			UserDAO.DeleteReserveRecord(Integer.parseInt(reserverecordid));
			Stock stock=UserDAO.getStock(Integer.parseInt(bookid));
			UserDAO.changeStockForReturnOrCancelReserve(stock);
			
			User user=AdminDao.getUser(Integer.parseInt(userid));
			request.setAttribute(MessageConstant.User,user);
			request.getRequestDispatcher(ViewConstant.User_WELCOMEPAGE).forward(request, response);			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	

	
	}	
		
	

}

