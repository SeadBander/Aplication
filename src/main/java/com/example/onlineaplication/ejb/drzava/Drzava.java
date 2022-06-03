package com.example.onlineaplication.ejb.drzava;


import com.example.onlineaplication.ejb.grad.Grad;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author SEJO
 */
@Entity
@Table(name = "drzava")
@NamedQueries({
        @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d"),
        @NamedQuery(name = "Drzava.findByDrzavaId", query = "SELECT d FROM Drzava d WHERE d.drzavaId = :drzavaId"),
        @NamedQuery(name = "Drzava.findByNazivDrzave", query = "SELECT d FROM Drzava d WHERE d.nazivDrzave = :nazivDrzave")})
public class Drzava implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "drzava_id")
    private Integer drzavaId;
    @Basic(optional = false)
    @Column(name = "naziv_drzave")
    private String nazivDrzave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDrzava")
    private List<Grad> gradList;

    public Drzava() {
    }

    public Drzava(Integer drzavaId) {
        this.drzavaId = drzavaId;
    }

    public Drzava(Integer drzavaId, String nazivDrzave) {
        this.drzavaId = drzavaId;
        this.nazivDrzave = nazivDrzave;
    }

    public Integer getDrzavaId() {
        return drzavaId;
    }

    public void setDrzavaId(Integer drzavaId) {
        this.drzavaId = drzavaId;
    }

    public String getNazivDrzave() {
        return nazivDrzave;
    }

    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }

    public List<Grad> getGradList() {
        return gradList;
    }

    public void setGradList(List<Grad> gradList) {
        this.gradList = gradList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drzavaId != null ? drzavaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drzava)) {
            return false;
        }
        Drzava other = (Drzava) object;
        if ((this.drzavaId == null && other.drzavaId != null) || (this.drzavaId != null && !this.drzavaId.equals(other.drzavaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.onlineaplication.ejb.drzava.Drzava[ drzavaId=" + drzavaId + " ]";
    }

}

