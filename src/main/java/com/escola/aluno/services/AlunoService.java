package com.escola.aluno.services;

import com.escola.aluno.dto.AlunoDTO;
import com.escola.aluno.entities.Aluno;
import com.escola.aluno.repositories.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;


    public ResponseEntity<List<Aluno>> listarAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
    }

    public AlunoDTO buscarAluno(int id){
        return new AlunoDTO(alunoRepository.findById(id).get());

    }

    public ResponseEntity<Aluno> salvarAluno(AlunoDTO aluno){
        var al = new Aluno();
        BeanUtils.copyProperties(aluno, al);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(al));
    }

    public AlunoDTO editarAluno(AlunoDTO alunoDTO){
        Aluno aluno = new Aluno(alunoDTO);
        return new AlunoDTO(alunoRepository.save(aluno));
    }

    public void deletarAluno(int id){
        Aluno aluno = alunoRepository.findById(id).get();
        alunoRepository.delete(aluno);
    }
}
