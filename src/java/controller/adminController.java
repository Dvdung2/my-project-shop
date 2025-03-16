/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customers;
import entity.Employees;
import entity.Orders;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.DAOCustomers;
import model.DAOEmployees;
import model.DAOOrderDetails;
import model.DAOrders;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author dvdung
 */
@WebServlet(name = "adminController", urlPatterns = {"/admin"})
public class adminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        DAOEmployees dao = new DAOEmployees();
        DAOrders dao1 = new DAOrders();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if (service.equals("details")) {

            }
            if (service.equals("admin")) {
                ResultSet rsC = dao1.getData("select CustomerID, ContactName from Customers");
                HashMap<Integer, String> hsC = new HashMap<>();
                try {
                    while (rsC.next()) {
                        hsC.put(rsC.getInt(1), rsC.getString(2));
                    }
                } catch (Exception e) {
                }
                Vector<Orders> vectorOrd;
                request.setAttribute("hsC", hsC);
                if (session.getAttribute("Employee") != null) {
                    Employees emp = (Employees) session.getAttribute("Employee");
                    vectorOrd = dao1.getOrders("select*from Orders where EmployeeID=" + emp.getEmployeeID());
                } else {
                    vectorOrd = dao1.getOrders("select*from Orders");
                }
                String submit = request.getParameter("submit");
                String sql = "";
                if (submit == null) {
                    sql = "select*from Orders";
                } else {
                    int order = Integer.parseInt(request.getParameter("order"));
                    sql = "select*from Orders where OrderID=" + order;
                }
                Vector<Orders> vector = dao1.getOrders(sql);
                request.setAttribute("listOrder", vector);
                request.setAttribute("titleTable", "list of order");
                request.setAttribute("vectorOrd", vectorOrd);
                request.setAttribute("rsC", rsC);
                request.getRequestDispatcher("/view/admin.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
