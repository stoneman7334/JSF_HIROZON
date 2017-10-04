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
    
   //*** 変更前アドレスと変更予定のアドレス ***//
    private String beMail;
    private String newMail;
    
    User user;
    
    

    public UserBean() {
    }

    public String getBeMail() {
        return beMail;
    }

    public void setBeMail(String beMail) {
        this.beMail = beMail;
    }

    public String getNewMail() {
        return newMail;
    }

    public void setNewMail(String newMail) {
        this.newMail = newMail;
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
        
        user = userDb.find(id,sb.toString());
        if (user == null){
            return "";
        }
        //*** ここで、DB検索してユーザのチェックを行う ***//
        return "account_menu"; //*** 暫定 ***//
    }
    
    //*** 新規会員登録を行うメソッド ***//
    public String addUser(){
        System.out.println("call UserBean->addUser()");
        //*** 入力した値たちを取得する ***//
        
        //*** DBに新規登録をかける ***//
        
        //*** その結果に応じた画面遷移先を設定する ***//
        
        return "";  //*** 暫定 ***//
    }
    
    //*** 指定IDのユーザのパスワードをリセットして、仮パスワードを指定するメソッド ***//
    public String passForget(){
        System.out.println("call UserBean->passForget()");
        //*** 入力してきたIDのユーザが存在するか確認 確認できたら、処理続行 ***//
        
        //*** ランダムな文字列生成（8文字くらい） ***//
        
        //*** 生成した文字列を、DBに格納する ***//
        
        return "";  //*** ページ遷移はなしで、画面に、仮パスワードを出力する ***//
    }
    
    public String changeMail() throws NoSuchAlgorithmException{
        String res = null;
        //*** アドレス変更の際のパスワードのハッシュ処理 ***//
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] result = md.digest(this.pass.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        
        
        
        return res;
    }

}
