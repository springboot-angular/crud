package com.github.sba.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.sba.crud.entity.Pessoa;
import com.github.sba.crud.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas", produces = "application/json")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Pessoa> getAll(Pageable pageable) {
		return pessoaService.getAll(pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pessoa get(@PathVariable(name = "id") Long id) {
		return pessoaService.get(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Pessoa create(@RequestBody Pessoa pessoa) {
		return pessoaService.create(pessoa);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Pessoa update(@RequestBody Pessoa pessoa) {
		return pessoaService.update(pessoa);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(name = "id") Long id) {
		pessoaService.delete(id);
	}

}
