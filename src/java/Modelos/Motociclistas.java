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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Omarb
 */
@Entity
@Table(name = "motociclistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motociclistas.findAll", query = "SELECT m FROM Motociclistas m")
    , @NamedQuery(name = "Motociclistas.findByIdMotociclista", query = "SELECT m FROM Motociclistas m WHERE m.idMotociclista = :idMotociclista")
    , @NamedQuery(name = "Motociclistas.findByName", query = "SELECT m FROM Motociclistas m WHERE m.name = :name")
    , @NamedQuery(name = "Motociclistas.findByAp", query = "SELECT m FROM Motociclistas m WHERE m.ap = :ap")
    , @NamedQuery(name = "Motociclistas.findByAm", query = "SELECT m FROM Motociclistas m WHERE m.am = :am")
    , @NamedQuery(name = "Motociclistas.findByDireccion", query = "SELECT m FROM Motociclistas m WHERE m.direccion = :direccion")
    , @NamedQuery(name = "Motociclistas.findByFecNac", query = "SELECT m FROM Motociclistas m WHERE m.fecNac = :fecNac")
    , @NamedQuery(name = "Motociclistas.findByTelefono", query = "SELECT m FROM Motociclistas m WHERE m.telefono = :telefono")
    , @NamedQuery(name = "Motociclistas.findByEmail", query = "SELECT m FROM Motociclistas m WHERE m.email = :email")})
public class Motociclistas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motociclista")
    private Long idMotociclista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "ap")
    private String ap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "am")
    private String am;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecNac")
    @Temporal(TemporalType.DATE)
    private Date fecNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotociclista")
    private Collection<DetallesRutas> detallesRutasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotociclista")
    private Collection<Pagos> pagosCollection;

    public Motociclistas() {
    }

    public Motociclistas(Long idMotociclista) {
        this.idMotociclista = idMotociclista;
    }

    public Motociclistas(Long idMotociclista, String name, String ap, String am, String direccion, Date fecNac, int telefono, String email) {
        this.idMotociclista = idMotociclista;
        this.name = name;
        this.ap = ap;
        this.am = am;
        this.direccion = direccion;
        this.fecNac = fecNac;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getIdMotociclista() {
        return idMotociclista;
    }

    public void setIdMotociclista(Long idMotociclista) {
        this.idMotociclista = idMotociclista;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<DetallesRutas> getDetallesRutasCollection() {
        return detallesRutasCollection;
    }

    public void setDetallesRutasCollection(Collection<DetallesRutas> detallesRutasCollection) {
        this.detallesRutasCollection = detallesRutasCollection;
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
        hash += (idMotociclista != null ? idMotociclista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motociclistas)) {
            return false;
        }
        Motociclistas other = (Motociclistas) object;
        if ((this.idMotociclista == null && other.idMotociclista != null) || (this.idMotociclista != null && !this.idMotociclista.equals(other.idMotociclista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Motociclistas[ idMotociclista=" + idMotociclista + " ]";
    }
    
}
