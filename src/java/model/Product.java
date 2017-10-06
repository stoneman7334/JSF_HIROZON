/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.Part;

/**
 *
 * @author 5151021
 */
@Entity
@Table(name = "m_product")  //*** 商品マスタテーブル ***//
public class Product implements Serializable {

    //*** Field ***//
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String p_id;    //*** 商品ID ***//
    private String p_name;  //*** 商品名 ***//
    private int p_count;    //*** 個数 ***//
    private int p_price;    //*** 価格 ***//
    private byte [] p_img;  //*** 画像（暫定一つ） ***//

    public Product(String id, String name, int count, int price, byte[] picture) {
        this.p_id = id;
        this.p_name = name;
        this.p_count = count;
        this.p_price = price;
        this.p_img = picture;
    }
    
    public Product(){};

    //*** GetterSetter ***//
    public String getP_id() {
        return p_id;
    }
    public void setP_id(String p_id) {
        this.p_id = p_id;
    }
    public String getP_name() {
        return p_name;
    }
    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    public int getP_count() {
        return p_count;
    }
    public void setP_count(int p_count) {
        this.p_count = p_count;
    }
    public int getP_price() {
        return p_price;
    }
    public void setP_price(int p_price) {
        this.p_price = p_price;
    }
    public byte[] getP_img() {
        return p_img;
    }
    public void setP_img(byte[] p_img) {
        this.p_img = p_img;
    }
   
}
