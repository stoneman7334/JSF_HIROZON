/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import beans.ProductBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import model.Product;
import model.User;
import util.V_ProCate;

/**
 *
 * @author 5151021
 */
@Stateless
public class ProductDb extends SubDb {

    @PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;

    //***  ***//
    public void persist(Product p) {
        //*** 引数のインスタンスをインサートする ***//
        em.persist(p);
    }
    //***  ***//

    public Product find(String id) {
        Product p = em.find(Product.class, id);

        return p;
    }

    public List<Product> getAll() {
        return em.createQuery("select p from Product p").getResultList();
    }

    //*** 引数の商品カテゴリの、商品をDB検索するメソッド ***//
    public List<Product> getProOfBook(String category) {
        TypedQuery<Product> query = em.createQuery(
				"select p from Product p where p.c_id = ?1", Product.class);
		query.setParameter(1, category);
		query.setMaxResults(3);
        
        return query.getResultList();
    }

}
