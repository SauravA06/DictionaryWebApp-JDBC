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

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String User = "system";
		String Pass = "orcl";
		
		String w = request.getParameter("searchWord");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(Url, User, Pass);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from dictionary");
			
			TreeSet<String> word = new TreeSet<>();
			TreeSet<String> meaning = new TreeSet<>();
			
			while(rs.next()) {
				word.add(rs.getString("word"));
				meaning.add(rs.getString("meaning"));
			}
			
			if(word.contains(w)) {
				PreparedStatement ps = con.prepareStatement("select meaning from dictionary where word =?");
				
				ps.setString(1, w);
				
				ResultSet rs1 = ps.executeQuery();
				
				if(rs1.next()) {
					
					request.setAttribute("msg",rs1.getString("meaning"));
				}
				
				
			}
			else{
				request.setAttribute("msg","Word not found");
			}
		
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Search.jsp").forward(request, response);
		
	}
}
