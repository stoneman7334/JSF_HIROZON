/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import beans.Kakiko;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.FacesException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author j-knakagami2
 */
@Stateless
public class KakikoDb {
@PersistenceContext
private EntityManager em;

    public KakikoDb() {
    }

    public void createKakiko(Kakiko wKakiko)throws EJBException{
        em.persist(wKakiko);
    }
    
    public List<Kakiko> getAllKakakio(){
        return em.createQuery("select k from Kakiko k ORDER BY k.day DESC", Kakiko.class).getResultList();
        //return em.createNativeQuery("select * from kakiko order by day desc" , Kakiko.class).getResultList();
        
    }
}
