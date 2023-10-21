package com.tercero.usarapi.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductApi {
    private String name;
    private int categoryId;
    private Double price;
    private Integer stock;
    private Boolean active;
    private CategoryApi categoryDto;

}
