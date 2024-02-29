package com.escola.aluno.controllers;

import com.escola.aluno.dto.AlunoDTO;
import com.escola.aluno.entities.Aluno;
import com.escola.aluno.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoService alunoService;
    @GetMapping
    public List<AlunoDTO> getAllAlunos(){
        return alunoService.listarAlunos();
    }

    @GetMapping("{id}")
    public AlunoDTO buscarAluno(@PathVariable("id") int id){
        return alunoService.buscarAluno(id);
    }

    @PostMapping()
    public void inserirAluno(@RequestBody AlunoDTO aluno){
        alunoService.salvarAluno(aluno);
    }
    @PutMapping
    public AlunoDTO editarAluno(@RequestBody AlunoDTO aluno){
        return alunoService.editarAluno(aluno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable("id") int id){
        alunoService.deletarAluno(id);
        return ResponseEntity.ok().build();
    }
}
