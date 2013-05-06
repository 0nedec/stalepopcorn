package business;

import java.io.Serializable;

public class Movie implements Serializable
{
    private String id;
    private String name;
    private String description;
    private String nameOfImage;
    
    public Movie()
    {
        id = "";
        name = "";
        description = "";
        nameOfImage = ""; 
    }
    
    public Movie( String ID, String movieName, String movieDescription, String movieImage) {
        
        id = ID;
        name = movieName;
        description = movieDescription;
        nameOfImage = movieImage;
        
    }
    
   
    public void setID(String ID) {
        this.id = ID;
    }
    
    public String getID() {
        return id;
    }
    
    public void setName(String n) {
        this.name = n;
    }

    public String getName() { 
        return name; 
    }
    
    public void setDescription(String d) {
        this.description = d;
    }
    
    public String getDescription() {
        return description;
    }

    public void setNameOfImage(String p) {
        this.nameOfImage = p;
    }
    
    public String getNameOfImage() { 
        return nameOfImage; 
    }
}
