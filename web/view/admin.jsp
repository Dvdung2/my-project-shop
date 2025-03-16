<%-- 
    Document   : admin
    Created on : Nov 1, 2024, 3:02:50 PM
    Author     : dvdung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Employees,java.sql.ResultSet,java.util.Vector,entity.Orders,java.util.HashMap" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Employees emp=(Employees)session.getAttribute("Employee");
        Vector<Orders> vectorOrd=(Vector<Orders>)request.getAttribute("vectorOrd");
        ResultSet rsC=(ResultSet)request.getAttribute("rsC");
        HashMap<Integer, String> hsC =(HashMap<Integer, String>)request.getAttribute("hsC");
        Vector<Orders> vector=(Vector<Orders>)request.getAttribute("listOrder");
        %>
        <div>
            <h1 align="right">
                <%if(emp==null){%>
                <%}else{%>
                <%="welcome boy "+emp.getLastName()%>
                <%}%>
            </h1>
        </div>
        <div style="display: flex; justify-content: center; gap: 10%; font-size: 150%">
            <%if(emp==null){%>
            <a href="EmployeeURL?service=loginEmployee" >login</a>
            <%}else{%>
            <a href="EmployeeURL?service=logoutEmployee" >log out</a>
            <%}%>
        </div>
        <p><a href="CustomerURL?service=AllCustomer">Customer Manager</a>
        <p><a href="ProductURL?service=listAllProducts">Product Manager</a>
        <table border=1>
            <tr>
                <th>OrderID</th>
                <th>CustomerID</th>
                <th>EmployeeID</th>
                <th>OrderDate</th>
                <th>RequiredDate</th>
                <th>ShippedDate</th>
                <th>ShipVia</th>
                <th>Freight</th>
                <th>ShipName</th>
                <th>ShipAddress</th>
                <th>ShipCity</th>
                <th>ShipRegion</th>
                <th>ShipPostalCode</th>
                <th>ShipCountry</th>
                <th>Status</th>
                <th>Detail</th>
            </tr>
            <%for (Orders ord : vectorOrd) {%>
            <tr>
                <td><%=ord.getOrderID()%></td>
                <td><%=ord.getCustomerID()%></td>
                <td><%=ord.getEmployeeID()%></td>
                <td><%=ord.getOrderDate()%></td>
                <td><%=ord.getRequiredDate()%></td>
                <td><%=ord.getShippedDate()%></td>
                <td><%=ord.getShipVia()%></td>
                <td><%=ord.getFreight()%></td>
                <td><%=ord.getShipName()%></td>
                <td><%=ord.getShipAddress()%></td>
                <td><%=ord.getShipCity()%></td>
                <td><%=ord.getShipRegion()%></td>
                <td><%=ord.getShipPostalCode()%></td>
                <td><%=ord.getShipCountry()%></td>
                <td><%=(ord.isStatus() == true ? "Continue" : "Discontinue")%></td>
                <td><a href="detail&oid=<%=ord.getOrderID()%>">detail</a></td>
            </tr>
            <%}%>
    </body>
</html>
