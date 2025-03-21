<%-- 
    Document   : insertSupplie
    Created on : Oct 14, 2024, 2:58:07 PM
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
        <form action="SupplierURL" method="post">
            <input type="hidden" name="service" value="insertSupplier">
            <table>
                <tr>
                    <td><label for="SupplierID">SupplierID</label></td>
                    <td><input type="text" name="SupplierID" id="SupplierID" ></td>
                </tr>
                <tr>
                    <td><label for="CompanyName">CompanyName</label></td>
                    <td><input type="text" name="CompanyName" id="CompanyName"></td>
                </tr>
                <tr>
                    <td><label for="ContactName">ContactName</label></td>
                    <td><input type="text" name="ContactName" id="ContactName" ></td>
                </tr>
                <tr>
                    <td><label for="ContactTitle">ContactTitle</label></td>
                    <td><input type="text" name="ContactTitle" id="ContactTitle"></td>
                </tr>
                <tr>
                    <td><label for="Address">Address</label></td>
                    <td><input type="text" name="Address" id="Address" ></td>
                </tr>
                <tr>
                    <td><label for="City">City</label></td>
                    <td><input type="text" name="City" id="City"></td>
                </tr>
                <tr>
                    <td><label for="Region">Region</label></td>
                    <td><input type="text" name="Region" id="Region" ></td>
                </tr>
                <tr>
                    <td><label for="PostalCode">PostalCode</label></td>
                    <td><input type="text" name="PostalCode" id="PostalCode"></td>
                </tr>
                <tr>
                    <td><label for="Country">Country</label></td>
                    <td><input type="text" name="Country" id="Country" ></td>
                </tr>
                <tr>
                    <td><label for="Phone">Phone</label></td>
                    <td><input type="text" name="Phone" id="Phone"></td>
                </tr>
                <tr>
                    <td><label for="Fax">Fax</label></td>
                    <td><input type="text" name="Fax" id="Fax" ></td>
                </tr>
                <tr>
                    <td><label for="HomePage">HomePage</label></td>
                    <td><input type="text" name="HomePage" id="HomePage"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="insertSupplier" name="submit"></td>
                    <td><input type="reset" name="clear" ></td>
                </tr>
            </table>
    </body>
</html>
