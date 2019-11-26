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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Omarb
 */
@Entity
@Table(name = "detalles_rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallesRutas.findAll", query = "SELECT d FROM DetallesRutas d")
    , @NamedQuery(name = "DetallesRutas.findByIdDetalleruta", query = "SELECT d FROM DetallesRutas d WHERE d.idDetalleruta = :idDetalleruta")
    , @NamedQuery(name = "DetallesRutas.findByStatus", query = "SELECT d FROM DetallesRutas d WHERE d.status = :status")})
public class DetallesRutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalleruta")
    private Long idDetalleruta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_imagenes", referencedColumnName = "id_imagenes")
    @ManyToOne(optional = false)
    private Imagenes idImagenes;
    @JoinColumn(name = "id_motociclista", referencedColumnName = "id_motociclista")
    @ManyToOne(optional = false)
    private Motociclistas idMotociclista;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    @ManyToOne(optional = false)
    private Rutas idRuta;

    public DetallesRutas() {
    }

    public DetallesRutas(Long idDetalleruta) {
        this.idDetalleruta = idDetalleruta;
    }

    public DetallesRutas(Long idDetalleruta, String status) {
        this.idDetalleruta = idDetalleruta;
        this.status = status;
    }

    public Long getIdDetalleruta() {
        return idDetalleruta;
    }

    public void setIdDetalleruta(Long idDetalleruta) {
        this.idDetalleruta = idDetalleruta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Imagenes getIdImagenes() {
        return idImagenes;
    }

    public void setIdImagenes(Imagenes idImagenes) {
        this.idImagenes = idImagenes;
    }

    public Motociclistas getIdMotociclista() {
        return idMotociclista;
    }

    public void setIdMotociclista(Motociclistas idMotociclista) {
        this.idMotociclista = idMotociclista;
    }

    public Rutas getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Rutas idRuta) {
        this.idRuta = idRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleruta != null ? idDetalleruta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesRutas)) {
            return false;
        }
        DetallesRutas other = (DetallesRutas) object;
        if ((this.idDetalleruta == null && other.idDetalleruta != null) || (this.idDetalleruta != null && !this.idDetalleruta.equals(other.idDetalleruta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.DetallesRutas[ idDetalleruta=" + idDetalleruta + " ]";
    }
    
}
