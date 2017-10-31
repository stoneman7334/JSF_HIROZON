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
import javax.persistence.TypedQuery;
import model.ZipCode;

/**
 *
 * @author 5151021
 */
@Stateless
public class ZipCodeDb {
    
    @PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;
    
    //*** 郵便番号を引数に、DB検索した結果のインスタンスを返す ***//
    public List<ZipCode> returnZipCodeInstance(String zipCode){
        //*** 郵便番号から、住所を取得する ***//
        TypedQuery<ZipCode> query = em.createQuery("select a from ZipCode a where a.zipcode = ?1", ZipCode.class);
        query.setParameter(1, zipCode);         //*** 郵便番号をセットする ***//

        return query.getResultList();           //*** 検索結果を返す ***//
    }
}
