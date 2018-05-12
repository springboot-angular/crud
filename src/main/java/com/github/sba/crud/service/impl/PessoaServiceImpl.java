package com.github.sba.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.github.sba.crud.entity.Pessoa;
import com.github.sba.crud.entity.QPessoa;
import com.github.sba.crud.repository.PessoaRepository;
import com.github.sba.crud.service.PessoaService;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Transactional(readOnly = true)
	public Page<Pessoa> getAll(Pageable pageable) {
		QPessoa qPessoa = QPessoa.pessoa;
		BooleanExpression expression = qPessoa.isNotNull();

		return pessoaRepository.findAll(expression, pageable,
				EntityGraphUtils.fromAttributePaths("endereco", "escolaridades", "certificacoes"));
	}

	@Transactional(readOnly = true)
	@Override
	public Pessoa get(Long id) {
		QPessoa qPessoa = QPessoa.pessoa;
		BooleanExpression expression = qPessoa.id.eq(id);

		Pessoa pessoa = pessoaRepository.findOne(expression,
				EntityGraphUtils.fromAttributePaths("endereco", "escolaridades", "certificacoes"));

		if (pessoa == null)
			throw new RuntimeException("Pessoa não encontrada");

		return pessoa;
	}

	private void validateRequiredFields(Pessoa pessoa) {
		if (pessoa == null)
			throw new RuntimeException("Pessoa nao pode ser null");

		if (pessoa.getId() == null)
			throw new RuntimeException("Id precisa ser prenchido");

		if (pessoa.getNome() == null || !pessoa.getNome().trim().equals(""))
			throw new RuntimeException("Nome precisa ser preenchido");
	}

	@Transactional
	@Override
	public Pessoa create(Pessoa pessoa) {
		this.validateRequiredFields(pessoa);
		return pessoaRepository.save(pessoa);
	}

	@Transactional
	@Override
	public Pessoa update(Pessoa pessoa) {
		this.validateRequiredFields(pessoa);
		return pessoaRepository.save(pessoa);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Pessoa pessoa = this.get(id);
		pessoaRepository.delete(pessoa);
	}

}
