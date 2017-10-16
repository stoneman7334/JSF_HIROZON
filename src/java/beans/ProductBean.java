/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.ProductDb;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import model.Product;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import java.util.List;

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
	
	private String c_id;	//***  ***//

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

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
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

    //*** --- SELF MADE METHOD --- AJAX 指定した商品IDのインスタンスを取得するメソッド ***//
    public void ajaxFindProduct() {
        System.out.println("call ProductBean->findProduct()");
        System.out.println(String.format("商品ID : %s", id));

        //*** 商品IDに、何も入力がない または、検索結果がnull ***//
        if (id.isEmpty() || db.find(id) == null) {
            return;		//*** 処理を抜ける ***//
        }
        //*** 商品IDで、検索してインスタンスを取得 ***//
        Product p = db.find(id);
        //*** Beanに検索結果を代入する ***//
        this.id = p.getP_id();
        this.name = p.getP_name();
        this.count = p.getP_count();
        this.price = p.getP_price();

        System.out.println(String.format("商品インスタンス : %s", p.toString()));
    }
    //*** --- SELF MADE METHOD --- 指定した写真IDの画像情報を返すメソッド ***//

    public StreamedContent getPic() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("pic1");	//*** ここの、指定方法を調べること ***//
            System.out.println(key);
            DefaultStreamedContent ds = null;

            if (key != null) {
                Product p = db.find(key);
                ByteArrayInputStream out = new ByteArrayInputStream(p.getP_img());
                ds = new DefaultStreamedContent(out);
            }
            return ds;
        }
    }

    public StreamedContent getPic2() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("pic2");	//*** ここの、指定方法を調べること ***//
            System.out.println(key);
            DefaultStreamedContent ds = null;

            if (key != null) {
                Product p = db.find(key);
                ByteArrayInputStream out = new ByteArrayInputStream(p.getP_img2());
                ds = new DefaultStreamedContent(out);
            }
            return ds;
        }
    }

    public StreamedContent getPic3() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("pic3");	//*** ここの、指定方法を調べること ***//
            System.out.println(key);
            DefaultStreamedContent ds = null;

            if (key != null) {
                Product p = db.find(key);
                ByteArrayInputStream out = new ByteArrayInputStream(p.getP_img3());
                ds = new DefaultStreamedContent(out);
            }
            return ds;
        }
    }
    //*** 編集した商品情報でUPDATEするメソッド ***//

    public String productMerge() {
        System.out.println("call ProductBean->productMerge()");

        return "";
    }

    //*** 商品マスタの全データを検索して返すメソッド ***//
    public List<Product> getAll() {
        return db.getAll();
    }
    //*** ”本”の一覧を取得するメソッド ***//
    public List<Product> getProOfBook(){
        System.out.println("call pBean->getProOfBook()");
        return db.getProOfBook("0009");	//*** 本 ***//
    }
	//*** ”家電”の一覧を取得するメソッド ***//
	public List<Product> getProOfElectric(){
		System.out.println("call pBean->getProOfElectric");
		return db.getProOfBook("0002");	//*** 家電 ***//
	}
	
	

}
