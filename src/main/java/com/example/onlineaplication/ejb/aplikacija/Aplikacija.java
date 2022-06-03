package com.example.onlineaplication.ejb.aplikacija;


import com.example.onlineaplication.ejb.klijenti.Klijenti;
import com.example.onlineaplication.ejb.paketi.Paketi;
import com.example.onlineaplication.ejb.proizvodi.Proizvodi;
import com.example.onlineaplication.ejb.statusAplikacije.StatusAplikacije;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author SEJO
 */
@Entity
@Table(name = "aplikacija")
@NamedQueries({
        @NamedQuery(name = "Aplikacija.findAll", query = "SELECT a FROM Aplikacija a"),
        @NamedQuery(name = "Aplikacija.findByAplikacijaId", query = "SELECT a FROM Aplikacija a WHERE a.aplikacijaId = :aplikacijaId"),
        @NamedQuery(name = "Aplikacija.findByDatumAplikacije", query = "SELECT a FROM Aplikacija a WHERE a.datumAplikacije = :datumAplikacije"),
        @NamedQuery(name = "Aplikacija.findByIdProizvoda", query = "SELECT a FROM Aplikacija a WHERE a.idProizvoda = :idProizvoda")})
public class Aplikacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aplikacija_id")
    private Aplikacija aplikacijaId;
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
    @ManyToOne(optional = false)
    private Proizvodi proizvodi;
    @JoinColumn(name = "id_status", referencedColumnName = "status_aplikacije_id")
    @ManyToOne(optional = false)
    private StatusAplikacije idStatus;

    public Aplikacija getAplikacijaId() {
        return aplikacijaId;
    }

    public void setAplikacijaId(Aplikacija aplikacijaId) {
        this.aplikacijaId = aplikacijaId;
    }

    public Aplikacija(Aplikacija aplikacijaId, Date datumAplikacije, Klijenti idKlijenta, Paketi idPaketa, Proizvodi proizvodi, StatusAplikacije idStatus) {
        this.aplikacijaId = aplikacijaId;
        this.datumAplikacije = datumAplikacije;
        this.idKlijenta = idKlijenta;
        this.idPaketa = idPaketa;
        this.proizvodi = proizvodi;
        this.idStatus = idStatus;
    }

    public Aplikacija() {
    }


    public Aplikacija(int aplikacijaId, int idProizvoda) {
        this.aplikacijaId = new Aplikacija(aplikacijaId, idProizvoda);
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
        hash += (aplikacijaId != null ? aplikacijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplikacija)) {
            return false;
        }
        Aplikacija other = (Aplikacija) object;
        if ((this.aplikacijaId == null && other.aplikacijaId != null) || (this.aplikacijaId != null && !this.aplikacijaId.equals(other.aplikacijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.onlineaplication.ejb.aplikacija.Aplikacija[ aplikacija=" + aplikacijaId + " ]";
    }

}

