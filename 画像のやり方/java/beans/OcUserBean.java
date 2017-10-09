/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.OcUserTbl;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
/**
 *
 * @author j-knakagami2
 */
@Named(value = "ocUserBean")
@SessionScoped
public class OcUserBean implements Serializable{
    private String user_id;
    private String user_name,user_sub_name,user_pass;
    private boolean card_flg,admin_flg;
    private byte[] user_photo;
    @EJB
    private OcUserTbl db;
    /**
     * Creates a new instance of OcUserBean
     */
    public OcUserBean() {
    }   



    
    public List<OcUser> getAll(){
        return db.getAll();
    }
    
    
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sub_name() {
        return user_sub_name;
    }

    public void setUser_sub_name(String user_sub_name) {
        this.user_sub_name = user_sub_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public boolean isCard_flg() {
        return card_flg;
    }

    public void setCard_flg(boolean card_flg) {
        this.card_flg = card_flg;
    }

    public boolean isAdmin_flg() {
        return admin_flg;
    }

    public void setAdmin_flg(boolean admin_flg) {
        this.admin_flg = admin_flg;
    }

    public byte[] getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(byte[] user_photo) {
        this.user_photo = user_photo;
    }

    
}
