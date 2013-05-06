/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.*;
import data.*;
import java.util.ArrayList;
/**
 *
 * @author X220
 */
public class DisplayAdminConcessionServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        ArrayList<Concession> concessions = ConcessionDB.selectConcessions();                
        HttpSession session = request.getSession();
        session.setAttribute("concessions", concessions);
        
        String url = "/ConcessionAdminApplication.jsp";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        doGet(request, response);
    }    

}
