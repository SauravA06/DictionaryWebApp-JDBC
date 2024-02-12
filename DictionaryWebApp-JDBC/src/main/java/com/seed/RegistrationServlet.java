package com.seed;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String Url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String User = "system";
		String Pass = "orcl";
		
		String fname = request.getParameter("fname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(Url,User,Pass);
			
			PreparedStatement pst = con.prepareStatement("insert into users values(?,?,?,?,?)");
			
			pst.setString(1, fname);
			pst.setString(2, email);
			pst.setString(3, phone);
			pst.setString(4, username);
			pst.setString(5, password);
			
			
//			ResultSet rs = pst.executeQuery();
			
			int i = pst.executeUpdate();
			
			if(i>0) {
				response.getWriter().println("Registration Successfull");
				
				String htmlRes = "<html>" ;
				htmlRes += "<p><a href='Login.jsp'>Click here</a> to login." ;
				htmlRes += "</html>" ;
				
				response.getWriter().println(htmlRes);
			}
			
			con.close();
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
