/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "imagenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i")
    , @NamedQuery(name = "Imagenes.findByIdImagenes", query = "SELECT i FROM Imagenes i WHERE i.idImagenes = :idImagenes")
    , @NamedQuery(name = "Imagenes.findByName", query = "SELECT i FROM Imagenes i WHERE i.name = :name")
    , @NamedQuery(name = "Imagenes.findByRuta", query = "SELECT i FROM Imagenes i WHERE i.ruta = :ruta")})
public class Imagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_imagenes")
    private Integer idImagenes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "ruta")
    private String ruta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImagenes")
    private Collection<DetallesRutas> detallesRutasCollection;

    public Imagenes() {
    }

    public Imagenes(Integer idImagenes) {
        this.idImagenes = idImagenes;
    }

    public Imagenes(Integer idImagenes, String name, String ruta) {
        this.idImagenes = idImagenes;
        this.name = name;
        this.ruta = ruta;
    }

    public Integer getIdImagenes() {
        return idImagenes;
    }

    public void setIdImagenes(Integer idImagenes) {
        this.idImagenes = idImagenes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @XmlTransient
    public Collection<DetallesRutas> getDetallesRutasCollection() {
        return detallesRutasCollection;
    }

    public void setDetallesRutasCollection(Collection<DetallesRutas> detallesRutasCollection) {
        this.detallesRutasCollection = detallesRutasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagenes != null ? idImagenes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.idImagenes == null && other.idImagenes != null) || (this.idImagenes != null && !this.idImagenes.equals(other.idImagenes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
