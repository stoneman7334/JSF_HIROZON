/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.OcUserTbl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author j-knakagami2
 */
@Named(value = "ocUserRequestBean")
@RequestScoped
public class OcUserRequestBean {
    @Inject
    private OcUserBean sessionOcUser;                   //*** ***//
    private String user_id;                             //*** ***//
    private String user_name,user_sub_name,user_pass;   //*** ***//
    private boolean card_flg,admin_flg;                 //*** ***//
    private byte[] user_photo;                          //*** ***//
    private Part photoFile;                             //*** ***//
    
    @EJB
    private OcUserTbl db;
    private String errMsg;
    
    @Inject
    private OcUserBean session;
    /**
     * Creates a new instance of OcUserRequestBean
     */
    public OcUserRequestBean() {
    }
    
    //ログアウト処理
    public String looutNext(){
        String nextPage="index";
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext sv = context.getExternalContext();
        HttpSession session = (HttpSession) sv.getSession(false);
        if(session !=null)session.invalidate();
        return nextPage;
    }
    
    //ユーザ削除処理
    public String delUserNext(){
        String nextPage =null;
        if(session.getUser_id()!=null){
            db.delete(session.getUser_id());
            session.setUser_id(null);
            nextPage="index";
        }
        return nextPage;
    }
    
    //ユーザ登録処理
    public String addUserNext() throws IOException{
        String nextPage=null;
        InputStream ioStream= photoFile.getInputStream();
        user_photo = new byte[(int) photoFile.getSize()];
        ioStream.read(user_photo);
        OcUser wUser = new OcUser();
        wUser.setUser_id(user_id);
        wUser.setUser_name(user_name);
        wUser.setUser_sub_name(user_sub_name);
        wUser.setUser_pass(user_pass);
        wUser.setUser_photo(user_photo);
        errMsg=null;
        db.create(wUser);
        if(errMsg==null)
            nextPage="index";        
        return nextPage;
    }
    
    //ログイン処理
    public String loginNext(){
        String nextPage = null;
        OcUser wUser=null;
        wUser = db.loginCheck(user_id, user_pass); 
        if(wUser!=null){
            sessionOcUser.setUser_id(user_id);
            sessionOcUser.setUser_pass(user_pass);
            user_name =  wUser.getUser_name();
            sessionOcUser.setUser_name(user_name);
            user_sub_name = wUser.getUser_sub_name();
            sessionOcUser.setUser_sub_name(user_sub_name);
            user_photo = wUser.getUser_photo();
            sessionOcUser.setUser_photo(user_photo);
            card_flg = wUser.isCard_flg();
            sessionOcUser.setCard_flg(card_flg);
            admin_flg = wUser.isAdmin_flg();
            sessionOcUser.setAdmin_flg(admin_flg);
            nextPage="bbs";
            System.out.println("OcUserBean ->" + wUser.getUser_name()+":" + wUser.getUser_sub_name());
        }
        else{
            user_id=user_pass=null;
        }
        
        return nextPage;
    }
    
    public StreamedContent getPic(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
            return new DefaultStreamedContent();
        }else{
            ExternalContext sv = context.getExternalContext();
            Map<String,String> map = sv.getRequestParameterMap();            
            String key = map.get("user_id");
            DefaultStreamedContent ds=null;
            if(key !=null){
                OcUser e = db.find(key);
                ByteArrayInputStream out = new ByteArrayInputStream(e.getUser_photo());
                ds = new DefaultStreamedContent(out);
            }
            return ds;
        }
    }    

    public Part getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(Part photoFile) {
        this.photoFile = photoFile;
    }

    
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    
    
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sub_name() {
        return user_sub_name;
    }

    public void setUser_sub_name(String user_sub_name) {
        this.user_sub_name = user_sub_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public boolean isCard_flg() {
        return card_flg;
    }

    public void setCard_flg(boolean card_flg) {
        this.card_flg = card_flg;
    }

    public boolean isAdmin_flg() {
        return admin_flg;
    }

    public void setAdmin_flg(boolean admin_flg) {
        this.admin_flg = admin_flg;
    }

    public byte[] getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(byte[] user_photo) {
        this.user_photo = user_photo;
    }
    
    
}
