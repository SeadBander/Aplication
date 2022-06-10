package com.example.onlineaplication.ejb.aplikacija;


import com.example.onlineaplication.ejb.klijenti.Klijenti;
import com.example.onlineaplication.ejb.paketi.Paketi;
import com.example.onlineaplication.ejb.proizvodi.Proizvodi;
import com.example.onlineaplication.ejb.statusAplikacije.StatusAplikacije;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SEJO
 */
@Entity
@Table(name = "aplikacija")
@NamedQueries({
        @NamedQuery(name = "Aplikacija.findAll", query = "SELECT a FROM Aplikacija a"),
        @NamedQuery(name = "Aplikacija.findByIdProizvoda", query = "SELECT a FROM Aplikacija a WHERE a.idProizvoda = :idProizvoda"),
        @NamedQuery(name = "Aplikacija.findByDatumAplikacije", query = "SELECT a FROM Aplikacija a WHERE a.datumAplikacije = :datumAplikacije")})
public class Aplikacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proizvoda")
    private Integer idProizvoda;
    @Basic(optional = false)
    @Column(name = "datum_aplikacije")
    @Temporal(TemporalType.DATE)
    private Date datumAplikacije;
    @JoinColumn(name = "id_klijenta", referencedColumnName = "klijent_id")
    @ManyToOne(optional = false)
    private Klijenti idKlijenta;
    @JoinColumn(name = "id_paketa", referencedColumnName = "paketi_id")
    @ManyToOne(optional = false)
    private Paketi idPaketa;
    @JoinColumn(name = "id_proizvoda", referencedColumnName = "proizvodi_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Proizvodi proizvodi;
    @JoinColumn(name = "id_status", referencedColumnName = "status_aplikacije_id")
    @ManyToOne(optional = false)
    private StatusAplikacije idStatus;

    public Aplikacija() {
    }

    public Aplikacija(Integer idProizvoda) {
        this.idProizvoda = idProizvoda;
    }

    public Aplikacija(Integer idProizvoda, Date datumAplikacije) {
        this.idProizvoda = idProizvoda;
        this.datumAplikacije = datumAplikacije;
    }

    public Integer getIdProizvoda() {
        return idProizvoda;
    }

    public void setIdProizvoda(Integer idProizvoda) {
        this.idProizvoda = idProizvoda;
    }

    public Date getDatumAplikacije() {
        return datumAplikacije;
    }

    public void setDatumAplikacije(Date datumAplikacije) {
        this.datumAplikacije = datumAplikacije;
    }

    public Klijenti getIdKlijenta() {
        return idKlijenta;
    }

    public void setIdKlijenta(Klijenti idKlijenta) {
        this.idKlijenta = idKlijenta;
    }

    public Paketi getIdPaketa() {
        return idPaketa;
    }

    public void setIdPaketa(Paketi idPaketa) {
        this.idPaketa = idPaketa;
    }

    public Proizvodi getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(Proizvodi proizvodi) {
        this.proizvodi = proizvodi;
    }

    public StatusAplikacije getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(StatusAplikacije idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProizvoda != null ? idProizvoda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplikacija)) {
            return false;
        }
        Aplikacija other = (Aplikacija) object;
        if ((this.idProizvoda == null && other.idProizvoda != null) || (this.idProizvoda != null && !this.idProizvoda.equals(other.idProizvoda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.onlineaplication.ejb.aplikacija.Aplikacija[ idProizvoda=" + idProizvoda + " ]";
    }

}
