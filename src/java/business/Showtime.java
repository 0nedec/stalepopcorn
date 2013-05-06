/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import java.io.Serializable;

public class Showtime implements Serializable {
    
    private String show1;
    private String show2;
    private String show3;
    private String show4;
    private String show5;
    private String type;
    
    public Showtime() {
        show1 = "";
        show2 = "";
        show3 = "";
        show4 = "";
        show5 = "";
        type = "";
    }
    
    public Showtime(String sh1, String sh2, String sh3, String sh4, String sh5, String ty) {
        
        show1 = sh1;
        show2 = sh2;
        show3 = sh3;
        show4 = sh4;
        show5 = sh5;
        type = ty;
        
        
    }
    
    public void setShow1(String sh1) {
        show1 = sh1;
    }
    public String getShow1() {
        return show1;
    }
    public void setShow2(String sh2) {
        show2 = sh2;
    }
    public String getShow2() {
        return show2;
    }
    public void setShow3(String sh3) {
        show3 = sh3;
    }
    public String getShow3() {
        return show3;
    }
    public void setShow4(String sh4) {
        show4 = sh4;
    }
    public String getShow4() {
        return show4;
    }
    public void setShow5(String sh5) {
        show5 = sh5;
    }
    public String getShow5() {
        return show5;
    }
    public void setType(String ty) {
        type = ty;
    }
    public String getType() {
        return type;
    }
    
}
    
