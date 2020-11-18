package AdvanceJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 


public class mysql {

	
   
	public String insertdata(data data) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		//connection of mysql
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studentsdata", "root", "");
		
		
		//build qury
		String query = "insert into data value('"+data.getName()+"'"+","+"'"+data.getPassword()+"')";
		
		//create statement
	    Statement stmt = (Statement) con.createStatement();
	   
	    //insert data into database
	    boolean ckeck = stmt.execute(query);
	     
	     if(ckeck){
	    	 return "not  success";
	     }else{
	    	 return "success";
	     }
	    
	    
		
	}

	public String checkdata(data data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		//connection of mysql
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/studentsdata", "root", "");
				
				
				//build qury
				String query2= "select * from data where name="+"'"+data.getName()+"'";
				
				Statement stmt = (Statement) con.createStatement();
				ResultSet  rs = stmt.executeQuery(query2);
			    
				if(rs.next()){
					
					String namers= rs.getString(2);
					if(namers.equalsIgnoreCase(data.getPassword())){
						return "login successfully";
					}else{
						return "please enter valid name or password";
					}
					
				}
		
		
		
		return null;
	}
}
