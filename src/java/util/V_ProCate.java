/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author 5151021
 */
//*** 商品マスタとカテゴリマスタを結合した結果を格納するためのクラス ***//
//*** コンストラクタ式 という文法らしい ***//
public class V_ProCate {
    
    //*** Field ***//
    private String p_id;
    private String p_name;
    private String p_count;
    private String p_price;
    private byte [] p_img;
    private byte [] p_img2;
    private byte [] p_img3;

    //*** Constractor ***//
    public V_ProCate(String p_id, String p_name, String p_count, String p_price, byte[] p_img, byte[] p_img2, byte[] p_img3) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_count = p_count;
        this.p_price = p_price;
        this.p_img = p_img;
        this.p_img2 = p_img2;
        this.p_img3 = p_img3;
    }
    public V_ProCate() {
    }

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
    public String getP_count() {
        return p_count;
    }
    public void setP_count(String p_count) {
        this.p_count = p_count;
    }
    public String getP_price() {
        return p_price;
    }
    public void setP_price(String p_price) {
        this.p_price = p_price;
    }
    public byte[] getP_img() {
        return p_img;
    }
    public void setP_img(byte[] p_img) {
        this.p_img = p_img;
    }
    public byte[] getP_img2() {
        return p_img2;
    }
    public void setP_img2(byte[] p_img2) {
        this.p_img2 = p_img2;
    }
    public byte[] getP_img3() {
        return p_img3;
    }
    public void setP_img3(byte[] p_img3) {
        this.p_img3 = p_img3;
    }
    
    
}
