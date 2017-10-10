/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] p_img;  //*** 画像 ***//
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] p_img2;  //*** 画像2 ***//
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] p_img3;  //*** 画像3 ***//
	//*** Constractor ***//

	public Product() {
	}
	public Product(String id, String name, int count, int price, Part p, Part p2, Part p3) throws IOException {
		this.p_id = id;						//*** 商品ID ***//
		this.p_name = name;					//*** 商品名 ***//
		this.p_count = count;				//*** 個数 ***//
		this.p_price = price;				//*** 価格 ***//
		
		//*** 受け取ったPart型のインスタンスを、バイト配列に変換する ***//
		this.p_img = convertByteArray(p);	//*** 変換したバイト配列をセットする ***//
		this.p_img2 = convertByteArray(p2);	//*** 変換したバイト配列をセットする ***//
		this.p_img3 = convertByteArray(p3);	//*** 変換したバイト配列をセットする ***//
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
	
	//*** --- SELF MADE METHOD --- 引数のPart型のインスタンスを、バイト配列に変換して返すメソッド ***//
	private static byte[] convertByteArray(Part p) {
		//*** 引数がnull→つまり、画像が選択されていない ***//
		if (p == null){
			return new byte[0];	//*** 長さ0のバイト配列を返す(ヌルポ対策) ***//
		}
		
		byte[] data = new byte[(int) p.getSize()];
		try {
			InputStream is = p.getInputStream();
			is.read(data);
		} catch (IOException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}

		return data;	//*** 変換したバイト配列を返す ***//
	}
	@Override
	public String toString() {
		return String.format("商品ID : %s 個数 : %s", p_id, p_count);
	}
	

}
