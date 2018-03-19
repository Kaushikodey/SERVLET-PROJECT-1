/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KAUSHIK
 */
public class Create_schedule extends HttpServlet {

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
            out.println("<title>Servlet Create_schedule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Create_schedule at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
         HttpSession session=request.getSession();
        if(session.getAttribute("aid")==null)
            {response.sendRedirect("Admin.html");}
        PrintWriter out=response.getWriter();
          out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Create_schedule</title>");            
            out.println("</head>");
            out.println("<body>");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            //2. Create a connection
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
           
            //3. Create a statement class object            
            Statement st=con.createStatement();
                   
            //4. Write the query
            String sql="INSERT INTO scheduling VALUES('"+request.getParameter("id")+"','"+request.getParameter("date")+"','"+request.getParameter("slot")+"','"+request.getParameter("time")+"')";
             
            //5. execute the query
            st.executeUpdate(sql);
            con.close();
            out.println("<h3>Data Added successfully</h3>");
            out.println("<form action='Admin_activity.html'>");
            out.println("<br><br><input type='submit' value='Return to previous page'>");
            out.println("</form>");
           
        }
        catch(Exception e){}
            out.println("</body>");
            out.println("</html>");
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
