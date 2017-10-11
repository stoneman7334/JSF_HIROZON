/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author 5151002
 */
@Named(value = "prefList")
@RequestScoped
public class PrefectureList {

    //*** 都道府県のリスト ***//
    private List<String> prefList;
    /**
     * Creates a new instance of PrefectureList
     */
    public PrefectureList() {
    }
    
    
}
