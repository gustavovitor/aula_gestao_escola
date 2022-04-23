package com.github.gustavovitor.gestao_escola.aluno.service;

import com.github.gustavovitor.gestao_escola.aluno.domain.Aluno;
import com.github.gustavovitor.gestao_escola.aluno.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno inserir(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno atualizar(Long id, Aluno aluno) {
        Aluno alunoSalvo = alunoRepository.getById(id);
        BeanUtils.copyProperties(aluno, alunoSalvo, "id");
        return alunoRepository.save(alunoSalvo);
    }

    @Transactional
    public Aluno atualizarCampos(Long id, Map<String, Object> map) {
        Aluno alunoSalvo = buscarPorId(id);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Field field = ReflectionUtils.findField(Aluno.class, key);

            if (key.equals("id") || field == null) {
                continue;
            }

            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, alunoSalvo, value);
            field.setAccessible(false);
        }

        return alunoRepository.save(alunoSalvo);
    }

    @Transactional
    public void remover(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }
}
