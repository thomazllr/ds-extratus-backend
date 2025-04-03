package com.thomazllr.ds_extratus.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class DoencaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "doenca_id")
    private Doenca doenca;

    private LocalDate dataDiagnostico;

}
