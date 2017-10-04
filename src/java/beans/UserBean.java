/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.UserDb;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.User;

/**
 *
 * @author 5151021
 */
@Named(value = "uBean")
@RequestScoped
public class UserBean {

    @EJB
    private UserDb userDb;

    private String id;
    private String pass;

    public UserBean() {
    }

    public UserDb getUserDb() {
        return userDb;
    }

    public void setUserDb(UserDb userDb) {
        this.userDb = userDb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //*** ログインチェックを行うメソッド ***//
    public String loginCheck() throws NoSuchAlgorithmException {
        System.out.println("call loginCheck()");
        
        System.out.println(String.format("id=%s : pass=%s", id, pass));
        //*** this.pass を、SHA256でハッシュ化する ***//
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] result = md.digest(this.pass.getBytes());	//*** 256ハッシュ化した結果をバイト配列に代入する ***//

        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());	//*** 入力したpassをSHA256ハッシュ化した結果の文字列 ***//
        
        User u = userDb.find(id,sb.toString());
        if (u == null){
            return "";
        }

        //*** ここで、DB検索してユーザのチェックを行う ***//
        return "account_menu"; //*** 暫定 ***//
    }

}
