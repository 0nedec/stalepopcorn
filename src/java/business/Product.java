
package business;

import java.io.Serializable;
import business.Movie;
import business.Showtime;
import business.Concession;
import java.util.HashSet;
import java.text.NumberFormat;       
public class Product implements Serializable{
    
    private String name;
    private double price;
    
public Product() {
    name = "";
    price = 0.0;
}    

public Product(String n, double p){
    name = n;
    price = p;
}

public void setName(String n){
    name = n;
}

public String getName() {
    return name;
}

public void setPrice(double p) {
    price = p;
}
    
public double getPrice() {
   return price;
}

public static Product concessionToProduct(Concession concession){
    Product product = new Product();
    product.name = concession.getConName();
    product.price = concession.getConPrice();
    
    return product;
}

public static Product movieToProduct(String movie, String showtime, String type){
    Product product = new Product();
    String ticketNameOfMovie, ticketType;
    double ticketPrice = 0.0;
    if ("111".equals(type)){
        ticketType = "3D";
        ticketPrice = 13.5;
    }
    else if("222".equals(type)){
        ticketType = "IMAX";
        ticketPrice = 18;
    }
    else {
        ticketType = "Normal";
        ticketPrice = 9.5;
    }
    
    ticketNameOfMovie =""+ movie+" "+ticketType+" "+showtime+"";
    product.setName(ticketNameOfMovie);
    product.setPrice(ticketPrice);
    return product;
}

public String getCode(){
    return name;
}
 
public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
public String getDescription(){
    return name;
}

}