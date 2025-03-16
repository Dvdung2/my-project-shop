/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOCart;
import entity.Cart;
import entity.Customers;
import entity.OrderDetails;
import entity.Orders;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import model.DAOrders;
import model.DAOOrderDetails;

/**
 *
 * @author dvdung
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartURL"})
public class CartController extends HttpServlet {

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
        DAOCart dao = new DAOCart();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if (service.equals("add2Cart")) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                if (session.getAttribute(pid + "") == null) {
                    Cart newCart = dao.getCart(pid);
                    newCart.setQuantity(1);
                    session.setAttribute(pid + "", newCart);
                } else {
                    Cart oldCart = (Cart) session.getAttribute(pid + "");
                    oldCart.setQuantity(oldCart.getQuantity() + 1);
                    session.setAttribute(pid + "", oldCart);
                }
                response.sendRedirect("ProductURL?service=listAllProducts");
            }
            if (service.equals("increase")) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Cart cart = (Cart) session.getAttribute(pid+"");
                cart.setQuantity((cart.getQuantity()+1));
                session.setAttribute(pid+"",cart);
                response.sendRedirect("CartURL?service=showCart");
            }
            if (service.equals("decrease")) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Cart cart = (Cart) session.getAttribute(pid+"");
                cart.setQuantity((cart.getQuantity()-1));
                session.setAttribute(pid+"",cart);
                response.sendRedirect("CartURL?service=showCart");
            }
            if (service.equals("showCart")) {
                Double sum = 0.0;
                Vector<Cart> vector = new Vector<Cart>();
                Enumeration enu = session.getAttributeNames();
                while (enu.hasMoreElements()) {
                    String pid = (String) enu.nextElement();
                    if ((!pid.equalsIgnoreCase("customer")) && (!pid.equalsIgnoreCase("Employee"))) {
                        Cart cart = (Cart) session.getAttribute(pid);
                        vector.add(cart);
                    }
                }
                for (Cart cart : vector) {
                    sum = sum + (cart.getQuantity() * cart.getUnitPrice()) - cart.getDiscount() * (cart.getQuantity() * cart.getUnitPrice());
                }
                request.setAttribute("sum", sum);
                request.setAttribute("vectorCart", vector);
                request.getRequestDispatcher("/Cart.jsp").forward(request, response);
            }
            if (service.equals("removeCart")) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                session.removeAttribute(pid + "");
                response.sendRedirect("CartURL?service=showCart");
            }
            if (service.equals("removeAllCart")) {
                Vector<Cart> vector = new Vector<Cart>();
                Enumeration enu = session.getAttributeNames();
                while (enu.hasMoreElements()) {
                    String pid = (String) enu.nextElement();
                    if ((!pid.equalsIgnoreCase("customer")) && (!pid.equalsIgnoreCase("Employee"))) {
                        Cart cart = (Cart) session.getAttribute(pid);
                        vector.add(cart);
                    }
                }
                for (Cart cart : vector) {
                    session.removeAttribute(cart.getProductID() + "");
                }
                response.sendRedirect("CartURL?service=showCart");
            }
            if(service.equals("checkout")){
                DAOrders dao1= new DAOrders();
                DAOOrderDetails dao2= new DAOOrderDetails();
                Vector<Cart> vector = new Vector<Cart>();
                Enumeration enu = session.getAttributeNames();
                while (enu.hasMoreElements()) {
                    String pid = (String) enu.nextElement();
                    if (!pid.equalsIgnoreCase("customer") && !pid.equalsIgnoreCase("Employee")) {
                        Cart cart = (Cart) session.getAttribute(pid);
                        vector.add(cart);
                    }
                }
                Vector<Orders> vectorOrd=dao1.getOrders("select top 1 *from Orders order by OrderID DESC");
                Orders ord=vectorOrd.get(0);
                for (Cart cart : vector) {
                    dao2.insertOrderDetails(new OrderDetails(ord.getOrderID(), cart.getProductID(), cart.getUnitPrice(), cart.getQuantity(), cart.getDiscount()));
                }
                response.sendRedirect("client");
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
