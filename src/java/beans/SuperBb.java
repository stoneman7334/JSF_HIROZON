/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Cart;

/**
 *
 * @author 5151021
 */
public class SuperBb implements Serializable{
	
	public List<Cart> cart;
	
	public void init(){
		cart = new ArrayList<>();
	}
	
	
    
}
