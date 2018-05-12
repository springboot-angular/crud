package com.github.sba.crud.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	private Set<PessoaEndereco> endereco;

	@ManyToMany(mappedBy = "pessoas", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	private Set<Escolaridade> escolaridades;

	@ManyToMany(mappedBy = "pessoas", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	private Set<Certificacao> certificacoes;

	public Pessoa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<PessoaEndereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(Set<PessoaEndereco> endereco) {
		this.endereco = endereco;
	}

	public Set<Escolaridade> getEscolaridades() {
		return escolaridades;
	}

	public void setEscolaridades(Set<Escolaridade> escolaridades) {
		this.escolaridades = escolaridades;
	}

	public Set<Certificacao> getCertificacoes() {
		return certificacoes;
	}

	public void setCertificacoes(Set<Certificacao> certificacoes) {
		this.certificacoes = certificacoes;
	}

}
