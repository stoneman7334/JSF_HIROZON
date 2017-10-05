/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.KakikoDb;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
/**
 *
 * @author j-knakagami2
 */
@Named(value = "kakikoRequest")
@RequestScoped
public class KakikoRequest {
    private String id;
    private String name,msg,day;
    @EJB
    private KakikoDb db;
    @Inject
    private OcUserBean sessionOcUser;
    
    public KakikoRequest() {
    }
    
    public void clear(){
        id=name=msg=day= null;
    }
    
    public String kakikoAddNext(){
        String nextPage=null;
        LocalDateTime t = LocalDateTime.now();
        String now=t.toString();
        Kakiko wKakiko = new Kakiko(sessionOcUser.getUser_name(), msg, now ,sessionOcUser.getUser_id());
        try{
        db.createKakiko(wKakiko);
        clear();
        wKakiko=null;
        }catch(EJBException ex){
            System.out.println("insertエラー："+ ex.getMessage());
        }
        return nextPage;
    }
    
    public List<Kakiko> getAll(){
        return db.getAllKakakio();
    }

    public String getId() {
        return id;
    }
/*
    public void setId(String id) {
        this.id = id;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
}
