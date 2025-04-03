package com.thomazllr.ds_extratus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Venda {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate data;

    private BigDecimal total;


}
