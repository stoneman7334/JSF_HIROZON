
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
}
