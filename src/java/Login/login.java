/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Modelos.UsersFacade;
import Modelos.Users;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
//import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Omars
 */
//@Named(value = "login")
@ManagedBean(name = "login")
@SessionScoped
public class login implements Serializable {

    private HttpServletRequest session;
    private String email;
    private String password;

    @EJB
    private UsersFacade ejbFacade;
    private Users user;


    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    public login() {
        session = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public void logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/inicio.xhtml");
        } catch (Exception e) {
        }
    }

    public void Acceso() throws IOException {
        session = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        user = ejbFacade.Buscar(email, password);
        
        if (user != null) {
            System.out.println("Entro al Acceso");
            Login_MB user_session = new Login_MB();
            user_session.setUsername(user.getEmail());
            user_session.setPassword(user.getPassword());
            user_session.setNvl(user.getNvlUser());
            session.getSession().setAttribute("user", user_session);
            switch (user.getNvlUser()) {
                case 1:
                    System.out.println("entre a admin en el 1 Acceso");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/views/pagos/Create.xhtml");
                    
                    break;
                case 2:
                    System.out.println("entre a user en el 1 Acceso");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/user/pagos/Create.xhtml");
                    break;
                default:
                    System.out.println("Entre en default");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/views/login/error.xhtml");
                    break;
            }

        } else {
            System.out.println("no hay usuario");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o password incorrecto", null));
        }
    }

    public void principal() throws IOException{
        session = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Login_MB  user= (Login_MB) session.getSession().getAttribute("user");
        if (user != null) {
            switch (user.getNvl()) {
                case 1:
                System.out.println("entre a admin en el 2 principal");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/views/pagos/Create.xhtml");
                    break;  
                case 2:
                System.out.println("entre a user en el 2 principal");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/user/pagos/Create.xhtml");
                    break;
                default:
                    System.out.println("entre a default en el 2 principal");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/views/login/error.xhtml");
                    
                    break;
            }

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/views/login/error.xhtml");
        }
    }
    public void validateSession(int nivel) throws IOException {
        session = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Login_MB user = (Login_MB) session.getSession().getAttribute("user");
        if (user != null) {
            if (nivel != 100) {
                if (user.getNvl() == nivel) {
                } else {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/views/login/error.xhtml");
                }
            }
        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/BMWMotorradWeb/faces/views/login/error.xhtml");
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

