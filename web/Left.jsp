

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Product,entity.Suppliers,entity.Customers,java.sql.ResultSet" %>
            <%
            ResultSet rsCat= (ResultSet)request.getAttribute("rsCat");
            ResultSet rsSup= (ResultSet)request.getAttribute("rsSup");
        %>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <%while(rsCat.next()) {%>
            <tr>
                <li class="list-group-item text-white"><a href="ProductURL?service=listAllProducts&cid=<%=rsCat.getInt(1)%>"><%=rsCat.getString(2)%></a></li>
            </tr>
            <%}%>
        </ul>
    </div>
        <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <%while(rsSup.next()) {%>
                    <tr>
                        <li class="list-group-item text-white"><a href="ProductURL?service=listAllProducts&cid=<%=rsSup.getInt(1)%>"><%=rsSup.getString(2)%></a></li>
                    </tr>
                    <%}%>
        </ul>
    </div>
</div>