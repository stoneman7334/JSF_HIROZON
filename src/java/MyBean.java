/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author 5151021
 */
@Named(value = "myBean")
@Dependent
public class MyBean {

    private String id;
    /**
     * Creates a new instance of MyBean
     */
    public MyBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
