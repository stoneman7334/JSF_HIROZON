/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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

    @PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;

    //*** new regist ***//
    public void persist(Cart c) {
        em.persist(c);
    }
    
}
