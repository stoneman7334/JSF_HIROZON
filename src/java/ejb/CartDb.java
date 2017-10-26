/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Cart;
import model.User;

/**
 *
 * @author 5151021
 */
@Stateless
public class CartDb extends SubDb {

    public static final String Q_CART_USER = "select c from Cart c WHERE c.u_id = ?1";
    @PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;

    //*** new regist ***//
    public void persist(Cart c) {
        em.persist(c);
    }

    public List<Cart> returnCart(String u_id) {
        System.out.println("call CartDb->returnCart()");
        System.out.println(String.format("param : %s", u_id));
        TypedQuery<Cart> query = em.createQuery(Q_CART_USER, Cart.class);
        query.setParameter(1, u_id);

        return query.getResultList();
    }
//    
//    public Cart find(String u_id, String p_id){
//    }

    public int delCartCursor(Cart c) throws ParseException {
        String dateTime = c.getDateTime();
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(dateTime);
        int deleteted = em.createQuery(
                "Delete from Cart c where c.u_id = ?1 and c.p_id = ?2 and c.dateTime = ?3")
                .setParameter(1, c.getU_id())       //*** ユーザID ***//
                .setParameter(2, c.getP_id())       //*** 商品ID ***//
                .setParameter(3, date)   //*** カートに追加した日時 ***//
                .executeUpdate();
		util.Util.easyLog(String.valueOf(deleteted));
        return deleteted;   //***  ***//
    }

}
