package data;

import java.sql.*;
import java.util.ArrayList;
import business.Movie;
import business.Showtime;

public class MovieDB {
    
    public static int insert(Movie movie)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        try{

        String query = 
                "INSERT INTO movies (MovieID, movieName, description, ImageID) " +
                "VALUES (?, ?, ?, ?)";
        
            ps = connection.prepareStatement(query);
            ps.setString(1, movie.getID());
            ps.setString(2, movie.getName());
            ps.setString(3, movie.getDescription());
            ps.setString(4, movie.getNameOfImage());
            
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int update(Movie movie)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE movies SET " +
                "MovieID = ? " +
                "movieName = ?, " +
                "description = ?, " +
                "imageID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, movie.getID());
            ps.setString(2, movie.getName());
            ps.setString(3, movie.getDescription());
            ps.setString(4, movie.getNameOfImage());

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int delete(Movie movie)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM movies " +
                "WHERE MovieID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, movie.getID());

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
   public static boolean iDExists(String ID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT MovieID FROM movies " +
                "WHERE MovieID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static Movie selectMovie (String ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM movies " +
                       "WHERE MovieID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            Movie movie = null;
            if (rs.next())
            {
                movie = new Movie();
                movie.setID(rs.getString("MovieID"));
                movie.setName(rs.getString("movieName"));
                movie.setDescription(rs.getString("description"));
                movie.setNameOfImage(rs.getString("imageID"));
                
                
            }
            return movie;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Movie> selectMovies()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Movie movie = null;
        String query = "Select * FROM movies";
        ArrayList<Movie> movies = new ArrayList<Movie>();
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);
            while(rs.next()){
                movie = new Movie();
                movie.setID(rs.getString("MovieID"));
                movie.setName(rs.getString("movieName"));
                movie.setDescription(rs.getString("description"));
                movie.setNameOfImage(rs.getString("imageID"));
                movies.add(movie);               
            }
            return movies;
            
        }        
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
   public static ArrayList<Showtime> selectShowtime(String ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Showtime> showtimes = new ArrayList<Showtime>();
        
        String query = "SELECT show1, show2, show3, show4, show5, typeID  " +
                "FROM times WHERE movieID_F = ? ";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            Showtime showtime = null;
            while (rs.next()){
            
                showtime = new Showtime();
                showtime.setShow1(rs.getString("show1"));
                showtime.setShow2(rs.getString("show2"));
                showtime.setShow3(rs.getString("show3"));
                showtime.setShow4(rs.getString("show4"));
                showtime.setShow5(rs.getString("show5"));
                showtime.setType(rs.getString("typeID"));
                showtimes.add(showtime);               
            
            }
            return showtimes;
            
        }        
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}