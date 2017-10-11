/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

//import java.util.Arrays;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	
	//*** 引数のインスタンスを新規登録するメソッド ***//
	public void persist(User u) {
		em.persist(u);
	}
	//*** 指定したID passのユーザのインスタンスを返すメソッド ***//
	public User find(String id, String pass) {
		User u = null;

		TypedQuery<User> query = em.createQuery("select u from User u where u.u_Id = ?1 and u.u_pass = ?2", User.class); //***  ***//
		query.setParameter(1, id);      //*** IDをセット ***//
		query.setParameter(2, pass);    //*** pass（ハッシュ済み）をセット ***//
                try {
                    u = query.getSingleResult();    //*** 結果の取得 ***//
                } catch (NoResultException e) {
                    
                }

		return u;      //*** Userクラスのインスタンスを返す ***//
	}
	//*** 指定したIDのユーザのインスタンスを返すメソッド ***//
	public User find(String id){
		return em.find(User.class, id);
	}
	//*** 指定されたユーザIDに重複がないかチェックするメソッド ***//
	public boolean checkDuplicateUserId(String id) {
		TypedQuery<User> query = em.createQuery(
				"select u from User u where u.u_Id = ?1", User.class);
		query.setParameter(1, id);			//***  ***//
		User u;
		try {
			u = query.getSingleResult();	//***  ***//
		} catch (NoResultException e) {
			return true;
		}// TODO IDの重複チェックはどうする？？
		return false;
	}
	//*** 指定したインスタンスでDB updateを行うメソッド ***//
	public User merge(User user) {
		em.merge(user);
		return user;
	}
        //*** 指定したインスタンスでDB deleteを行うメソッド ***//
        public void remove(User user) {
            em.remove(em.merge(user));
        }
}
