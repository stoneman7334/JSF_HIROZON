/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.User;

/**
 *
 * @author Yuichi-Oba
 */
@Stateless
public class UserDb extends SubDb{

    @PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;

    public void persist(User u) {
        em.persist(u);
    }
	
}
