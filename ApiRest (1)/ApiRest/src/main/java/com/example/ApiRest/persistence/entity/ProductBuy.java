package com.example.ApiRest.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_buys")
public class ProductBuy {

    @EmbeddedId
    private ProductBuyPK id;

    private Integer quantity;

    private  Double total;

    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_buy", insertable = false, updatable = false)
    private Buy buy;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

}
