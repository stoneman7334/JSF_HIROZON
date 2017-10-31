/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.ZipCodeDb;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import model.ZipCode;
import util.Util.*;

/**
 *
 * @author 5151021
 */
//*** 郵便番号から住所自動入力をおこなうための、Bean ***//
@Named(value = "zipBean")
@RequestScoped
public class ZipCodeBean {

    //*** Field ***//
    private String id;
    private String jiscode;
    private String zipcode_old;
    private String zipcode;
    private String pref_kana;
    private String city_kana;
    private String street_kana;
    private String pref;
    private String city;
    private String street;

    @Inject
    private UserBean uBean;
    @EJB
    private ZipCodeDb db;

    //*** Constractor ***//
    public ZipCodeBean() {
    }

    //*** GetterSetter ***//
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJiscode() {
        return jiscode;
    }

    public void setJiscode(String jiscode) {
        this.jiscode = jiscode;
    }

    public String getZipcode_old() {
        return zipcode_old;
    }

    public void setZipcode_old(String zipcode_old) {
        this.zipcode_old = zipcode_old;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPref_kana() {
        return pref_kana;
    }

    public void setPref_kana(String pref_kana) {
        this.pref_kana = pref_kana;
    }

    public String getCity_kana() {
        return city_kana;
    }

    public void setCity_kana(String city_kana) {
        this.city_kana = city_kana;
    }

    public String getStreet_kana() {
        return street_kana;
    }

    public void setStreet_kana(String street_kana) {
        this.street_kana = street_kana;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    //***                   ***//
    //*** SELF MADE METHOD  ***//
    //***                   ***//
    //*** 郵便番号から住所を検索するメソッド ***//
    public String searchZipCode() {
        util.Util.easyLog("call ZipCodeBean->searchZipcode()");

        System.out.println(String.format("zipcode : %s", this.zipcode));
        List<ZipCode> list = db.returnZipCodeInstance(this.zipcode);

        System.out.println(String.format("検索結果 :  %d", list.size()));
        list.forEach(c -> {
            System.out.println(c.getPref());
            this.pref = c.getPref();                              //*** 県名 ***//
            this.pref_kana = c.getPref_kana();          //*** 県名のかな ***//
            this.city = c.getCity();                              //*** 市 ***//
            this.city_kana = c.getCity_kana();          //*** 市のかな ***//
            this.street = c.getStreet();                      //*** 町 ***//
            this.street_kana = c.getStreet_kana();  //*** 町のかな ***//
        });

        //*** 県名 ＋ 市 ＋ 町名 ***//
        uBean.setU_pre(this.pref);
        uBean.setU_address(String.format("%s%s", this.city, this.street));
        
        return "";
    }

}
