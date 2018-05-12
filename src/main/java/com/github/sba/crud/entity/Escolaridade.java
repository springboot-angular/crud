package com.github.sba.crud.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.github.sba.crud.entity.enums.EscolaridadeEnum;

@Entity
@Table(name = "ESCOLARIDADE")
public class Escolaridade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ESCOLARIDADE")
	private EscolaridadeEnum escolaridade;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PESSOA_ESCOLARIDADE", joinColumns = {
			@JoinColumn(name = "ESCOLARIDADE_ID") }, inverseJoinColumns = { @JoinColumn(name = "PESSOA_ID") })
	private Set<Pessoa> pessoas;

	public Escolaridade() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EscolaridadeEnum getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EscolaridadeEnum escolaridade) {
		this.escolaridade = escolaridade;
	}

}
