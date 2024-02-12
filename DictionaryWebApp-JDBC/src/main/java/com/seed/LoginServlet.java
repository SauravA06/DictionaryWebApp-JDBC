package com.seed;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String User = "system";
		String Pass = "orcl";
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(Url,User,Pass);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select username, password from users");
			
			String u = rs.getString(4);
			String p = rs.getString(5);
			
			con.close();
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		
		
		if(user.equals(request.getParameter("username")) && pass.equals(request.getParameter("password")) ){
			HttpSession session = request.getSession(true);
			
			request.setAttribute("message","Login Successfull");
			
			
			if(session!=null) {
				session.invalidate();
			}
			
		}
		
		else {
			request.setAttribute("message","Invalid login");		
			}
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
