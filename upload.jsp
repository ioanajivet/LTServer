<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload for the Learning Tracker - PreCalc </title>
</head>
<body>
    <center>
        <h1>File Upload for the Learning Tracker - PreCalc </h1>
        <form method="post" action="upload" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>CSV file: </td>
                    <td><input type="file" name="metrics"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>