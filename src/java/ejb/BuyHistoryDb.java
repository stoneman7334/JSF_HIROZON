/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.BuyHistory;

/**
 *
 * @author 5151021
 */
public class BuyHistoryDb extends SubDb{
    @PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;
    
    //*** 購入履歴挿入 ***//
    public void persist(BuyHistory bh) {
        em.persist(bh);
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
