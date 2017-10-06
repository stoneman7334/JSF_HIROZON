/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import beans.OcUser;
import beans.OcUserRequestBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author j-knakagami2
 */
@Stateless
public class OcUserTbl {
    @Inject
    private OcUserRequestBean userBean;
    @PersistenceContext
    private EntityManager em;

    public void create(OcUser wUser){
        try{
            if(find(wUser.getUser_id())==null)
                em.persist(wUser);
            else
                userBean.setErrMsg("登録済みIDです");
        }catch(EntityExistsException err){
            userBean.setErrMsg("登録済みIDです");
        }
    }
    
    public List<OcUser> getAll(){
        return em.createQuery("select o from OcUser o", OcUser.class).getResultList();
    }
    
    public  OcUser loginCheck(String wId,String wPass){
        boolean flg=false;
        OcUser wUser =null;
        TypedQuery<OcUser> query = em.createQuery("select o from OcUser o where o.user_id = ?1 AND o.user_pass = ?2",OcUser.class);
        query.setParameter(1, wId);
        query.setParameter(2, wPass);
        try{
        wUser = query.getSingleResult();
        }catch(NoResultException err){
            userBean.setErrMsg("IDかパスワードが違います");
        }
        if(wUser !=null)
            flg=true;
        else
            System.out.println("loginCheck return is null !!!");
        return wUser;        
    }
    
    public OcUser find(String wId){
        return em.find(OcUser.class, wId);
    }
    
    public void  delete(String wId){
        OcUser wUser = em.find(OcUser.class, wId);
        em.remove(wUser);
    }
}
