/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.CategoryDb;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Category;

/**
 *
 * @author Yuichi-Oba
 */
@Named(value = "cateBean")
@RequestScoped
public class CategoryBean {

	@EJB
	private CategoryDb db;
	
	public CategoryBean() {
	}
	
	public List<Category> getItems(){
		return db.getAll();
	}
	
}
