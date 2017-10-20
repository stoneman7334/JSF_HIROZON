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
    
    @Embeddable
    public static class PK{
        //***  ***//
        @Column
        private String u_id;
        @Column
        private String p_id;
        
        //***  ***//
        public String getU_id() {
            return u_id;
        }
        public void setU_id(String u_id) {
            this.u_id = u_id;
        }
        public String getP_id() {
            return p_id;
        }
        public void setP_id(String p_id) {
            this.p_id = p_id;
        }
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + Objects.hashCode(this.u_id);
            hash = 83 * hash + Objects.hashCode(this.p_id);
            return hash;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final PK other = (PK) obj;
            if (!Objects.equals(this.u_id, other.u_id)) {
                return false;
            }
            if (!Objects.equals(this.p_id, other.p_id)) {
                return false;
            }
            return true;
        }
    }

    private static final long serialVersionUID = 1L;
	//***  ***//
    @EmbeddedId
    private PK pk;
//    private String u_id;
//    private String p_id;
    private int count;
    private int price;
    private Date dateTime;
    private Date expiration;

    public Cart() {
    }
    public Cart(String id, int count, Date wkDateTime, Date expiration, String p_id, int price) {
            this.pk.u_id = id;
            this.count = count;
            this.dateTime = wkDateTime;
            this.expiration = expiration;
            this.pk.p_id = p_id;
            this.price = price;
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
    public PK getPk() {
            return pk;
    }
    public void setPk(PK pk) {    
        this.pk = pk;
    }
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
