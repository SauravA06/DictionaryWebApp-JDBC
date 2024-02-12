<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
    <h1> Login</h1>


    <form action="LoginServlet" method="post">

        <label for="username">Username:</label><br>
        <input type="text" name="username" /><br><br>

        <label for="password">Password</label><br>
        <input type="password" name="password" /><br><br>

        <input type="submit" value="Login" />

    </form>
    <br><br>
    
    <%
		String s = (String)request.getAttribute("message");
		if(s!=null){
				out.println(s);
		}
	%>
</body>

</html>