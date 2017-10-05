/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author 5151021
 */
@Named(value = "pBean")
@RequestScoped
public class ProductBean {

    private Part picture;
    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }
    
    //***  ***//

    public Part getPicture() {
        return picture;
    }
    public void setPicture(Part picture) {
        this.picture = picture;
    }
    
    
}
