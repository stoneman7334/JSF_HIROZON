/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.ProductDb;
import java.io.IOException;
import java.io.Serializable;
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
public class ProductBean implements Serializable {

	//*** Field ***//
	private String id;      //*** 商品ID ***//
	private String name;    //*** 商品名 ***//
	private int count;      //*** 個数 ***//
	private int price;      //*** 価格 ***//
	private Part picture;   //*** 画像 ***//
	private Part picture2;   //*** 画像 ***//
	private Part picture3;   //*** 画像 ***//

//      private byte [] picture;   //*** 画像（暫定ひとつ） ***//
	@EJB
	ProductDb db;			//*** 商品テーブル用 ***//

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
	public Part getPicture() {
		return picture;
	}
	public void setPicture(Part picture) {
		this.picture = picture;
	}
	public Part getPicture2() {
		return picture2;
	}
	public void setPicture2(Part picture2) {
		this.picture2 = picture2;
	}
	public Part getPicture3() {
		return picture3;
	}
	public void setPicture3(Part picture3) {
		this.picture3 = picture3;
	}

	//*** --- SELF MADE METHOD --- 商品の新規登録メソッド ***//
	public String newRegist() throws IOException {
		System.out.println("call ProductBean->newRegist()");

		//***  ***//
		Product p = new Product(
				id,
				name,
				count,
				price,
				picture,
				picture2,
				picture3
		);
		//***  ***//
		db.persist(p);

		return "";  //***  ***//
	}
	
	//*** --- SELF MADE METHOD --- AJAX 指定した商品IDの在庫数取得のためのメソッド ***//
	public void ajaxFindProduct(){
		System.out.println("call ProductBean->findProduct()");
		System.out.println(String.format("商品ID : %s", id));
		
		//*** 商品IDに、何も入力がない または、検索結果がnull ***//
		if (id.isEmpty() || db.find(id) == null)	return ;		//*** 処理を抜ける ***//
		
		//*** 商品IDで、検索してインスタンスを取得 ***//
		Product p = db.find(id);
		System.out.println(String.format("商品インスタンス : %s", p.toString()));
		this.count = p.getP_count();
	}

}
