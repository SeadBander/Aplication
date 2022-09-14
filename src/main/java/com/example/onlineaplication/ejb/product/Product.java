package com.example.onlineaplication.ejb.product;

import java.io.Serializable;
import java.util.List;
import com.example.onlineaplication.ejb.loanApplication.LoanApplication;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Products.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName")})

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "productname")
    private String productName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private List<LoanApplication> loanApplicationList;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
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

    public List<LoanApplication> getLoanApplicationList() {
        return loanApplicationList;
    }

    public void setLoanApplicationList(List<LoanApplication> loanApplicationList) {
        this.loanApplicationList = loanApplicationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return productName+"("+id+")";
    }

}
