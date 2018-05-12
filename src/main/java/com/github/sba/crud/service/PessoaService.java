package com.github.sba.crud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.sba.crud.entity.Pessoa;

public interface PessoaService {
	
	public Page<Pessoa> getAll(Pageable pageable);

	public Pessoa get(Long id);

	public Pessoa create(Pessoa pessoa);

	public Pessoa update(Pessoa pessoa);

	public void delete(Long id);

}
