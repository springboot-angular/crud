package com.github.sba.crud.service.impl;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.github.sba.crud.entity.Pessoa;
import com.github.sba.crud.entity.PessoaEndereco;
import com.github.sba.crud.entity.QPessoa;
import com.github.sba.crud.repository.PessoaRepository;
import com.github.sba.crud.service.PessoaEnderecoService;
import com.github.sba.crud.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaEnderecoService pessoaEnderecoService;

	@Transactional(readOnly = true)
	public Page<Pessoa> getAll(Pageable pageable) {
		return pessoaRepository.findAll(pageable,
				EntityGraphUtils.fromAttributePaths("endereco", "escolaridades", "certificacoes"));
	}

	@Transactional(readOnly = true)
	@Override
	public Pessoa get(Long id) {
		Optional<Pessoa> optPessoa = pessoaRepository.findOne(QPessoa.pessoa.id.eq(id),
				EntityGraphUtils.fromAttributePaths("endereco"));

		if (!optPessoa.isPresent())
			throw new RuntimeException("Pessoa não encontrada");

		return optPessoa.get();
	}

	private void validateRequiredFields(Pessoa pessoa) {
		if (pessoa.getNome() == null || pessoa.getNome().trim().equals(""))
			throw new RuntimeException("Nome precisa ser preenchido");
	}

	@Transactional
	@Override
	public Pessoa create(Pessoa pessoa) {
		this.validateRequiredFields(pessoa);

		pessoaRepository.save(pessoa);

		if (pessoa.getEndereco() != null && !pessoa.getEndereco().isEmpty()) {
			PessoaEndereco pessoaEndereco = pessoa.getEndereco().iterator().next();
			pessoaEndereco.setPessoa(pessoa);
			pessoaEndereco = pessoaEnderecoService.create(pessoaEndereco);
		}

		return pessoa;
	}

	@Transactional
	@Override
	public Pessoa update(Pessoa pessoa) {
		if (pessoa == null)
			throw new RuntimeException("Pessoa nao pode ser null");

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
