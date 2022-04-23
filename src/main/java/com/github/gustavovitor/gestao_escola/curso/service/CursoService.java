package com.github.gustavovitor.gestao_escola.curso.service;

import com.github.gustavovitor.gestao_escola.curso.domain.Curso;
import com.github.gustavovitor.gestao_escola.curso.repository.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Curso inserir(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public Curso atualizar(Long id, Curso curso) {
        Curso cursoSalvo = cursoRepository.getById(id);
        BeanUtils.copyProperties(curso, cursoSalvo, "id");
        return cursoRepository.save(cursoSalvo);
    }

    @Transactional
    public Curso atualizarCampos(Long id, Map<String, Object> map) {
        Curso cursoSalvo = buscarPorId(id);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Field field = ReflectionUtils.findField(Curso.class, key);

            if (key.equals("id") || field == null) {
                continue;
            }

            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, cursoSalvo, value);
            field.setAccessible(false);
        }

        return cursoRepository.save(cursoSalvo);
    }

    @Transactional
    public void remover(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }
}
