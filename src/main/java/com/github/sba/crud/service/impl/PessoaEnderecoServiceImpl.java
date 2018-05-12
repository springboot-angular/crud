package com.github.sba.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.github.sba.crud.entity.PessoaEndereco;
import com.github.sba.crud.repository.PessoaEnderecoRepository;
import com.github.sba.crud.service.PessoaEnderecoService;

@Service
public class PessoaEnderecoServiceImpl implements PessoaEnderecoService {

	@Autowired
	private PessoaEnderecoRepository pessoaEnderecoRepository;

	@Transactional(readOnly = true)
	public Page<PessoaEndereco> getAll(Pageable pageable) {
		return pessoaEnderecoRepository.findAll(pageable, EntityGraphUtils.fromAttributePaths("pessoa"));
	}

	private void validateRequiredFields(PessoaEndereco pessoaEndereco) {
		if (pessoaEndereco == null)
			throw new RuntimeException("Pessoa não pode ser null");

		if (pessoaEndereco.getLogradouro() == null || pessoaEndereco.getLogradouro().isEmpty())
			throw new RuntimeException("Logradouro precisa ser informado");

		if (pessoaEndereco.getRua() == null || pessoaEndereco.getRua().isEmpty())
			throw new RuntimeException("Rua precisa ser informada");

		if (pessoaEndereco.getNumero() == null || pessoaEndereco.getNumero().isEmpty())
			throw new RuntimeException("Numero precisa ser informado");

		if (pessoaEndereco.getCidade() == null || pessoaEndereco.getCidade().isEmpty())
			throw new RuntimeException("Cidade precisa ser informada");
	}

	@Override
	public PessoaEndereco create(PessoaEndereco pessoaEndereco) {
		this.validateRequiredFields(pessoaEndereco);
		return pessoaEnderecoRepository.save(pessoaEndereco);
	}

}
