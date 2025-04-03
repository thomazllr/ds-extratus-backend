package com.thomazllr.ds_extratus.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String text;


    private BigDecimal preco;

}
