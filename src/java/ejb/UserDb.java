/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

//import java.util.Arrays;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.User;

/**
 *
 * @author Yuichi-Oba
 */
@Stateless
public class UserDb {

    @PersistenceContext(unitName = "HirozonPU")
    private EntityManager em;

    public void persist(User u) {
        em.persist(u);
    }

    public User find(String id, String pass) {
        User u = null;

        TypedQuery<User> query = em.createQuery("select u from User u where u.u_Id = ?1 and u.u_pass = ?2", User.class); //***  ***//
        query.setParameter(1, id);      //***  ***//
        query.setParameter(2, pass);    //***  ***//
        System.out.println(em.getProperties());
        System.out.println(em.getMetamodel());
        System.out.println(em.getEntityManagerFactory());

        u = query.getSingleResult();    //***  ***//

        return u;      //***  ***//
    }
    
    public User merge(User user){
        em.merge(user);
        return user;
    }
}
