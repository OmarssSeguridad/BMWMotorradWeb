/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Omarb
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p")
    , @NamedQuery(name = "Pagos.findByIdPago", query = "SELECT p FROM Pagos p WHERE p.idPago = :idPago")
    , @NamedQuery(name = "Pagos.findByFecha", query = "SELECT p FROM Pagos p WHERE p.fecha = :fecha")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Long idPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPago")
    private Collection<DetallesPagos> detallesPagosCollection;
    @JoinColumn(name = "id_modopago", referencedColumnName = "id_modopago")
    @ManyToOne(optional = false)
    private ModoPagos idModopago;
    @JoinColumn(name = "id_motociclista", referencedColumnName = "id_motociclista")
    @ManyToOne(optional = false)
    private Motociclistas idMotociclista;

    public Pagos() {
    }

    public Pagos(Long idPago) {
        this.idPago = idPago;
    }

    public Pagos(Long idPago, Date fecha) {
        this.idPago = idPago;
        this.fecha = fecha;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<DetallesPagos> getDetallesPagosCollection() {
        return detallesPagosCollection;
    }

    public void setDetallesPagosCollection(Collection<DetallesPagos> detallesPagosCollection) {
        this.detallesPagosCollection = detallesPagosCollection;
    }

    public ModoPagos getIdModopago() {
        return idModopago;
    }

    public void setIdModopago(ModoPagos idModopago) {
        this.idModopago = idModopago;
    }

    public Motociclistas getIdMotociclista() {
        return idMotociclista;
    }

    public void setIdMotociclista(Motociclistas idMotociclista) {
        this.idMotociclista = idMotociclista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Pagos[ idPago=" + idPago + " ]";
    }
    
}
