/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.products.Cart;
import sample.products.ProductCart;
import sample.products.ProductDAO;
import sample.products.ProductDTO;
import sample.products.ProductPayment;

/**
 *
 * @author MSI AD
 */
public class AddController extends HttpServlet {

    private static final String ERROR = "shoping-cart.jsp";
    private static final String SUCCESS = "checkout.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkInsert = false;
        try {
            String email = request.getParameter("email");
            String proName = "";
            float price = 0;
            int i = 1;
            int quantity = 0;
            ProductDAO dao = new ProductDAO();
            List<ProductCart> proCart = new ArrayList<ProductCart>();
//            Cookie[] cookies = request.getCookies();
//            for (Cookie cookie : cookies) {
//                if (!cookie.getName().equals("JSESSIONID")) {
//                    String proId = cookie.getName();
//                    proCart = dao.getViewProduct(proId);
//                    for (ProductCart pc : proCart) {
//                        i++;
//                        proName = pc.getProName();
//                        price = pc.getPrice();
//                        quantity = Integer.parseInt(request.getParameter("quantity" + i));
//                        float total = price * quantity;
//                        ProductPayment pp = new ProductPayment(email, proName, price, quantity, total,"false");
//                        checkInsert = dao.storeProduct(pp);
//                        if (checkInsert == true) {
//                            url = SUCCESS;
//                        }
//                    }
//                }
//            }
            HttpSession session = request.getSession();
            Cart proID = (Cart) session.getAttribute("PROID_CART");
            Map<String, Integer> products = proID.getProID();
            if (proID != null) {
                for (Map.Entry product : products.entrySet()) {
                    List<ProductDTO> pro = dao.getTypeProduct((String)product.getKey());
                    for (ProductDTO p : pro) {
                        i++;
                        proName = p.getProName();
                        price = p.getPrice();
                        quantity = Integer.parseInt(request.getParameter("quantity" + i));
                        float total = price * quantity;
                        ProductPayment pp = new ProductPayment(email, proName, price, quantity, total, "false");
                        checkInsert = dao.storeProduct(pp);
                        if (checkInsert == true) {
                            url = SUCCESS;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("ERROR at AddController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
