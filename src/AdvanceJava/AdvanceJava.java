package AdvanceJava;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

public class AdvanceJava extends HttpServlet
{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		String key = req.getParameter("page");
		System.out.println(key);
		if(key.equalsIgnoreCase("register")){
			req.getRequestDispatcher("register.html").include(req, res);
		}
		if(key.equalsIgnoreCase("login")){
			req.getRequestDispatcher("index.html").include(req, res);
		}
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		String key1 = req.getParameter("page");
		System.out.println(key1);
		mysql sql = new mysql();
		
		//register data
		if(key1.equalsIgnoreCase("")){
			
			//get data from reguister form
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			
			
			//create data object
			data Data = new data(name,password);
			
			
			try {
				
				//sql query process
				String msg = sql.insertdata(Data);
				
				//set atribute
				req.setAttribute("data", msg);
				
				//send res to jsp page
				req.getRequestDispatcher("message.jsp").include(req, res);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
			
		}
		
		
		//login check
		
		if(key1.equalsIgnoreCase("login")){
			
			//get data from reguister form
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			
			
			//create data object
			data Data = new data(name,password);
			
			//sql query process
			String msg;
			try {
				msg = sql.checkdata(Data);
				
				//set atribute
				req.setAttribute("data", msg);
				
				//send res to jsp page
				req.getRequestDispatcher("message.jsp").include(req, res);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		//req.setAttribute("data", name);
		//req.getRequestDispatcher("message.jsp").include(req, res);
	}
	
	
	
	
	
}
