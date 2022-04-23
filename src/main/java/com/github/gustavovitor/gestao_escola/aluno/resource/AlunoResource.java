package com.github.gustavovitor.gestao_escola.aluno.resource;

import com.github.gustavovitor.gestao_escola.aluno.domain.Aluno;
import com.github.gustavovitor.gestao_escola.aluno.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> buscarTodos() {
        return alunoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable("id") Long id) {
        return alunoService.buscarPorId(id);
    }

    @PostMapping
    public Aluno inserir(@RequestBody Aluno aluno) {
        return alunoService.inserir(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
        return alunoService.atualizar(id, aluno);
    }

    @PatchMapping("/{id}")
    public Aluno atualizarCampos(@PathVariable("id") Long id, @RequestBody Map<String, Object> map) {
        return alunoService.atualizarCampos(id, map);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable("id") Long id) {
        alunoService.remover(id);
    }
}
