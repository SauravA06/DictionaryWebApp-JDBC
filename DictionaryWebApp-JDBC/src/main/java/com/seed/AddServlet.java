package com.seed;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String User = "system";
		String Pass = "orcl";
		
		String w = request.getParameter("addWord");
		String m = request.getParameter("addMeaning");
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(Url,User,Pass);
			
			PreparedStatement st = con.prepareStatement("insert into dictionary(word, meaning) values(?,?)");
			
			st.setString(1, w);
			st.setString(2, m);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				
				request.setAttribute("msg", "added successfully");
				
			}
			
			else {
				request.setAttribute("msg", "Something went wrong, please try again.");
			}
				
			
			//response.getWriter().println("added successfully");
			
			
			con.close();

		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Add.jsp").forward(request, response);
		
	}

}
