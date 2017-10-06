/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.ProductDb;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import model.Product;

/**
 *
 * @author 5151021
 */
@Named(value = "pBean")
@RequestScoped
public class ProductBean {
    
    //*** Field ***//
    private String id;      //*** 商品ID ***//
    private String name;    //*** 商品名 ***//
    private int count;      //*** 個数 ***//
    private int price;      //*** 価格 ***//
//    private Part picture;   //*** 画像（暫定ひとつ） ***//
      private byte [] picture;   //*** 画像（暫定ひとつ） ***//
    
   @EJB
   ProductDb db;
    
    //*** Constractor ***//
    public ProductBean() {
    }
    
    //*** GetterSetter ***//
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public byte[] getPicture() {
        return picture;
    }
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    //***  ***//
    public String newRegist(){
        System.out.println("call ProductBean->newRegist()");
        
        //***  ***//
        Product p = new Product(
            id,
            name,
            count,
            price,
            picture
        );
        //***  ***//
        db.persist(p); 
        
        return "";  //***  ***//
    }
    
    
}
