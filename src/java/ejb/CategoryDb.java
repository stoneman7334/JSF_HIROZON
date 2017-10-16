/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Category;

/**
 *
 * @author 5151021
 */
@Stateless
public class CategoryDb extends SubDb{
    
	@PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;
	
	public List<Category> getAll(){
		return em.createQuery("select c from Category c").getResultList();
	}
	
	
}
