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


@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RemoveServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String User = "system";
		String Pass = "orcl";
		
		String w = request.getParameter("removeWord");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(Url,User,Pass);
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select word from dictionary");
			
			TreeSet<String> word = new TreeSet<>();
			
			while(rs.next()) {
				word.add(rs.getString("word"));
				}
			
			if(word.contains(w)) {
				PreparedStatement ps = con.prepareStatement("delete from dictionary where word=?");
			
			ps.setString(1,w);
			int count = ps.executeUpdate();
			
			if(count>0) {
				request.setAttribute("msg", "word removed successfully");
			}
				
			}
			
			else {
				request.setAttribute("msg", "try again");
			}
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		
		request.getRequestDispatcher("Remove.jsp").forward(request,response);
	}
	
}

