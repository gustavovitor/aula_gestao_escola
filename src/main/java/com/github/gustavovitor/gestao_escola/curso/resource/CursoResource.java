package com.github.gustavovitor.gestao_escola.curso.resource;

import com.github.gustavovitor.gestao_escola.curso.domain.Curso;
import com.github.gustavovitor.gestao_escola.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/curso")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> buscarTodos() {
        return cursoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable("id") Long id) {
        return cursoService.buscarPorId(id);
    }

    @PostMapping
    public Curso inserir(@RequestBody Curso curso) {
        return cursoService.inserir(curso);
    }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable("id") Long id, @RequestBody Curso curso) {
        return cursoService.atualizar(id, curso);
    }

    @PatchMapping("/{id}")
    public Curso atualizarCampos(@PathVariable("id") Long id, @RequestBody Map<String, Object> map) {
        return cursoService.atualizarCampos(id, map);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable("id") Long id) {
        cursoService.remover(id);
    }
}
