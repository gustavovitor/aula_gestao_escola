package com.github.gustavovitor.gestao_escola.curso.repository;

import com.github.gustavovitor.gestao_escola.curso.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
