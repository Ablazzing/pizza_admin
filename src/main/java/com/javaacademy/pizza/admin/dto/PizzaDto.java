package com.javaacademy.pizza.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDto {
    private String name;
    private String description;
    private BigDecimal price;
    @JsonProperty("img_url")
    private String imgUrl;
}
