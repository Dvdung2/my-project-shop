<%-- 
    Document   : insertOrder
    Created on : Oct 8, 2024, 5:20:36 PM
    Author     : dvdung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet,entity.Customers" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <%
      ResultSet rsCus= (ResultSet)request.getAttribute("rsCus");
      ResultSet rsEm= (ResultSet)request.getAttribute("rsEm");
      ResultSet rsSh= (ResultSet)request.getAttribute("rsSh");
      Customers customer=(Customers)session.getAttribute("customer");
    %>
    <body>
        <form action="OrderURL" method="post">
            <input type="hidden" name="service" value="insertOrder"> 
            <table>
                <tr>
                    <td><label for="OrderID">OrderID</label></td>
                    <td><input type="text" name="OrderID" id="OrderID" readonly></td>
                </tr>
                <tr>
                    <td><label for="CustomerID">CustomerID</label></td>
                <td><input type="text" name="CustomerID" id="CustomerID" value="<%=customer.getCustomerID()%>" readonly ></td>
                </tr>
                <tr>
                    <td><label for="EmployeeID">EmployeeID</label></td>
                <td>
                    <select name="EmployeeID" id="EmployeeID">
                        <%while(rsEm.next()){%>
                        <option value="<%=rsEm.getInt(1)%>"><%=rsEm.getString(2)%></option>
                        <%}%>
                    </select>
                </td>
                </tr>
                <tr>
                    <td><label for="OrderDate">OrderDate</label></td>
                    <td><input type="text" name="OrderDate" id="OrderDate"></td>
                </tr>
                <tr>
                    <td><label for="RequiredDate">RequiredDate</label></td>
                    <td><input type="text" name="RequiredDate" id="RequiredDate" ></td>
                </tr>
                <tr>
                    <td><label for="ShippedDate">ShippedDate</label></td>
                    <td><input type="text" name="ShippedDate" id="ShippedDate"></td>
                </tr>
                <tr>
                    <td><label for="ShipVia">ShipVia</label></td>
                <td>
                    <select name="ShipVia" id="ShipVia">
                        <%while(rsSh.next()){%>
                        <option value="<%=rsSh.getInt(1)%>"><%=rsSh.getString(2)%></option>
                        <%}%>
                    </select>
                </td>
                </tr>
                <tr>
                    <td><label for="Freight">Freight</label></td>
                    <td><input type="text" name="Freight" id="Freight"></td>
                </tr>
                <tr>
                    <td><label for="ShipName">ShipName</label></td>
                    <td><input type="text" name="ShipName" id="ShipName" ></td>
                </tr>
                <tr>
                    <td><label for="ShipAddress">ShipAddress</label></td>
                    <td><input type="text" name="ShipAddress" id="ShipAddress" value="<%=customer.getAddress()%>"></td>
                </tr>
                <tr>
                    <td><label for="ShipCity">ShipCity</label></td>
                    <td><input type="text" name="ShipCity" id="ShipCity" value="<%=customer.getCity()%>"></td>
                </tr>
                <tr>
                    <td><label for="ShipRegion">ShipRegion</label></td>
                    <td><input type="text" name="ShipRegion" id="ShipRegion" value="<%=customer.getRegion()%>"></td>
                </tr>
                <tr>
                    <td><label for="ShipPostalCode">ShipPostalCode</label></td>
                    <td><input type="text" name="ShipPostalCode" id="ShipPostalCode" value="<%=customer.getPostalCode()%>"></td>
                </tr>
                <tr>
                    <td><label for="ShipCountry">ShipCountry</label></td>
                    <td><input type="text" name="ShipCountry" id="ShipCountry" value="<%=customer.getCountry()%>"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="checkout" name="submit"></td>
                    <td><input type="reset" name="clear" ></td>
                </tr>
            </table>
        </form>
    </body>
</html>
