/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 5151021
 */
@Entity
@Table(name = "t_cart")
public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
	//***  ***//
    @Id
    private String id;
    private String u_id;
    private String p_id;
    private int count;
    private int price;
    private Date dateTime;
    private Date expiration;
    
    public Cart() {
    }
    public Cart(int cnt, String id, int count, Date wkDateTime, Date expiration, String p_id, int price) {
        this.id = String.valueOf(cnt);  //***  ***//
        this.u_id = id;                 //***  ***//
        this.count = count;             //***  ***//
        this.dateTime = wkDateTime;     //***  ***//
        this.expiration = expiration;   //***  ***//
        this.p_id = p_id;               //***  ***//
        this.price = price;             //***  ***//
    }
    

    //***  ***//
//    public String getU_id() {
//            return u_id;
//    }
//    public void setU_id(String u_id) {
//            this.u_id = u_id;
//    }
//    public String getP_id() {
//            return p_id;
//    }
//    public void setP_id(String p_id) {
//            this.p_id = p_id;
//    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
            this.count = count;
    }
    public int getPrice() {
            return price;
    }
    public void setPrice(int price) {
            this.price = price;
    }
    public Date getDateTime() {
            return dateTime;
    }
    public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
    }
    public Date getExpiration() {
            return expiration;
    }
    public void setExpiration(Date expiration) {
            this.expiration = expiration;
    }

    
}
