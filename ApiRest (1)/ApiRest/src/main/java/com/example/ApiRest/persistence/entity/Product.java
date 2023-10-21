package com.example.ApiRest.persistence.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    private String name;

    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "stock")
    private Integer stock;

    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    private Category category;

    public Product(){

    }

    public Product(Integer idProduct, String name, Integer idCategory, String barcode, Double sellPrice, Integer stock, Boolean state, Category category) {
        this.idProduct = idProduct;
        this.name = name;
        this.idCategory = idCategory;
        this.barcode = barcode;
        this.sellPrice = sellPrice;
        this.stock = stock;
        this.state = state;
        this.category = category;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
