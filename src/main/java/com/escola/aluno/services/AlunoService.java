package com.escola.aluno.services;

import com.escola.aluno.dto.AlunoDTO;
import com.escola.aluno.entities.Aluno;
import com.escola.aluno.repositories.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDTO> listarAlunos(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(AlunoDTO::new).toList();
    }

    public AlunoDTO buscarAluno(int id){
        return new AlunoDTO(alunoRepository.findById(id).get());

    }

    public void salvarAluno(AlunoDTO alunoDTO){
        Aluno aluno = new Aluno(alunoDTO);
        alunoRepository.save(aluno);
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
