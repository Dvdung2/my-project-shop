<%-- 
    Document   : Login
    Created on : Oct 18, 2024, 12:57:56 PM
    Author     : dvdung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%String error=(String)request.getAttribute("error");%>
        <%=(error!=null?error:"")%>
         <form action="CustomerURL" method="post">
            <input type="hidden" name="service" value="loginCustomer">
            <table>
                <caption>Login</caption>
                <tr>
                    <td><label for="username">username</label></td>
                    <td><input type="text" name="username" id="username" required></td>
                </tr>
                <tr>
                    <td><label for="password">password</label></td>
                    <td><input type="password" name="password" id="password" required></td>
                </tr>
                <tr>
                    <td><input type="submit" value="login" name="submit"></td>
                    <td><input type="reset" name="clear" ></td>
                </tr>
            </table>
    </body>
</html>
