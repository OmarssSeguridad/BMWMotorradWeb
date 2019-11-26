/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Omarb
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "BMWMotorradWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
     public Users Buscar(String usu, String pas) {
        Query consulta = em.createNamedQuery("Users.buscar", Users.class)
                .setParameter("email", usu)
                .setParameter("password", pas);
         System.out.println(usu);
         System.out.println(pas);
         System.out.println(consulta.getResultList());
        List<Users> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            System.out.println(lista.get(0));
            return lista.get(0);
            
        }
        return null;
    }

    public Users uniqueUsername(String usu) {
        Query consulta = em.createNamedQuery("Users.usernameuq", Users.class)
                .setParameter("username", usu);
        List<Users> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }

    public Users uniqueMail(String mail) {
        Query consulta = em.createNamedQuery("Users.mailuq", Users.class)
                .setParameter("mail", mail);
        List<Users> lista = consulta.getResultList();
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }

}
