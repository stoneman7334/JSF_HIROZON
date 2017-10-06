/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import model.Product;

/**
 *
 * @author 5151021
 */
@Stateless
public class ProductDb extends SubDb{
    
    @PersistenceContext(unitName = "HirozonPU")
	private EntityManager em;
    
    public void persist(Product p){
        //*** 引数のインスタンスをインサートする ***//
        em.persist(p);
    }
    
    
}
