package com.escola.aluno.controllers;

import com.escola.aluno.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;
    @GetMapping
    public ResponseEntity getAllAlunos(){
        
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
    }

}
