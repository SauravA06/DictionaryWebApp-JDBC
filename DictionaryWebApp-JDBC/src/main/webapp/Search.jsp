<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="SearchServlet" method="post">
        <h2>Dictionary</h2>

        Enter the word you want to search

        <input type="text" name="searchWord" /><br>


        <br>
        <input type="submit" value="Search"> <input type="reset" value="Reset"><br>
        <br>

        <!-- <a href="DictionaryHome.jsp">Click here</a> to return Home page. -->

    </form>
    
     <%
		String s = (String)request.getAttribute("msg");
		if(s!=null){
				out.println(s);
		}
	%>
    
</body>
</html>