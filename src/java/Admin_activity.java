/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KAUSHIK
 */
public class Admin_activity extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Admin_activity</title>");            
            out.println("</head>");
            out.println("<body  background='12.jpg' >");
            HttpSession session=request.getSession();
            if(session.getAttribute("aid")==null)
            {response.sendRedirect("Admin.html");}
            out.println("<center>");
            out.println("<h1>");
            out.println("<b>");
            out.println("Welcome to admins' activity page");
            out.println("</b>");
            out.println("</h1>");
      // out.println("<br><b><a href='create_schedule.html'>Want to create shedule?...click here</a></b>");
      // out.println("<br><b><a href='View_schedule'>Want to view shedule?...click here</a></b>");
            out.println("<form action='' method='post'>");
            out.println("<input type='submit' value='Create shedule' name='a'><br><br>");
            out.println("<input type='submit' value='View shedule' name='b'><br><br>");
            out.println("<input type='submit' value='Request change' name='c'>");
            out.println("<input type='submit' value='Log out' name='d'>");
            out.println("</form>");
            out.println("</center>");
            
    
           // out.println("<h1>Servlet Admin_activity at " + request.getContextPath() + "</h1>");*/
            out.println("</body>");
            out.println("</html>");
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
       // processRequest(request, response);
      

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
            String s1=request.getParameter("a");
            String s2=request.getParameter("b");
            String s3=request.getParameter("d");
            if (s1!=null){
               response.sendRedirect("create_schedule.html");
            }
            else if(s2!=null){
                    response.sendRedirect("View_schedule");
           }
          else if(s3!=null){
                       HttpSession session=request.getSession();
                       session.removeAttribute("aid");
                       session.invalidate();
                       response.sendRedirect("Admin.html");
          }
}
}
