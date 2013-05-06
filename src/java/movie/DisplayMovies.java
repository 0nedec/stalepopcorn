package movie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import business.Movie;
import data.MovieDB;
import java.util.HashSet;

public class DisplayMovies extends HttpServlet
{

    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        ArrayList<Movie> movies = MovieDB.selectMovies();                
        HttpSession session = request.getSession();
        session.setAttribute("movies", movies);
        

        String url = "/movies.jsp";
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