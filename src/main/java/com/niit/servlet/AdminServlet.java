package com.niit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.Bean.StockBean;
import com.niit.constants.MessageConstant;
import com.niit.constants.RequestAttribute;
import com.niit.constants.UrlConstant;
import com.niit.constants.ViewConstant;
import com.niit.dao.AdminDao;
import com.niit.model.Account;
import com.niit.model.Book;
import com.niit.model.Publisher;
import com.niit.model.Stock;
import com.niit.model.Type;
import com.niit.model.User;
import com.niit.service.AdminService;
import com.niit.service.UserService;
import com.niit.supportclasses.GeneralSupport;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		String st=request.getParameter("submit");
		String id=request.getParameter("id");
		String role=request.getParameter("role");
		String username=request.getParameter("name");
		String password=request.getParameter("pass");
		String gender=request.getParameter("gender");
		String tel=request.getParameter("tel");
		String loc=request.getParameter("loc");
		String email=request.getParameter("email");
        String typename=request.getParameter("typename");
        String releasingtype=request.getParameter("releasingtype");
        String time=request.getParameter("time");
		String publihsername=request.getParameter("publishername");
        String bookname=request.getParameter("bookname");
        String author=request.getParameter("author");
        String releasingtime=request.getParameter("releasingtime");
        String price=request.getParameter("price");
        String publisher=request.getParameter("publisher");
        String contenttype=request.getParameter("contenttype");
        String type=request.getParameter("type");
        String userid=request.getParameter("userid");
        String balance=request.getParameter("balance");
        String money=request.getParameter("increasedmoney");
        String accountid=request.getParameter("accountid");
        String quantity=request.getParameter("quantity");
        String stockid=request.getParameter("stockid");
        String numtoadd=request.getParameter("numtoadd");
        
		if(st.equalsIgnoreCase(UrlConstant.Login_Admin))
		{
			if(username.equalsIgnoreCase(MessageConstant.Admin_UserName)&&password.equalsIgnoreCase(MessageConstant.Admin_PassWord))
			{
				request.getRequestDispatcher(ViewConstant.Admin_WELCOMEPAGE).forward(request, response);
				
				
			}
			else {
				request.getRequestDispatcher(ViewConstant.AdminLOGINPAGE).forward(request, response);
				
			}
			
		}
		if(st.equalsIgnoreCase(RequestAttribute.Manage_User))
		{
			
				request.getRequestDispatcher(ViewConstant.Manage_User).forward(request, response);
				
		
			
		}
		
		if(st.equals(RequestAttribute._Add_User))
		{
			
			request.getRequestDispatcher(ViewConstant.Add_User).forward(request, response);
		}
		
		
		
		if(st.equalsIgnoreCase(RequestAttribute.Add_User)) {
	
			User user=new User(username,gender,role,tel,loc,email,password);
			try {
			
				Integer flag=UserService.addUser(user);
				if(flag==MessageConstant.USER_ISNULL) {
					
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.Add_User);
					rd.forward(request, response);
				}else if(flag==MessageConstant.USER_CREATE_SUCCESS) {
					
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.Manage_User);
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
		
		if(st.equalsIgnoreCase(RequestAttribute._Delete_User))
		{
			try {
				AdminService.DeleteUser(Integer.parseInt(id));
			    request.getRequestDispatcher(ViewConstant.Manage_User).forward(request, response);
			
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		if(st.equalsIgnoreCase(RequestAttribute._Edit_User))
		{
			User user;
			try {
				user = AdminService.getUser(Integer.parseInt(id));
				request.setAttribute(MessageConstant.User,user);
				request.getRequestDispatcher(ViewConstant.Edit_User).forward(request, response);;
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		if(st.equalsIgnoreCase(RequestAttribute.Edit_User))
		{

			User user=new User(id,username,gender,role,tel,loc,email,password);
			try {
				AdminService.EditUser(user);
			    request.getRequestDispatcher(ViewConstant.Manage_User).forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	 if(st.equalsIgnoreCase(RequestAttribute._Change_UserState))	
	 {
		 try {
			AdminService.ChangeUserState(Integer.parseInt(id));
		    response.sendRedirect(ViewConstant.Manage_User);
		 } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }

	 if(st.equalsIgnoreCase(RequestAttribute.Manage_Book)) {

	    request.getRequestDispatcher(ViewConstant.Manage_Book).forward(request, response);
	
	
	}

	
	 if(st.equals(RequestAttribute.Add_BookType))
	 {
		 request.getRequestDispatcher(ViewConstant.Add_BookType).forward(request, response);;
		 
	 }
	 
	 
	 
	 
	 if(st.equals(RequestAttribute._Add_BookType))
	 {
		 Type type1=new Type(typename,releasingtype,time);
		 
		 try {
				
				Integer flag=AdminService.addBookType(type1);
				if(flag==MessageConstant.BookType_ISNULL) {
					
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.Add_BookType);
					rd.forward(request, response);
				}else if(flag==MessageConstant.BookType_Create_Success) {
					
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.Manage_BookType);
					rd.forward(request, response);
		 
				}
				}
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 
		 
		 
	 }
	 
	 if(st.equals(RequestAttribute.Add_Publisher))
	 {
		 request.getRequestDispatcher(ViewConstant.Add_Publihser).forward(request, response);
		 
	 }
	 
	 
	 
	 if(st.equals(RequestAttribute._Add_Publisher))
	 {
         Publisher publisher1=new Publisher(publihsername,loc,tel);
		 
		 try {
				
				Integer flag=AdminService.addPublisher(publisher1);
				if(flag==MessageConstant.Pubisher_ISNULL) {
					
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.Add_Publihser);
					rd.forward(request, response);
				}else if(flag==MessageConstant.Publisher_Create_Success) {
					
					RequestDispatcher rd=request.getRequestDispatcher(ViewConstant.Manage_Publisher);
					rd.forward(request, response);
		 
				}
				}
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 
		 
		 
	 }
	 
	 
	 if(st.equalsIgnoreCase(RequestAttribute.Delete_Publisher))
	 
	 {
		 try {
			AdminDao.DeletePublisher(Integer.parseInt(id));
		    request.getRequestDispatcher(ViewConstant.Manage_Publisher).forward(request, response);
		 } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 if(st.equalsIgnoreCase(RequestAttribute.Delete_BookType))
		 
	 {
		 try {
			AdminDao.DeleteBookType(Integer.parseInt(id));;
		    request.getRequestDispatcher(ViewConstant.Manage_BookType).forward(request, response);
		 } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 if(st.equals(RequestAttribute.Edit_BookType))
	 {
		 try {
			Type type2=AdminDao.getType(Integer.parseInt(id));
		    request.setAttribute(MessageConstant.Type,type2);
		    request.getRequestDispatcher(ViewConstant.Edit_BookType).forward(request, response);
		 } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	 
	 if(st.equals(RequestAttribute.Edit_Publisher))
	 {
		 try {
			Publisher publisher2=AdminDao.getPublisher(Integer.parseInt(id));
		    request.setAttribute(MessageConstant.Publisher,publisher2);
		    request.getRequestDispatcher(ViewConstant.Edit_Publihser).forward(request, response);
		 } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	  
	 if(st.equals(RequestAttribute._Edit_BookType))
	 {
		 Type type3=new Type(id,typename,releasingtype,time);
		 try {
			AdminDao.EditBookType(type3);
		    request.getRequestDispatcher(ViewConstant.Manage_BookType).forward(request, response);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
       }
	
	 if(st.equals(RequestAttribute._Edit_Publisher))
	 {
		Publisher pub=new Publisher(id,publihsername,loc,tel);
		 try {
			AdminDao.EditPublisher(pub);;
		 request.getRequestDispatcher(ViewConstant.Edit_Publihser).forward(request, response);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
       }
	 if(st.equals(RequestAttribute.Change_BookTypeState))
	 {
		 
		 try {
			AdminDao.ChangeBookTypeState(Integer.parseInt(id));
		    request.getRequestDispatcher(ViewConstant.Manage_BookType).forward(request, response);
		 } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
	 
	 if(st.equals(RequestAttribute.Change_PublisherState))
	 {
		 try {
			AdminDao.ChangePublisherState(Integer.parseInt(id));
		    request.getRequestDispatcher(ViewConstant.Manage_Publisher).forward(request, response);
		 } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
	 }
	 if(st.equals(RequestAttribute.Manage_BookType)) {
	 
	 request.getRequestDispatcher(ViewConstant.Manage_BookType).forward(request, response);
	 
    }
	
	if(st.equals(RequestAttribute.Manage_Publisher))
	{
		
		request.getRequestDispatcher(ViewConstant.Manage_Publisher).forward(request, response);
		
	}

	if(st.equals(RequestAttribute.Add_Book))
	{
		request.getRequestDispatcher(ViewConstant.Add_Book).forward(request, response);
		
		
	}
	
	if(st.equals(RequestAttribute._Add_Book))
	{
		Book book=new Book(bookname,author,releasingtime,publisher,price,contenttype,type);
		try {
			int flag=AdminService.addBook(book);
		    if(flag==MessageConstant.Book_Create_Success)
		    {
		    	Book book1=AdminDao.getBook(bookname, releasingtime);
		    	int bookid=book1.getId();
		    	Stock  stock=new Stock(bookid,quantity,GeneralSupport.getDate());
		    	AdminDao.addStock(stock);
		    	
		    	request.getRequestDispatcher(ViewConstant.Manage_Book).forward(request, response);
		    }
		    else if(flag==MessageConstant.Book_ISNULL){
		    	request.getRequestDispatcher(ViewConstant.Add_Book).forward(request, response);
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	if(st.equals(RequestAttribute.Edit_Book))
	{
		Book book;
		try {
			book = AdminDao.getBook(Integer.parseInt(id));
			request.setAttribute(MessageConstant.Book, book);
			request.getRequestDispatcher(ViewConstant.Edit_Book).forward(request, response);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	if(st.equals(RequestAttribute._Edit_Book))
	{
		Book book=new Book(id,bookname,author,releasingtime,publisher,price,contenttype,type);
		try {
			AdminDao.EditBook(book);
		    request.getRequestDispatcher(ViewConstant.Manage_Book).forward(request, response);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	if(st.equals(RequestAttribute.Delete_Book))
	{
		try {
			AdminDao.DeleteBook(Integer.parseInt(id));
			request.getRequestDispatcher(ViewConstant.Manage_Book).forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	if(st.equals(RequestAttribute.Change_BookState))
	{
		try {
			AdminDao.changeBookState(Integer.parseInt(id));
			request.getRequestDispatcher(ViewConstant.Manage_Book).forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	if(st.equals(RequestAttribute.Bind_Account))
	{
		request.getRequestDispatcher(ViewConstant.Bind_Account).forward(request, response);
		
		
	}
	
	if(st.equals(RequestAttribute._Bind_Account))
	{
		Account a=new Account(userid,balance);
		try {
			AdminDao.AddAccount(a);
		request.getRequestDispatcher(ViewConstant.Manage_Account).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	if(st.equalsIgnoreCase(RequestAttribute.Manage_Account))
	{
		request.getRequestDispatcher(ViewConstant.Manage_Account).forward(request, response);
		
		
		
	}
	if(st.equals(RequestAttribute.Add_Balance))
	{
		try {
			AdminDao.AddBalance(Integer.parseInt(accountid), Double.parseDouble(money));
	        request.getRequestDispatcher(ViewConstant.Manage_Account).forward(request, response);
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	if(st.equals(RequestAttribute.Cancel_Account)) {
	
		try {
			AdminDao.DeleteAccount(Integer.parseInt(accountid));
		    request.getRequestDispatcher(ViewConstant.Manage_Account).forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	if(st.equals(RequestAttribute.Add_Stock))
{
	try {
		List<StockBean> list=AdminDao.queryStock();
	    request.setAttribute(MessageConstant.StockList, list);
	    request.getRequestDispatcher(ViewConstant.AddStock).forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}
	if(st.equals(RequestAttribute._Add_Stock))
	{
		
		try {
			AdminDao.addstock(Integer.parseInt(stockid),Integer.parseInt(numtoadd));
		    request.getRequestDispatcher(ViewConstant.Admin_WELCOMEPAGE).forward(request, response);
			
			
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