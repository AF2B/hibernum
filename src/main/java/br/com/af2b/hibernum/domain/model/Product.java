package br.com.af2b.hibernum.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String name;
    private String description;
    private String size;
    private String color;
    private BigDecimal price;
    private Long availability;
}
