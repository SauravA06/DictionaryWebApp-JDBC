<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddServlet" method="post">
		<h2>Dictionary</h2>

        Enter the word and its meaning you want to add <br><br> 
        Word
        <input type="text" name="addWord" /><br> <br>
        Meaning
        <input type="text" name="addMeaning" />

        <br><br>
        <input type="submit" value="Add"><br><br>

        <a href="Search.jsp">Click here</a> to check.
     </form>
     
     <%
		String s = (String)request.getAttribute("msg");
		if(s!=null){
				out.println(s);
		}
	%>
	
</body>
</html>