package com.example.onlineaplication.ejb.user;

import com.example.onlineaplication.ejb.privilege.Privilege;
import com.example.onlineaplication.ejb.product.Products;
import com.example.onlineaplication.ejb.town.Town;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
        @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
        @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
        @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname"),
        @NamedQuery(name = "Users.findByJmbg", query = "SELECT u FROM Users u WHERE u.jmbg = :jmbg"),
        @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
        @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
        @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "jmbg")
    private String jmbg;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @ManyToMany(mappedBy = "usersList")
    private List<Products> productsList;
    @JoinColumn(name = "privilege_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Privilege privilegeId;
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Town townId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")
    private List<Products> productsList1;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String name, String surname, String jmbg, String email, String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.jmbg = jmbg;
        this.email = email;
        this.username = username;
        this.password = password;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public Privilege getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Privilege privilegeId) {
        this.privilegeId = privilegeId;
    }

    public Town getTownId() {
        return townId;
    }

    public void setTownId(Town townId) {
        this.townId = townId;
    }

    public List<Products> getProductsList1() {
        return productsList1;
    }

    public void setProductsList1(List<Products> productsList1) {
        this.productsList1 = productsList1;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
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