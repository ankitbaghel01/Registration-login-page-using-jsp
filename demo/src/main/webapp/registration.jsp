<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<form action="regForm" method="post">
        Name: <input type="text" name="name" /><br/>
        Email: <input type="text" name="email" /><br/>
        Password: <input type="password" name="password" /><br/>
        Gender:
        <input type="radio" name="gender" value="Male">Male
        <input type="radio" name="gender" value="Female">Female<br/>
        City:
        <select name="city">
            <option value="Select city">Select city</option>
            <option value="Delhi">Delhi</option>
            <option value="Mumbai">Mumbai</option>
            <option value="Pune">Pune</option>
        </select>
        <input type="submit" value="Register" />
    </form>
</body>
</html>
