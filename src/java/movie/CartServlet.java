package movie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.*;
import data.*;

/**
 *
 * @author Joel Murach
 * @version
 */
public class CartServlet extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequestMovies(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String quantityAsString = request.getParameter("quantity");
        
        HttpSession session = request.getSession();
        
        synchronized(session)
        {
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null)
            {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            
            //if the user enters a negative or invalid quantity,
            //the quantity is automatically reset to 1.
            int quantity = 1;
            try
            {
                quantity = Integer.parseInt(quantityAsString);
                if (quantity < 0)
                    quantity = 1;
            }
            catch(NumberFormatException nfe)
            {
                quantity = 1;
            }
            
            
            String movieName = (String) request.getParameter("Movie");
            System.out.println(movieName);
            String showtime = (String) request.getParameter("Showtime");
            System.out.println(showtime);
            String type = (String) request.getParameter("Type");
            System.out.println(type);
            Product product = Product.movieToProduct(movieName, showtime, type);

            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            if (quantity > 0)
                cart.addItem(lineItem);
            else if (quantity <= 0)
                cart.removeItem(lineItem);

            session.setAttribute("cart", cart);
        }
                       
        String url = "/cart.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequestMovies(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequestConcession(request, response);
    }
    
     protected void processRequestConcession (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String quantityAsString = request.getParameter("quantity");
        
        HttpSession session = request.getSession();
        
        synchronized(session)
        {
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null)
            {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            
            //if the user enters a negative or invalid quantity,
            //the quantity is automatically reset to 1.
            int quantity = 1;
            try
            {
                quantity = Integer.parseInt(quantityAsString);
                if (quantity < 0)
                    quantity = 1;
            }
            catch(NumberFormatException nfe)
            {
                quantity = 1;
            }
            
            Concession concession = new Concession();
            String concessionName = (String) request.getParameter("ConcessionName");
            String concessionPriceString = (String) request.getParameter("ConcessionPrice");
            double concessionPrice = Double.parseDouble(concessionPriceString);
            concession.setConName(concessionName);
            concession.setConPrice(concessionPrice);
            Product product = Product.concessionToProduct(concession);

            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            if (quantity > 0)
                cart.addItem(lineItem);
            else if (quantity <= 0)
                cart.removeItem(lineItem);

            session.setAttribute("cart", cart);
        }
                       
        String url = "/cart.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo()
    {
        return "Short description";
    }
    // </editor-fold>
}
