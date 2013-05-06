package movie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import business.Showtime;
import business.Movie;
import data.MovieDB;
import java.util.HashSet;

public class DisplayTimesServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        String movieID = String.valueOf(request.getParameter("movie"));
        
        ArrayList<Showtime> showtimes = MovieDB.selectShowtime(movieID);                
        HttpSession session = request.getSession();
        session.setAttribute("showtimes", showtimes);
        Movie movie = new Movie();
        movie = MovieDB.selectMovie(movieID);
        
        session.setAttribute("movie", movie);
        
        String url = "/DisplayMovies.jsp";
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