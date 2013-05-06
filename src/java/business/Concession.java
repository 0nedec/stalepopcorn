package business;

import java.io.Serializable;

public class Concession implements Serializable {
    
    private int conID;
    private String conName;
    private double conPrice;
    
    
    public Concession() {
        conID = -1;
        conName = "";
        conPrice = 0.0;
        
    }
    
    public Concession(int idNumber, String name, double price) {
        conID = idNumber;
        conName = name;
        conPrice = price;              
    }
    
    public void setID(int i) {
        conID = i;
    }
    
    public int getID(){
        return conID;
    }
    
    public void setConName(String n) {
        conName = n;
    }
    
    public String getConName() {
        return conName;
    }
    
    public void setConPrice (double d ) {
        conPrice = d;
    }
    
    public double getConPrice() {
        return conPrice;
    }
}