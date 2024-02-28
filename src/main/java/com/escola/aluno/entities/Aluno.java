package com.escola.aluno.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "aluno")
@Table(name = "tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "name", nullable = false)
    private String name;
    @Column (name = "nascimento", nullable = false)
    private Date dataDeNascimento;

    public Aluno() {}
    public Aluno(int id, String name, Date dataDeNascimento){
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
