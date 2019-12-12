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
public class DetallesPagosFacade extends AbstractFacade<DetallesPagos> {

    @PersistenceContext(unitName = "BMWMotorradWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallesPagosFacade() {
        super(DetallesPagos.class);
    }
   public List<DetallesPagos> ConsultarIdPago(Pagos idPago)
    {
        Query consulta = em.createNamedQuery("DetallesPagos.findByPago", DetallesPagos.class)
                .setParameter("idPago", idPago);
        List<DetallesPagos> lista = consulta.getResultList();
        return lista;
    }
}
