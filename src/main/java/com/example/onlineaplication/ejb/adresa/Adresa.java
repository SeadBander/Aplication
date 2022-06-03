package com.example.onlineaplication.ejb.adresa;


import com.example.onlineaplication.ejb.grad.Grad;
import com.example.onlineaplication.ejb.klijenti.Klijenti;

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
@Table(name = "adresa")
@NamedQueries({
        @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a"),
        @NamedQuery(name = "Adresa.findByAdresaId", query = "SELECT a FROM Adresa a WHERE a.adresaId = :adresaId"),
        @NamedQuery(name = "Adresa.findByUlica", query = "SELECT a FROM Adresa a WHERE a.ulica = :ulica"),
        @NamedQuery(name = "Adresa.findByBroj", query = "SELECT a FROM Adresa a WHERE a.broj = :broj")})
public class Adresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adresa_id")
    private Integer adresaId;
    @Basic(optional = false)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @Column(name = "broj")
    private String broj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdresa")
    private List<Klijenti> klijentiList;
    @JoinColumn(name = "id_grad", referencedColumnName = "grad_id")
    @ManyToOne(optional = false)
    private Grad idGrad;

    public Adresa() {
    }

    public Adresa(Integer adresaId) {
        this.adresaId = adresaId;
    }

    public Adresa(Integer adresaId, String ulica, String broj) {
        this.adresaId = adresaId;
        this.ulica = ulica;
        this.broj = broj;
    }

    public Integer getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Integer adresaId) {
        this.adresaId = adresaId;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public List<Klijenti> getKlijentiList() {
        return klijentiList;
    }

    public void setKlijentiList(List<Klijenti> klijentiList) {
        this.klijentiList = klijentiList;
    }

    public Grad getIdGrad() {
        return idGrad;
    }

    public void setIdGrad(Grad idGrad) {
        this.idGrad = idGrad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adresaId != null ? adresaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.adresaId == null && other.adresaId != null) || (this.adresaId != null && !this.adresaId.equals(other.adresaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.onlineaplication.ejb.adresa.Adresa[ adresaId=" + adresaId + " ]";
    }

}
