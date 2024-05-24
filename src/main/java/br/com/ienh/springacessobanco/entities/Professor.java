package br.com.ienh.springacessobanco.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {
    public Professor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Professor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome")
    private String nome;
}
