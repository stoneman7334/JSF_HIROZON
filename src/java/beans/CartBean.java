/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.CartDb;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import model.Cart;
import util.Util;

/**
 *
 * @author Yuichi-Oba
 */
@Named(value = "cartBean")
@SessionScoped
public class CartBean implements Serializable {

	@EJB
	private CartDb db;				//*** カートDB操作用 ***//

	private String u_id;			//*** ユーザID ***//
	private String p_id;			//*** 商品ID ***//
	private int count;				//*** 個数 ***//
	private int price;				//*** 価格 ***//
	private String dateTime;		//*** カートに入れた時刻 ***//
	private String expiration;		//*** 有効期限 ***//

	@Inject
	private ProductBean product;	//*** 商品 ***//
	@Inject
	private UserBean user;			//*** ユーザ ***//

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
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**
	 * Creates a new instance of CartBean
	 */
	public CartBean() {
	}

	//*** new regist ***//
	public String persist() {
		System.out.println("call CartBean->persist()");
		//*** カートに入れる押下時の日付を取得(パターン文字列化済み yyyy/MM/dd) ***//
		String wkDateTime = Util.parseCalToStr(Calendar.getInstance());

		System.out.println(String.format("uId : %s pId :%s", user.getId(), product.getId()));
		//*** ユーザIDを設定する ***//
		this.u_id = user.getId();
		
		//*** modelカートのインスタンスを生成 ***//
		Cart c = new Cart(
//				cnt++, //*** カートのidの最大値を取得 ***//
				user.getId(), //*** ユーザID ***//
				this.count, //*** 個数 ***//
				new Date(), //*** カートに入れた日付 ***//
				new Date(), //*** カートの有効期限（暫定） ***//
				product.getId(), //*** 商品ID ***//
				product.getPrice() //*** 単価 ***//
		);
		// todo 主キーが複合キーになっていない
		//*** new regist ***//
		db.persist(c);

		return "user_cart?faces-redirect=true";
	}
	//***  ***//
	public List<Cart> getCart(){
		System.out.println("call CartBean->getCart()");
		
		List<Cart> carts = db.returnCart(u_id);	//*** DB検索した結果をリストで取得 ***//
//		for (Cart c : carts)
//		{
//			this.dateTime = Util.parseCalToStr(c.getDateTime());
//		}
//		
		return carts;	//***  ***//
	}
	
	//***  ***//
	public String pageUserCart(){
		this.u_id = user.getId();				//*** ユーザIDを設定する ***//
		return "user_cart?faces-redirect=true";	//*** リダイレクト ***//
	}
}
