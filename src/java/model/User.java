/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 5151021
 */
@Entity
@Table(name = "m_user")
public class User implements Serializable {

    //*** Field ***//
    private static final long serialVersionUID = 1L;
    @Id
    private String u_Id;
    private String u_pass;
    
     public User() {
    }
    
    //*** GetterSetter ***//
    public String getU_id() {
        return u_Id;
    }
    public void setU_id(String u_id) {
        this.u_Id = u_id;
    }
    public String getU_pass() {
        return u_pass;
    }
    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }
    
    
    
    @Override
    public String toString() {
        return "model.User[ id=" + u_Id + " ]";
    }

}
