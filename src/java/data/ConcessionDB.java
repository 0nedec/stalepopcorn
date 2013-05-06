package data;

import java.sql.*;
import java.util.ArrayList;
import business.Movie;
import business.Concession;
import business.Showtime;

public class ConcessionDB {
    
  
    public static Concession selectConcession (String ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM candy" +
                        "WHERE cName = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            Concession concession = null;
            if (rs.next())
            {
                concession = new Concession();
                concession.setConName(rs.getString("cName"));
                concession.setConPrice(rs.getDouble("cPrice"));

                
                
            }
            return concession;
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

    public static ArrayList<Concession> selectConcessions()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Concession concession = null;
        String query = "Select * FROM candy";
        ArrayList<Concession>concessions = new ArrayList<Concession>();
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);
            while(rs.next()){
                concession = new Concession();
                concession.setConName(rs.getString("cName"));
                concession.setConPrice(rs.getDouble("cPrice"));

                concessions.add(concession);               
            }
            return concessions;
            
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