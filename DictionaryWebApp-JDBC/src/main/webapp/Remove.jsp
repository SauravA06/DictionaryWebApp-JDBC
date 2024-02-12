<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RemoveServlet" method="post">
		<h2>Dictionary</h2>

        Enter the word you want to remove <br><br><input type="text" name="removeWord" />
        <br><br>
        <input type="submit" value="Remove"> <br><br>
        
                <a href="DictionaryHome.jsp">Click here </a>to return Home page. 
        
     </form>
     <br><br>
     
      <%
		String s = (String)request.getAttribute("msg");
		if(s!=null){
				out.println(s);
		}
	%>
</body>
</html>