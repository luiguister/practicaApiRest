package com.example.ApiRest.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProductBuyPK implements Serializable {

    @Column(name = "id_buy")
    private Integer idBuy;

    @Column(name = "id_product")
    private Integer idProduct;
}
