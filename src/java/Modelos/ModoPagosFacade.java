/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Omarb
 */
@Stateless
public class ModoPagosFacade extends AbstractFacade<ModoPagos> {

    @PersistenceContext(unitName = "BMWMotorradWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModoPagosFacade() {
        super(ModoPagos.class);
    }
    
}
