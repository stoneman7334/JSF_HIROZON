/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.Util;

/**
 *
 * @author 5151021
 */
@Entity
@Table(name = "t_buy_history")
public class BuyHistory implements Serializable {

	//*** Field ***//
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String buy_id;
    private String u_id;
    private Date datetime;
    private int count;
    private int price;
    private String p_id;
	//*** Constracotr ***//
    public BuyHistory() { }
    public BuyHistory(String u_id, Date datetime, int count, int price, String p_id) {
        this.u_id = u_id;
        this.datetime = datetime;
        this.count = count;
        this.price = price;
        this.p_id = p_id;
    }
	//*** GetterSetter ***//
	public String getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(String buy_id) {
		this.buy_id = buy_id;
	}
    public String getU_id() {
        return u_id;
    }
    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public String getDatetime() {
		//*** 2017-10-27 13:52:08.700 の、"2017-10-27"だけほしいので ***//
        return Util.parseCalToStr(datetime).split(" ")[0];
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
        return this.price * this.count;
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
    
}
