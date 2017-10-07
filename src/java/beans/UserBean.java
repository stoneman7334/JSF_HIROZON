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
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.User;
import util.Util;

/**
 *
 * @author 5151021
 */
@Named(value = "uBean")
@RequestScoped
public class UserBean {

	@EJB
	private UserDb userDb;

	private String id;				//*** ユーザID ***//
	private String pass;			//*** パスワード ***//
	private String u_name;			//*** 氏名 ***//
	private String u_mailaddr;		//*** メールアドレス ***//
	private String u_post;			//*** 郵便番号 ***//
	private String u_address;		//*** 住所 ***//
	private String u_tel;			//*** 電話番号 ***//
	private String u_birth_day;		//*** 生年月日 ***//
	private String u_sex;			//*** 性別 ***//
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
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_mailaddr() {
		return u_mailaddr;
	}
	public void setU_mailaddr(String u_mailaddr) {
		this.u_mailaddr = u_mailaddr;
	}
	public String getU_post() {
		return u_post;
	}
	public void setU_post(String u_post) {
		this.u_post = u_post;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_tel() {
		return u_tel;
	}
	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}
	public String getU_birth_day() {
		return u_birth_day;
	}
	public void setU_birth_day(String u_birth_day) {
		this.u_birth_day = u_birth_day;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	//*** ログインチェックを行うメソッド ***//
	public String loginCheck() throws NoSuchAlgorithmException {
		System.out.println("call loginCheck()");
		System.out.println(String.format("id=%s : pass=%s", id, pass));

		user = userDb.find(id, Util.returnSHA256(pass));
		if (user == null) {
			return "";
		}
		//*** ここで、DB検索してユーザのチェックを行う ***//
		return "account_menu"; //*** 暫定 ***//
	}
	//*** 新規会員登録を行うメソッド ***//
	public String addUser() throws NoSuchAlgorithmException {
		System.out.println("call UserBean->addUser()");
		//*** ユーザIDの重複をチェックする ***//
		if (!userDb.checkDuplicateUserId(id)) {
			return "";	//*** 重複発生のため、処理を抜ける ***//
		}
		//*** Userクラスのインスタンスを生成する ***//
		User u = new User(
				id,							//*** ユーザID ***//
				u_name,						//*** 氏名 ***//
				Util.returnSHA256(pass),	//*** ハッシュ化したパスワード ***//
				u_mailaddr,					//*** メールアドレス ***//
				u_address,					//*** 住所 ***//
				u_birth_day,				//*** 生年月日 ***//
				u_post,						//*** 郵便番号 ***//
				u_sex,						//*** 性別 ***//
				u_tel						//*** 電話番号 ***//
		);
		//*** DBに新規登録をかける ***//
		userDb.persist(u);

		//*** その結果に応じた画面遷移先を設定する ***//
		return "login";  //*** 暫定 ***//
	}
	//*** 指定IDのユーザのパスワードをリセットして、仮パスワードを指定するメソッド ***//
	public String passForget() throws NoSuchAlgorithmException {
		System.out.println("call UserBean->passForget()");
		//*** 入力してきたIDのユーザが存在するか確認 ***//
		User u = userDb.find(id);
		if (u == null){
			return "";
		}
		//*** ランダムな文字列生成（8文字くらい） ***//
		String ramdomPass = Util.getRandomString(5);
		System.out.println(String.format("生成した仮パスワード : %s", ramdomPass));
		
		u.setU_pass(Util.returnSHA256(ramdomPass));	//*** 生成した仮パスワードをセット ***//
		System.out.println(String.format("ハッシュ結果 : %s", u.getU_pass()));
		userDb.merge(u);			//*** 更新をかける ***//
		
		return "";  //*** ページ遷移はなしで、画面に、仮パスワードを出力する ***//
	}
	//***  ***//
	public String changeMail() throws NoSuchAlgorithmException {
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
    //*** 管理者ユーザのログインを行うメソッド ***//
    public String addminLoginCheck() throws NoSuchAlgorithmException{
        System.out.println("call adminLoginCheck()");
        //*** ログインチェックの結果をもらって、空文字でなければ、成功 ***//
        String result = loginCheck();
        //*** 管理者は、ID９９９９を持つユーザに固定 ***//
        if (id.contains("9999") && !result.contains("")){
            return "admin_menu";    //*** ログイン成功－＞ 管理者トップページに遷移する ***//
        }   
        return "";                  //*** ログイン失敗 ***//
    }

}
