/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KAUSHIK
 */
public class Insert extends HttpServlet {

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
            out.println("<title>Servlet Insert</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Insert at " + request.getContextPath() + "</h1>");
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
       boolean f=true;
        PrintWriter out = response.getWriter();
         out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet firstservlet</title>");
                out.println("</head>");
                out.println("<body>");
        try {
            //1 Register jdbc driver            
            Class.forName("com.mysql.jdbc.Driver");
            
            //2. Create a connection
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
           
            //3. Create a statement class object            
            Statement st=con.createStatement();
                   
            //4. Write the query
            String q="select * from user";
            ResultSet rs = st.executeQuery(q);
            
            while(rs.next())
            {
                String s1=rs.getString("uid");
                if (s1.equals(request.getParameter("uid")))
                {
                    f=false;
                    response.sendRedirect("Duplicate.html");
                }
                
            }
            
            if(f){
               
                String sql="INSERT INTO user VALUES('"+request.getParameter("uid")+"','"+request.getParameter("name")+"','"+request.getParameter("mail")+"','"+request.getParameter("phone")+"','"+request.getParameter("age")+"','"+request.getParameter("sex")+"','"+request.getParameter("pass")+"')";
            
            //5. execute the query
               st.executeUpdate(sql);
            }
            else{
                out.println("Give unique user id");
            }
            con.close();
            response.sendRedirect("User_login.html");
        }
        catch(Exception e)
        {
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
