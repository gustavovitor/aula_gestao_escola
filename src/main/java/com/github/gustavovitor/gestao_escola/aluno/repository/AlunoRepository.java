package com.github.gustavovitor.gestao_escola.aluno.repository;

import com.github.gustavovitor.gestao_escola.aluno.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
