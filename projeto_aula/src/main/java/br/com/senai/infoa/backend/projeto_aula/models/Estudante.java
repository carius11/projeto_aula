package br.com.senai.infoa.backend.projeto_aula.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudante")

public class Estudante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "id")
  private Integer id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "email")
  private String email;

  @Column(name = "data_nascimento")
  private String dataNascimento;

  @ManyToOne
  @JoinColumn(name = "estudante_id")
  private Estudante estudante;

  @ManyToMany
  @JoinTable(
    name = "estudante_materia",
    joinColumns = @JoinColumn(name = "estudante_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "id"))

  public Estudante() {
  }

  public Estudante(Integer id, String nome, String email, String dataNascimento, Estudante estudante) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.dataNascimento = dataNascimento;
    this.estudante = estudante;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Estudante getEstudante() {
    return estudante;
  }

  public void setEstudante(Estudante estudante) {
    this.estudante = estudante;
  }

}
