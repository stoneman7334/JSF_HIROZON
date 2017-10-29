/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.Size;
import util.Util;

/**
 *
 * @author yuichi_develop
 */
@Named(value = "sBean")
@SessionScoped
public class SearchBean implements Serializable {

    //*** Field ***//
    @Size(min = 1, message = "検索文字列を入力してください")
    private String pName; //*** 検索したい商品名 ***//
    //*** Constractor ***//

    public SearchBean() {
    }

    //*** GetterSetter ***//
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String searchProduct() {
        Util.easyLog("call ProductBean.searchProduct()");
        System.out.println(this.pName);

        return "search_result.xhtml?faces-redirect=true";	//*** 検索結果画面にリダイレクトする ***//
    }

}
