/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author j-knakagami2
 */
@Entity
@Table(name = "oc_user")
public class OcUser {
    @Id @NotNull
    private String user_id;
    private String user_name,user_sub_name,user_pass;
    private boolean card_flg,admin_flg;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] user_photo;
    
    public OcUser() {
    }

    public OcUser(String user_id, String user_name, String user_sub_name, String user_pass, boolean card_flg, byte[] user_photo) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_sub_name = user_sub_name;
        this.user_pass = user_pass;
        this.card_flg = card_flg;
        this.user_photo = user_photo;
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

    public boolean isAdmin_flg() {
        return admin_flg;
    }

    public void setAdmin_flg(boolean admin_flg) {
        this.admin_flg = admin_flg;
    }

    public boolean isCard_flg() {
        return card_flg;
    }

    public void setCard_flg(boolean card_flg) {
        this.card_flg = card_flg;
    }

    public byte[] getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(byte[] user_photo) {
        this.user_photo = user_photo;
    }
    
    
}
