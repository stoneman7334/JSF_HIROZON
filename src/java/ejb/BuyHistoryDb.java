/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.BuyHistory;
import model.Cart;

/**
 *
 * @author 5151021
 */
@Stateless
public class BuyHistoryDb extends SubDb {

	@PersistenceContext(unitName = "HirozonPU")
	private EntityManager em;

	//*** ---------------------------- ***//
	//*** ----- SELF MADE METHOD ----- ***//
	//*** ---------------------------- ***//
	//*** 購入履歴挿入 ***//
	public void persist(List<Cart> carts) {
		util.Util.easyLog("call BuyHistoryDb.persist()");
//        em.persist(bh);
		carts.forEach(c -> {
			//*** BuyHistoryのインスタンスを生成 ***//
			BuyHistory bh = new BuyHistory(
					c.getU_id(), //*** ユーザID ***//
					new Date(), //*** 購入日時 ***//
					c.getCount(), //*** 個数 ***//
					c.getPrice(), //*** 価格 ***//
					c.getP_id() //*** 商品ID ***//
			);

			em.persist(bh);	//*** 購入履歴テーブルへ挿入する ***//
		});
	}
	//*** ユーザーで購入履歴検索 ***//
	public List<BuyHistory> userFind(String u_id) {
		List<BuyHistory> item = new ArrayList<>();
		//*** SQL文 ***//
		TypedQuery<BuyHistory> query = em.createQuery("select b from BuyHistory b where b.u_id = ?1", BuyHistory.class);
		query.setParameter(1, u_id);
		item = query.getResultList();
		return item;
	}

}
