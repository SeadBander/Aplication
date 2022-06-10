package com.example.onlineaplication.ejb.paketi;


import com.example.onlineaplication.ejb.aplikacija.Aplikacija;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "paketi")
@NamedQueries({
        @NamedQuery(name = "Paketi.findAll", query = "SELECT p FROM Paketi p"),
        @NamedQuery(name = "Paketi.findByPaketiId", query = "SELECT p FROM Paketi p WHERE p.paketiId = :paketiId"),
        @NamedQuery(name = "Paketi.findByNazivPaketa", query = "SELECT p FROM Paketi p WHERE p.nazivPaketa = :nazivPaketa"),
        @NamedQuery(name = "Paketi.findByCijenaPaketa", query = "SELECT p FROM Paketi p WHERE p.cijenaPaketa = :cijenaPaketa")})
public class Paketi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paketi_id")
    private Integer paketiId;
    @Basic(optional = false)
    @Column(name = "naziv_paketa")
    private String nazivPaketa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cijena_paketa")
    private BigDecimal cijenaPaketa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaketa")
    private List<Aplikacija> aplikacijaList;

    public Paketi() {
    }

    public Paketi(Integer paketiId) {
        this.paketiId = paketiId;
    }

    public Paketi(Integer paketiId, String nazivPaketa, BigDecimal cijenaPaketa) {
        this.paketiId = paketiId;
        this.nazivPaketa = nazivPaketa;
        this.cijenaPaketa = cijenaPaketa;
    }

    public Integer getPaketiId() {
        return paketiId;
    }

    public void setPaketiId(Integer paketiId) {
        this.paketiId = paketiId;
    }

    public String getNazivPaketa() {
        return nazivPaketa;
    }

    public void setNazivPaketa(String nazivPaketa) {
        this.nazivPaketa = nazivPaketa;
    }

    public BigDecimal getCijenaPaketa() {
        return cijenaPaketa;
    }

    public void setCijenaPaketa(BigDecimal cijenaPaketa) {
        this.cijenaPaketa = cijenaPaketa;
    }

    public List<Aplikacija> getAplikacijaList() {
        return aplikacijaList;
    }

    public void setAplikacijaList(List<Aplikacija> aplikacijaList) {
        this.aplikacijaList = aplikacijaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paketiId != null ? paketiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paketi)) {
            return false;
        }
        Paketi other = (Paketi) object;
        if ((this.paketiId == null && other.paketiId != null) || (this.paketiId != null && !this.paketiId.equals(other.paketiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.onlineaplication.ejb.paketi.Paketi[ paketiId=" + paketiId + " ]";
    }

}
