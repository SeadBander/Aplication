package com.example.onlineaplication.ejb.proizvodi;


import com.example.onlineaplication.ejb.aplikacija.Aplikacija;

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
@Table(name = "proizvodi")
@NamedQueries({
        @NamedQuery(name = "Proizvodi.findAll", query = "SELECT p FROM Proizvodi p"),
        @NamedQuery(name = "Proizvodi.findByProizvodiId", query = "SELECT p FROM Proizvodi p WHERE p.proizvodiId = :proizvodiId"),
        @NamedQuery(name = "Proizvodi.findByVrstaProizvoda", query = "SELECT p FROM Proizvodi p WHERE p.vrstaProizvoda = :vrstaProizvoda"),
        @NamedQuery(name = "Proizvodi.findByTrazeniIznos", query = "SELECT p FROM Proizvodi p WHERE p.trazeniIznos = :trazeniIznos")})
public class Proizvodi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proizvodi_id")
    private Integer proizvodiId;
    @Basic(optional = false)
    @Column(name = "vrsta_proizvoda")
    private String vrstaProizvoda;
    @Basic(optional = false)
    @Column(name = "trazeni_iznos")
    private int trazeniIznos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodi")
    private List<Aplikacija> aplikacijaList;

    public Proizvodi() {
    }

    public Proizvodi(Integer proizvodiId) {
        this.proizvodiId = proizvodiId;
    }

    public Proizvodi(Integer proizvodiId, String vrstaProizvoda, int trazeniIznos) {
        this.proizvodiId = proizvodiId;
        this.vrstaProizvoda = vrstaProizvoda;
        this.trazeniIznos = trazeniIznos;
    }

    public Integer getProizvodiId() {
        return proizvodiId;
    }

    public void setProizvodiId(Integer proizvodiId) {
        this.proizvodiId = proizvodiId;
    }

    public String getVrstaProizvoda() {
        return vrstaProizvoda;
    }

    public void setVrstaProizvoda(String vrstaProizvoda) {
        this.vrstaProizvoda = vrstaProizvoda;
    }

    public int getTrazeniIznos() {
        return trazeniIznos;
    }

    public void setTrazeniIznos(int trazeniIznos) {
        this.trazeniIznos = trazeniIznos;
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
        hash += (proizvodiId != null ? proizvodiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proizvodi)) {
            return false;
        }
        Proizvodi other = (Proizvodi) object;
        if ((this.proizvodiId == null && other.proizvodiId != null) || (this.proizvodiId != null && !this.proizvodiId.equals(other.proizvodiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.onlineaplication.ejb.proizvodi.Proizvodi[ proizvodiId=" + proizvodiId + " ]";
    }

}

