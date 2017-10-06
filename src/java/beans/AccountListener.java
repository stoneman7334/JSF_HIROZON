/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author j-knakagami2
 */
@Named(value = "accountListener")
@RequestScoped
public class AccountListener {
    @Inject
    OcUserBean session;
    /**
     * Creates a new instance of AccountListener
     */
    public AccountListener() {
    }
    
    public void check() {
        if(session.getUser_id() ==null) {
            // 存在しない場合、ログイン画面へ強制遷移する。
            FacesContext facesContext = FacesContext.getCurrentInstance();
            
            //(1)HttServletResponse使用パターン
            ExternalContext sv = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) sv.getResponse();
            try {
                response.sendRedirect("/bbs/faces/index.xhtml");
                
            } catch (IOException ex) {
                Logger.getLogger(AccountListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            //(1)HttServletResponse使用パターン
            
            /*(2)JSF
                ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)facesContext.getApplication().getNavigationHandler();
                nav.performNavigation("/index.xhtml?faces-redirect=true");
            */
        }
    }    
}
