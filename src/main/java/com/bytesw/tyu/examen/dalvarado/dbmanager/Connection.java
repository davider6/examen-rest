package com.bytesw.tyu.examen.dalvarado.dbmanager;

import java.sql.DriverManager;

public class Connection {
	
	public java.sql.Connection getConn(){
		
		java.sql.Connection conn = null;
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			conn = DriverManager.getConnection(  
					
			"jdbc:mysql://xjobs-database.chwuljcjdqdx.us-east-2.rds.amazonaws.com:3306/xpertsol",
			"xjobusr",
			"xp3r7s0lu710n5502");
			  
			if ( conn != null)  
				return conn;
			else
				return null;
			
		}catch(Exception e){ 
			System.out.println(e);
		}  
		
		return null;
		 
	}

}
