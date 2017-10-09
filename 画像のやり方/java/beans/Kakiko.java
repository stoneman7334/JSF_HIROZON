/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author j-knakagami2
 */
@Entity
@Table(name = "kakiko")
public class Kakiko {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name,msg,day;
    private String userId;
    
    public Kakiko() {
    }

    public Kakiko(String name, String msg, String day,String user_id) {
        this.name = name;
        this.msg = msg;
        this.day = day;
        this.userId = user_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
