<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        th {
            font-size: larger;
        }
        
        p {
            font-size: large;
        }
    </style>
</head>

<body>
    <h1 id="l1"> Registration Form </h1>
    <p id="l1">Please enter your details below</p><br>

    <form action="RegistrationServlet" method="post">

        <label for="name">Name:</label><br>
        <input type="text" name="fname" id="" placeholder="Enter full name" /><br><br>

        <label for="email">Email:</label><br>
        <input type="email" name="email" id="" placeholder="johndoe@abc.com" /><br><br>
        
        <label for="phone">Contact No.:</label><br>
        <input type="text" name="phone" id=""/><br><br>

		<label for="username">Username:</label><br>
        <input type="text" name="username" id="" /><br><br>

        <label for="password">Password:</label><br>
        <input type="password" name="password" id="" /><br><br>

        <input type="submit" value="Register"/> &nbsp; &nbsp; Already an user? <a href="Login.jsp">Click here</a> to login.

    </form>
</body>

</html>