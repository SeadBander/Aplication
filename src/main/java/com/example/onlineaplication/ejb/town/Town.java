package com.example.onlineaplication.ejb.town;


import com.example.onlineaplication.ejb.country.Country;
import com.example.onlineaplication.ejb.user.Users;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "town")
@NamedQueries({
        @NamedQuery(name = "Town.findAll", query = "SELECT t FROM Town t"),
        @NamedQuery(name = "Town.findById", query = "SELECT t FROM Town t WHERE t.id = :id"),
        @NamedQuery(name = "Town.findByName", query = "SELECT t FROM Town t WHERE t.name = :name")})
public class Town implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinColumns({
            @JoinColumn(name = "country_id", referencedColumnName = "id"),
            @JoinColumn(name = "country_id", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private Country country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "townId")
    private List<Users> usersList;

    public Town() {
    }

    public Town(Integer id) {
        this.id = id;
    }

    public Town(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Town)) {
            return false;
        }
        Town other = (Town) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
