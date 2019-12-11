/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Omarb
 */
@Entity
@Table(name = "modo_pagos")
@XmlRootElement
@SessionScoped
@NamedQueries({
    @NamedQuery(name = "ModoPagos.findAll", query = "SELECT m FROM ModoPagos m")
    , @NamedQuery(name = "ModoPagos.findByIdModopago", query = "SELECT m FROM ModoPagos m WHERE m.idModopago = :idModopago")
    , @NamedQuery(name = "ModoPagos.findByName", query = "SELECT m FROM ModoPagos m WHERE m.name = :name")
    , @NamedQuery(name = "ModoPagos.findByDetalle", query = "SELECT m FROM ModoPagos m WHERE m.detalle = :detalle")})
public class ModoPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modopago")
    private Long idModopago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "detalle")
    private String detalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModopago")
    private Collection<Pagos> pagosCollection;

    public ModoPagos() {
    }

    public ModoPagos(Long idModopago) {
        this.idModopago = idModopago;
    }

    public ModoPagos(Long idModopago, String name, String detalle) {
        this.idModopago = idModopago;
        this.name = name;
        this.detalle = detalle;
    }

    public Long getIdModopago() {
        return idModopago;
    }

    public void setIdModopago(Long idModopago) {
        this.idModopago = idModopago;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public Collection<Pagos> getPagosCollection() {
        return pagosCollection;
    }

    public void setPagosCollection(Collection<Pagos> pagosCollection) {
        this.pagosCollection = pagosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModopago != null ? idModopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModoPagos)) {
            return false;
        }
        ModoPagos other = (ModoPagos) object;
        if ((this.idModopago == null && other.idModopago != null) || (this.idModopago != null && !this.idModopago.equals(other.idModopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
