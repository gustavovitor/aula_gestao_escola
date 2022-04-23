package com.github.gustavovitor.gestao_escola.curso.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@ToString
@Table(name = "curso", schema = "public")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "valor_curso")
    private BigDecimal valorCurso;

}
