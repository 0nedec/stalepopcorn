package movie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.Concession;
import data.ConcessionDB;
import java.util.ArrayList;
import business.Movie;
import data.MovieDB;
import java.util.HashSet;

public class DisplayConcessionServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        ArrayList<Concession> concessions = ConcessionDB.selectConcessions();                
        HttpSession session = request.getSession();
        session.setAttribute("concessions", concessions);
        
        String url = "/DisplayConcessions.jsp";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        doGet(request, response);
    }    
}