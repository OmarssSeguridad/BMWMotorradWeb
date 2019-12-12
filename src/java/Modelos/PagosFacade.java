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
public class PagosFacade extends AbstractFacade<Pagos> {

    @PersistenceContext(unitName = "BMWMotorradWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagosFacade() {
        super(Pagos.class);
    }

    public List<Pagos> ConsultarPagos() {
        Query consulta = em.createNamedQuery("Pagos.findAll", Pagos.class);
        List<Pagos> lista = consulta.getResultList();
        return lista;
    }
}
