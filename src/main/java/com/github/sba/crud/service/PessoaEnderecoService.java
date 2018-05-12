package com.github.sba.crud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.sba.crud.entity.PessoaEndereco;

public interface PessoaEnderecoService {

	public Page<PessoaEndereco> getAll(Pageable pageable);
	
	public PessoaEndereco create(PessoaEndereco pessoaEndereco);

}
