/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.CartDb;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.validation.constraints.Min;
import model.Cart;
import util.Util;

/**
 *
 * @author Yuichi-Oba
 */
@Named(value = "cartBean")
@SessionScoped
public class CartBean implements Serializable {

    //*** Field ***//
    @EJB
    private CartDb db;				//*** カートDB操作用 ***//

    private String u_id;			//*** ユーザID ***//
    private String p_id;			//*** 商品ID ***//
    @Min(value = 1, message = "1以上の数値を指定してください")
    private int count;				//*** 個数 ***//
    private int price;				//*** 価格 ***//
    private String dateTime;		//*** カートに入れた時刻 ***//
    private String expiration;		//*** 有効期限 ***//
    @Inject
    private ProductBean product;	//*** 商品 ***//
    @Inject
    private UserBean user;			//*** ユーザ ***//

    //*** Constractor ***//
    public CartBean() {
    }
    //*** GetterSetter ***//
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
    //*** ---------------------------- ***//
    //*** ----- SELF MADE METHOD ----- ***//
    //*** ---------------------------- ***//
    //*** new regist ***//
    public String persist() throws ParseException {
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
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(wkDateTime), //*** カートに入れた日付 ***//
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(wkDateTime), //*** カートの有効期限（暫定） ***//
                            product.getId(), //*** 商品ID ***//
                            product.getPrice() //*** 単価 ***//
            );
            //*** カートの中身の重複をチェックする ***//
            Cart cc = db.checkDuplicateCart(c);
            if (cc != null){
                    //*** 重複があれば、Updateする ***//
                    cc.setCount(getCount() + this.count);	//*** 個数を足しこむ ***//
                    db.upDateCart(cc);
                    this.count = 1;
            } else {
                    //*** 重複がなければ、新規登録する ***//
                    db.persist(c);
            }
            return "user_cart?faces-redirect=true";	
    }
    //*** dataTable用 カートの中身をリストで取得するメソッド ***//
    public List<Cart> getCart(){
            System.out.println("call CartBean->getCart()");

            List<Cart> carts = db.returnCart(user.getId());	//*** DB検索した結果をリストで取得 ***//
            return carts;	//***  ***//
    }
    //*** カートの中身の数をチェックし、遷移先を変えるメソッド ***//
    public String pageUserCart(){
            this.u_id = user.getId();				//*** ユーザIDを設定する ***//
            //*** カートの中身の数をチェックする ***//
            if (db.cursorCount() > 0){
                    return "user_cart?faces-redirect=true";	//*** カートの中身が１以上ならリダイレクト ***//
            } else {
                    return "";
            }
    }
    //*** カートの商品を削除するメソッド ***//
    public String delProduct(Cart data) throws ParseException{
            System.out.println("call CartBean->delProduct()");

            Cart c = data;
            db.delCartCursor(c);
            System.out.println(c.getDateTime());

            return "user_cart.xhtml?faces-redirect=true";
    }
    //*** カートの商品を全削除するメソッド ***//
    public String delAllProduct(){
            System.out.println("call CartBean->delAllProduct()");

            int rs = db.delAllProduct(user.getId());				//***  ***//
            System.out.println(String.format("削除件数 : %d", rs));	//***  ***//
            return "top.xhtml?faces-redirect=true";	//***  ***//
    }
	
}
