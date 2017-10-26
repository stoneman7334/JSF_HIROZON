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
	
	public static final String Q_SELECT_PRODUCT_CATEGORY = "select p from Product p where p.c_id = ?1";
	public static final String Q_SELECT_SEARCH_CHARACTER = "select p from Product p where p.p_name like ?1";

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
        TypedQuery<Product> query = em.createQuery(Q_SELECT_PRODUCT_CATEGORY, Product.class);
		query.setParameter(1, category);	//*** カ	テゴリID ***//
		query.setMaxResults(3);				//*** 結果の最大件数 ： ３件まで ***//
        
        return query.getResultList();
    }
	
	//***  ***//
	public List<Product> getSearchCharacter(String args){
		TypedQuery<Product> query = em.createQuery(Q_SELECT_SEARCH_CHARACTER, Product.class);
		query.setParameter(1, args);		//*** 検索ボックスに入力した文字列 ***//
		query.setMaxResults(10);			//*** 結果の最大件数 ： １０件 ***//
		
		return query.getResultList();
	}

	public void update(Product p) {
		em.merge(p);
	}

}
