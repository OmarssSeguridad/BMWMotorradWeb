/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Omarb
 */
@Entity
@Table(name = "detalles_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallesPagos.findAll", query = "SELECT d FROM DetallesPagos d")
    , @NamedQuery(name = "DetallesPagos.findByIdDetalle", query = "SELECT d FROM DetallesPagos d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetallesPagos.findByCantidad", query = "SELECT d FROM DetallesPagos d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetallesPagos.findByPrecio", query = "SELECT d FROM DetallesPagos d WHERE d.precio = :precio")
    , @NamedQuery(name = "DetallesPagos.findByPago", query = "SELECT d FROM DetallesPagos d WHERE d.idPago = :idPago")})
public class DetallesPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Long idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    @ManyToOne(optional = false)
    private Pagos idPago;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public DetallesPagos() {
    }

    public DetallesPagos(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetallesPagos(Long idDetalle, int cantidad, double precio) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pagos getIdPago() {
        return idPago;
    }

    public void setIdPago(Pagos idPago) {
        this.idPago = idPago;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesPagos)) {
            return false;
        }
        DetallesPagos other = (DetallesPagos) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.DetallesPagos[ idDetalle=" + idDetalle + " ]";
    }
    
}
