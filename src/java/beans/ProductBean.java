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
import util.Util;

import java.util.List;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author 5151021
 */
@Named(value = "pBean")
@SessionScoped
public class ProductBean implements Serializable {

    //*** Field ***//
    private String id;      //*** 商品ID ***//
    private String name;    //*** 商品名 ***//
    private int count;      //*** 個数 ***//
    private int price;      //*** 価格 ***//
    private Part picture;   //*** 画像 ***//
    private Part picture2;   //*** 画像 ***//
    private Part picture3;   //*** 画像 ***//
    private String c_id;	//*** カテゴリID ***//
    private boolean editable;

    @Inject
    SearchBean sBean;
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

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    //*** 写真１表示メソッド ***//

    public StreamedContent getPic() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("pic1");	//*** ここの、指定方法を調べること ***//
            System.out.println(String.format("key : %s", key));
            DefaultStreamedContent ds = null;

            if (key != null) {
                Product p = db.find(key);
                ByteArrayInputStream out = new ByteArrayInputStream(p.getP_img());
                ds = new DefaultStreamedContent(out);
            }
            return ds;
        }
    }
    //*** 写真２表示メソッド ***//

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
    //*** 写真３表示メソッド ***//

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
    //*** ---------------------------- ***//
    //*** ----- SELF MADE METHOD ----- ***//
    //*** ---------------------------- ***//
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
                picture3,
                c_id
        );
        //***  ***//
        db.persist(p);

        return "admin_menu?faces-redirect=true";  //***  ***//
    }

    //*** --- SELF MADE METHOD --- AJAX 指定した商品IDのインスタンスを取得するメソッド ***//
    public void ajaxFindProduct() {
        System.out.println("call ProductBean->ajxFindProduct()");
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
    //***  ***//

    public void ajaxFindProduct(String id) {
        System.out.println("call ProductBean->ajxFindProduct()");
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

    //*** 編集した商品情報でUPDATEするメソッド ***//
    public String productMerge() throws IOException {
        System.out.println("call ProductBean->productMerge()");
        //***  ***//
        Product p = new Product(
                id,
                name,
                count,
                price,
                picture,
                picture2,
                picture3,
                c_id
        );
        db.update(p);

        return "admin_edit";
    }

    //*** 商品マスタの全データを検索して返すメソッド ***//
    public List<Product> getAll() {
//		this.editable = false;
        return db.getAll();
    }

    //*** ”本”の一覧を取得するメソッド ***//
    public List<Product> getProOfBook() {
        System.out.println("call pBean->getProOfBook()");
        return db.getProOfBook("0009");	//*** 本 ***//
    }

    //*** ”家電”の一覧を取得するメソッド ***//
    public List<Product> getProOfElectric() {
        System.out.println("call pBean->getProOfElectric");
        return db.getProOfBook("0002");	//*** 家電 ***//
    }

    //*** ”酒”の一覧を取得するメソッド ***//
    public List<Product> getProOfLiquor() {
        System.out.println("call pBean->getProOfElectric");
        return db.getProOfBook("0003");	//*** 家電 ***//
    }

    //*** 検索ボックスに入力したもの(this.name)で、DB検索し、結果をリストで返すメソッド ***//
    public List<Product> getProOfSearch() {
        Util.easyLog("call pBean.getProOfSearch()");
        System.out.println(sBean.getpName());

        //*** DB検索した結果のリストを返す ***//
        List<Product> list = db.getSearchCharacter(sBean.getpName());
        System.out.println(String.format("list size : %d", list.size()));
        return db.getSearchCharacter(this.name);
    }

    //*** 関連商品のリストを返すメソッド ***//
    public List<Product> getProOfSearchRelation() {
        Util.easyLog("call pBean.getProOfSearchRelaion()");
        System.out.println(c_id);

        //*** カテゴリIDを取得して、一覧を取得するメソッド ***//
        return db.getProOfBook(this.c_id);

    }

    //***  ***//
    public String edit(Product p) {
        this.id = p.getP_id();
        this.name = p.getP_name();
        this.count = p.getP_count();
        this.price = p.getP_price();
        return "admin_edit_detail";
    }

    //*** 選択した商品の情報を、このインスタンスに記録して、商品詳細ページに遷移するメソッド ***//
    public String addToCart(Product p) {
        System.out.println("call uBean->addToCart()");
        //***  ***//
        this.id = p.getP_id();
        this.name = p.getP_name();
        this.count = p.getP_count();
        this.price = p.getP_price();
        this.c_id = p.getC_id();

        return "product_detail?faces-redirect=true";
    }

    //*** 検索ボックスボタン押下時の処理 ***//
    public String searchProduct() {
        Util.easyLog("call ProductBean.searchProduct()");
        System.out.println(this.name);

        return "search_result.xhtml?faces-redirect=true";	//*** 検索結果画面にリダイレクトする ***//
    }

}
