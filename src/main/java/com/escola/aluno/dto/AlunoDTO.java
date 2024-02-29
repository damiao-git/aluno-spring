package com.escola.aluno.dto;

import com.escola.aluno.entities.Aluno;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class AlunoDTO{
    private int id;

    private String name;

    private Date dataDeNascimento;

    public AlunoDTO(Aluno aluno){
        BeanUtils.copyProperties(aluno, this);
    }
    public AlunoDTO(){}

    public AlunoDTO(int id, String name, Date dataDeNascimento) {
        this.id = id;
        this.name = name;
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

}
