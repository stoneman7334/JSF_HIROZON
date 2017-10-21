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
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Inject;
import model.BuyHistory;
import util.Util;

/**
 *
 * @author 5151002
 */
@Named(value = "bhBean")
@SessionScoped
public class BuyHistoryBean implements Serializable {

    /**
     * Creates a new instance of BuyHistoryBean
     */
    
    //*** フィールド群 ***//
    private String id;
    private String u_id;
    private Date datetime;
    private int    count;
    private int    price;
    private String p_id;
    
    @Inject
    CartBean cart;
    
    @EJB
    BuyHistoryDb db;
    
    public BuyHistoryBean() {
    }

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
    
    public String buy() {
        //*** インスタンス生成 ***//
//        BuyHistory buy = new BuyHistory(cart.getU_id(), new Date(), cart.getCount(), cart.getPrice(), cart.getP_id());
//        System.out.println(cart.getU_id());
//        db.persist(buy);
        
        return "user_history";
    }
}
