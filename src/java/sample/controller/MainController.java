/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSI AD
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SIGNIN = "Sign in";
    private static final String SIGNIN_CONTROLLER = "SignInController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogOutController";
    private static final String SIGNUP = "Sign up";
    private static final String SIGNUP_CONTROLLER = "SignUpController";
    private static final String ADD_COOKIE = "Cookie";
    private static final String ADD_COOKIE_CONTROLLER = "AddCookieController";
    private static final String DETAIL = "ViewDetail";
    private static final String DETAIL_CONTROLLER = "ViewDetailController";
    private static final String ADD = "Payment";
    private static final String ADD_CONTROLLER = "AddController";
    private static final String FILTER = "Filter";
    private static final String FILTER_CONTROLLER = "FilterController";
    private static final String REMOVE = "RemoveCookie";
    private static final String REMOVE_CONTROLLER = "RemoveCookieController";
    private static final String ORDER = "PLACE ORDER";
     private static final String ORDER_CONTROLLER = "OrderController";
     private static final String SEARCH = "Search";
     private static final String SEARCH_CONTROLLER = "SearchController";
     private static final String PAGE = "Next";
     private static final String PAGE_CONTROLLER = "shop-grid.jsp";
     private static final String CREATE = "Create";
     private static final String CREATE_CONTROLLER = "CreateController";
    private static final String UPDATE = "Update";
    private static final String UPDATE_CONTROLLER = "UpdateController";
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "DeleteController";
      

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (SIGNIN.equals(action)) {
                url = SIGNIN_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (SIGNUP.equals(action)) {
                url = SIGNUP_CONTROLLER;
            } else if (ADD_COOKIE.equals(action)) {
                url = ADD_COOKIE_CONTROLLER;
            } else if (DETAIL.equals(action)) {
                url = DETAIL_CONTROLLER;
            } else if (ADD.equals(action)) {
                url = ADD_CONTROLLER;
            } else if (FILTER.equals(action)) {
                url = FILTER_CONTROLLER;
            } else if (REMOVE.equals(action)) {
                url = REMOVE_CONTROLLER;
            }else if (ORDER.equals(action)) {
                url = ORDER_CONTROLLER;
            }else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            }else if (PAGE.equals(action)) {
                url = PAGE_CONTROLLER;
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            }else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            }else {
                request.setAttribute("ERROR", "Your action is not supported!");
            }
        } catch (Exception e) {
            log("Error at: MainController" + e.toString());
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
