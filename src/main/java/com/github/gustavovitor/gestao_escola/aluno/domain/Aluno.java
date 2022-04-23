package com.github.gustavovitor.gestao_escola.aluno.domain;

import com.github.gustavovitor.gestao_escola.curso.domain.Curso;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name = "aluno", schema = "public")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String telefone;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @Column(name = "telefone_responsavel")
    private String telefoneResponsavel;

    @ManyToMany
    private List<Curso> cursoList;

}
