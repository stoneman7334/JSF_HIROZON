
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 5151021
 */
public class Hint {
    //*** Where句を使ったSQLの書き方
//    public  OcUser loginCheck(String wId,String wPass){
//        boolean flg=false;
//        OcUser wUser =null;
//        TypedQuery<OcUser> query = em.createQuery("select o from OcUser o where o.user_id = ?1 AND o.user_pass = ?2",OcUser.class);
//        query.setParameter(1, wId);
//        query.setParameter(2, wPass);
//        try{
//        wUser = query.getSingleResult();
//        }catch(NoResultException err){
//            userBean.setErrMsg("IDかパスワードが違います");
//        }
//        if(wUser !=null)
//            flg=true;
//        else
//            System.out.println("loginCheck return is null !!!");
//        return wUser;        
//    }
    
    /***
     *  product_detail      
     *  search_result       
     *  top                 
     *  user_cart
     *  user_history
     * 
     *  account                 大馬        
     *  account_menu            大馬        
//     *  admin_add                         OK
//     *  admin_del
//     *  admin_edit                        
//     *  admin_menu
//     *  admin_product
     *  forget                  大馬        OK
     *  login                   大馬
     * 
     * 
     *  mypage                  しゃま
     *  user_address_change     しゃま  
     *  user_mail_change                    OK
     *  user_tel_change                     OK
     *  user_name_change                    OK
     *  user_pass_change                    OK
     *  user_unscribe                       OK
     * 
     */
	
//	NetBeansショートカットのキーバインドを変更するAdd Star
//Ruby, NetBeans, Rails
//
//ツール→オプション→キーマップ→ツールにあります
//    
//    メールアドレスの正規表現　^.*@.*\\..*$|^.*@.*\\..*\\..*$|^.*@.*\\..*\\..*\\..*$
//             このパターンは、@以降にピリオドが１～３個まであるアドレスを許可します
//             ex) shikoku@gmail.com  ehime@yahoo.co.jp  5151xxx@st.hsc.ac.jp などを許可する
    
//    電話番号の正規表現        ^(070|080|090)\\d{4}\\d{4}$|^0\\\\d{3}\\\\d{2}\\\\d{4}$
//              このパターンは、070 080 090からスタートする携帯番号と市外局番から始まる固定電話番号を許可します
//              ハイフンは含まない前提です
//              ex) 08055557777(携帯番号) 　0898777777（市外局番からの固定電話）などを許可する
}
