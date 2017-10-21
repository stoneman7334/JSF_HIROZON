/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
