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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Cart;
import model.User;
import util.Util;

/**
 *
 * @author 5151021
 */
@Stateless
public class CartDb extends SubDb {

    public static final String Q_CART_USER			= "select c from Cart c WHERE c.u_id = ?1";
	public static final String Q_DELETE_CART_CURSOR = "Delete from Cart c where c.u_id = ?1 and c.p_id = ?2 and c.dateTime = ?3";
	public static final String Q_DELETE_CART_ALL	= "delete from Cart c where c.u_id = ?1";
	public static final String Q_SELECT_CHECK_DUPLICATE = "select c from Cart c where c.u_id = ?1 and c.p_id = ?2";
    public static final String DATE_PATTERN			= "yyyy-MM-dd HH:mm:ss.S";
	
	@PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;

    //*** カートインスタンスを新規登録する ***//
    public void persist(Cart c) {
        em.persist(c);
    }
	//*** カートの中身の重複チェックを行う ***//
	public int checkDuplicateCart(Cart c){
		System.out.println("call CartDb->checkDuplicateCart()");
		
		TypedQuery<Cart> query = em.createQuery(Q_SELECT_CHECK_DUPLICATE, Cart.class);
		query.setParameter(1, c.getU_id());	//*** ユーザID ***//
		query.setParameter(2, c.getP_id());	//*** 商品ID ***//
		
		Cart cc = null;
		try {
			cc = query.getSingleResult();	//*** SQL Excute ***//
		} catch(NoResultException e){
			//*** 検索結果がないとき、catchされる ***//
			System.out.println("カートの中身に重複なし");
			return 0;	//*** 重複あり ***//
		}
		System.out.println("カートの中身に重複あり");
		return 1;	//*** 重複なし ***//
	}
	
	//*** DB検索した結果のカートインスタンスのリストを返す ***//
    public List<Cart> returnCart(String u_id) {
        System.out.println("call CartDb->returnCart()");
        System.out.println(String.format("param : %s", u_id));
        
		TypedQuery<Cart> query = em.createQuery(Q_CART_USER, Cart.class);
        query.setParameter(1, u_id);

        return query.getResultList();	
    }
	//*** 引数のカートインスタンスを削除するメソッド ***//
    public int delCartCursor(Cart c) throws ParseException {
        String dateTime = c.getDateTime();
        Date date = new SimpleDateFormat(DATE_PATTERN).parse(dateTime);
        int deleteted = em.createQuery(Q_DELETE_CART_CURSOR)
                .setParameter(1, c.getU_id())       //*** ユーザID ***//
                .setParameter(2, c.getP_id())       //*** 商品ID ***//
                .setParameter(3, date)				//*** カートに追加した日時 ***//
                .executeUpdate();
		Util.easyLog(String.valueOf(deleteted));
        return deleteted;   //*** 削除した行数を返す　1: OK  0: NG ***//
    }
	//***  ***//
	public int delAllProduct(String u_id){
		//***  ***//
		return em.createQuery(Q_DELETE_CART_ALL, Cart.class)
				.setParameter(1, u_id)	//***  ***//
				.executeUpdate();		//***  ***//
	}
	//*** カートの中身の件数を返すメソッド ***//
	public int cursorCount(){
		TypedQuery<Cart> query = em.createQuery("select count(p) from Product p", Cart.class);
		
		return query.getResultList().size();
	}

}
