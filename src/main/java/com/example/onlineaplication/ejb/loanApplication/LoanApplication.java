package com.example.onlineaplication.ejb.loanApplication;

import com.example.onlineaplication.ejb.product.Product;
import com.example.onlineaplication.ejb.user.Users;
import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "loan_application")
@NamedQueries({
        @NamedQuery(name = "LoanApplication.findAll", query = "SELECT l FROM LoanApplication l"),
        @NamedQuery(name = "LoanApplication.findById", query = "SELECT l FROM LoanApplication l WHERE l.id = :id"),
        @NamedQuery(name = "LoanApplication.findByAmount", query = "SELECT l FROM LoanApplication l WHERE l.amount = :amount"),
        @NamedQuery(name = "LoanApplication.findByProductId", query = "SELECT l FROM LoanApplication l WHERE l.productId = :productId"),
        @NamedQuery(name = "LoanApplication.findByUserId", query = "SELECT l FROM LoanApplication l WHERE l.userId = :userId")})
public class LoanApplication implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "amount")
    private String amount;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Users userId;

    public LoanApplication() {
    }

    public LoanApplication(Integer id) {
        this.id = id;
    }

    public LoanApplication(Integer id, String amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LoanApplication)) {
            return false;
        }
        LoanApplication other = (LoanApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id;
    }

}
