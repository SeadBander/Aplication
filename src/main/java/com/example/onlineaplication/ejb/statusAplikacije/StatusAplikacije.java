package com.example.onlineaplication.ejb.statusAplikacije;


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
@Table(name = "status_aplikacije")
@NamedQueries({
        @NamedQuery(name = "StatusAplikacije.findAll", query = "SELECT s FROM StatusAplikacije s"),
        @NamedQuery(name = "StatusAplikacije.findByStatusAplikacijeId", query = "SELECT s FROM StatusAplikacije s WHERE s.statusAplikacijeId = :statusAplikacijeId"),
        @NamedQuery(name = "StatusAplikacije.findByStatus", query = "SELECT s FROM StatusAplikacije s WHERE s.status = :status")})
public class StatusAplikacije implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_aplikacije_id")
    private Integer statusAplikacijeId;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private List<Aplikacija> aplikacijaList;

    public StatusAplikacije() {
    }

    public StatusAplikacije(Integer statusAplikacijeId) {
        this.statusAplikacijeId = statusAplikacijeId;
    }

    public StatusAplikacije(Integer statusAplikacijeId, String status) {
        this.statusAplikacijeId = statusAplikacijeId;
        this.status = status;
    }

    public Integer getStatusAplikacijeId() {
        return statusAplikacijeId;
    }

    public void setStatusAplikacijeId(Integer statusAplikacijeId) {
        this.statusAplikacijeId = statusAplikacijeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        hash += (statusAplikacijeId != null ? statusAplikacijeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusAplikacije)) {
            return false;
        }
        StatusAplikacije other = (StatusAplikacije) object;
        if ((this.statusAplikacijeId == null && other.statusAplikacijeId != null) || (this.statusAplikacijeId != null && !this.statusAplikacijeId.equals(other.statusAplikacijeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.onlineaplication.ejb.statusAplikacije.StatusAplikacije[ statusAplikacijeId=" + statusAplikacijeId + " ]";
    }

}

