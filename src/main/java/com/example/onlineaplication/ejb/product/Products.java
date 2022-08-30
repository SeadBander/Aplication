package com.example.onlineaplication.ejb.product;

import com.example.onlineaplication.ejb.user.Users;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

/**
 *
 * @author SEJO
 */
@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
        @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id"),
        @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
        @NamedQuery(name = "Products.findByAmount", query = "SELECT p FROM Products p WHERE p.amount = :amount")})
public class Products implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @JoinTable(name = "loan_application", joinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Users> usersList;
    @JoinColumn(name = "applicant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users applicant;

    public Products() {
    }

    public Products(Integer id) {
        this.id = id;
    }

    public Products(Integer id, String productName, int amount) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Users getApplicant() {
        return applicant;
    }

    public void setApplicant(Users applicant) {
        this.applicant = applicant;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return productName;
    }

}
