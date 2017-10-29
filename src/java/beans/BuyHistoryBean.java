/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.BuyHistoryDb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import model.BuyHistory;
import model.Cart;
import model.User;
import util.Util;

/**
 *
 * @author 5151002
 */
@Named(value = "bhBean")
@SessionScoped
public class BuyHistoryBean implements Serializable {

    //*** フィールド群 ***//
    private String id;		//*** 購入履歴ID ***//
    private String u_id;	//*** ユーザID ***//
    private Date datetime;	//*** 購入日付 ***//
    private int    count;	//*** 個数 ***//
    private int    price;	//*** 単価 ***//
    private String p_id;	//*** 商品ID ***//
    @EJB
    BuyHistoryDb db;		//*** 購入履歴テーブル操作用 ***//
	@Inject
	CartBean cBean;			
	@Inject
	UserBean uBean;	
	
    public BuyHistoryBean() {
    }
    //*** GetterSetter ***//
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getU_id() {
        return u_id;
    }
    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public Date getDatetime() {
        return datetime;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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
    public String getP_id() {
        return p_id;
    }
    public void setP_id(String p_id) {
        this.p_id = p_id;
    }
	//*** ---------------------------- ***//
	//*** ----- SELF MADE METHOD ----- ***//
	//*** ---------------------------- ***//
	//***  ***//
    public List<BuyHistory> getItems() {
        return db.userFind(uBean.getId());	//***  ***//
    }
	//*** 購入処理を行うメソッド ***//
	public String buy() {
		Util.easyLog("call bhBean.buy()");
		//*** カートの中身を取得して、購入履歴へ挿入する ***//
		db.persist(cBean.getCart());			
		
		//*** カートの中身をすべて削除する ***//
		cBean.delAllProduct();
		
		return "top.xhtml?faces-redirect=true";	//*** トップ画面へリダイレクトする ***//
    }
	//***  ***//
	
}
