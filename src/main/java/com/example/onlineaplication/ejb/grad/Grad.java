package com.example.onlineaplication.ejb.grad;


import com.example.onlineaplication.ejb.adresa.Adresa;
import com.example.onlineaplication.ejb.drzava.Drzava;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author SEJO
 */
@Entity
@Table(name = "grad")
@NamedQueries({
        @NamedQuery(name = "Grad.findAll", query = "SELECT g FROM Grad g"),
        @NamedQuery(name = "Grad.findByGradId", query = "SELECT g FROM Grad g WHERE g.gradId = :gradId"),
        @NamedQuery(name = "Grad.findByNazivGrada", query = "SELECT g FROM Grad g WHERE g.nazivGrada = :nazivGrada")})
public class Grad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grad_id")
    private Integer gradId;
    @Basic(optional = false)
    @Column(name = "naziv_grada")
    private String nazivGrada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrad")
    private List<Adresa> adresaList;
    @JoinColumn(name = "id_drzava", referencedColumnName = "drzava_id")
    @ManyToOne(optional = false)
    private Drzava idDrzava;

    public Grad() {
    }

    public Grad(Integer gradId) {
        this.gradId = gradId;
    }

    public Grad(Integer gradId, String nazivGrada) {
        this.gradId = gradId;
        this.nazivGrada = nazivGrada;
    }

    public Integer getGradId() {
        return gradId;
    }

    public void setGradId(Integer gradId) {
        this.gradId = gradId;
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }

    public List<Adresa> getAdresaList() {
        return adresaList;
    }

    public void setAdresaList(List<Adresa> adresaList) {
        this.adresaList = adresaList;
    }

    public Drzava getIdDrzava() {
        return idDrzava;
    }

    public void setIdDrzava(Drzava idDrzava) {
        this.idDrzava = idDrzava;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gradId != null ? gradId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grad)) {
            return false;
        }
        Grad other = (Grad) object;
        if ((this.gradId == null && other.gradId != null) || (this.gradId != null && !this.gradId.equals(other.gradId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.onlineaplication.ejb.grad.Grad[ gradId=" + gradId + " ]";
    }

}
