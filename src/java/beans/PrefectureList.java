/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author 5151002
 */
@Named(value = "prefList")
@RequestScoped
public class PrefectureList {
    /**
     * Creates a new instance of PrefectureList
     */
    public PrefectureList() {
    }
    
    //*** 県リスト取得 ***//
    public List<SelectItem> getItems() {
        List<SelectItem> items = new ArrayList<>();
//        items.add(new SelectItem("1", "北海道"));
//        items.add(new SelectItem("2", "青森県"));
//        items.add(new SelectItem("3", "岩手県"));
//        items.add(new SelectItem("4", "宮城県"));
//        items.add(new SelectItem("5", "秋田県"));
//        items.add(new SelectItem("6", "山形県"));
//        items.add(new SelectItem("7", "福島県"));
//        items.add(new SelectItem("8", "茨城県"));
//        items.add(new SelectItem("9", "栃木県"));
//        items.add(new SelectItem("10", "群馬県"));
//        items.add(new SelectItem("11", "埼玉県"));
//        items.add(new SelectItem("12", "千葉県"));
//        items.add(new SelectItem("13", "東京都"));
//        items.add(new SelectItem("14", "神奈川県"));
//        items.add(new SelectItem("15", "新潟県"));
//        items.add(new SelectItem("16", "富山県"));
//        items.add(new SelectItem("17", "石川県"));
//        items.add(new SelectItem("18", "福井県"));
//        items.add(new SelectItem("19", "山梨県"));
//        items.add(new SelectItem("20", "長野県"));
//        items.add(new SelectItem("21", "岐阜県"));
//        items.add(new SelectItem("22", "静岡県"));
//        items.add(new SelectItem("23", "愛知県"));
//        items.add(new SelectItem("24", "三重県"));
//        items.add(new SelectItem("25", "滋賀県"));
//        items.add(new SelectItem("26", "京都府"));
//        items.add(new SelectItem("27", "大阪府"));
//        items.add(new SelectItem("28", "兵庫県"));
//        items.add(new SelectItem("29", "奈良県"));
//        items.add(new SelectItem("30", "和歌山県"));
//        items.add(new SelectItem("31", "鳥取県"));
//        items.add(new SelectItem("32", "島根県"));
//        items.add(new SelectItem("33", "岡山県"));
//        items.add(new SelectItem("34", "広島県"));
//        items.add(new SelectItem("35", "山口県"));
//        items.add(new SelectItem("36", "徳島県"));
//        items.add(new SelectItem("37", "香川県"));
//        items.add(new SelectItem("38", "愛媛県"));
//        items.add(new SelectItem("39", "高知県"));
//        items.add(new SelectItem("40", "福岡県"));
//        items.add(new SelectItem("41", "佐賀県"));
//        items.add(new SelectItem("42", "長崎県"));
//        items.add(new SelectItem("43", "熊本県"));
//        items.add(new SelectItem("44", "大分県"));
//        items.add(new SelectItem("45", "宮崎県"));
//        items.add(new SelectItem("46", "鹿児島県"));
//        items.add(new SelectItem("47", "沖縄県"));

        items.add(new SelectItem("北海道"));
        items.add(new SelectItem("青森県"));
        items.add(new SelectItem("岩手県"));
        items.add(new SelectItem("宮城県"));
        items.add(new SelectItem("秋田県"));
        items.add(new SelectItem("山形県"));
        items.add(new SelectItem("福島県"));
        items.add(new SelectItem("茨城県"));
        items.add(new SelectItem("栃木県"));
        items.add(new SelectItem("群馬県"));
        items.add(new SelectItem("埼玉県"));
        items.add(new SelectItem("千葉県"));
        items.add(new SelectItem("東京都"));
        items.add(new SelectItem("神奈川県"));
        items.add(new SelectItem("新潟県"));
        items.add(new SelectItem("富山県"));
        items.add(new SelectItem("石川県"));
        items.add(new SelectItem("福井県"));
        items.add(new SelectItem("山梨県"));
        items.add(new SelectItem("長野県"));
        items.add(new SelectItem("岐阜県"));
        items.add(new SelectItem("静岡県"));
        items.add(new SelectItem("愛知県"));
        items.add(new SelectItem("三重県"));
        items.add(new SelectItem("滋賀県"));
        items.add(new SelectItem("京都府"));
        items.add(new SelectItem("大阪府"));
        items.add(new SelectItem("兵庫県"));
        items.add(new SelectItem("奈良県"));
        items.add(new SelectItem("和歌山県"));
        items.add(new SelectItem("鳥取県"));
        items.add(new SelectItem("島根県"));
        items.add(new SelectItem("岡山県"));
        items.add(new SelectItem("広島県"));
        items.add(new SelectItem("山口県"));
        items.add(new SelectItem("徳島県"));
        items.add(new SelectItem("香川県"));
        items.add(new SelectItem("愛媛県"));
        items.add(new SelectItem("高知県"));
        items.add(new SelectItem("福岡県"));
        items.add(new SelectItem("佐賀県"));
        items.add(new SelectItem("長崎県"));
        items.add(new SelectItem("熊本県"));
        items.add(new SelectItem("大分県"));
        items.add(new SelectItem("宮崎県"));
        items.add(new SelectItem("鹿児島県"));
        items.add(new SelectItem("沖縄県"));
        return  items;
    }
}
