package com.github.sba.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.sba.crud.entity.PessoaEndereco;
import com.github.sba.crud.service.PessoaEnderecoService;

@RestController
@RequestMapping(value = "/pessoaEnderecos", produces = "application/json")
public class PessoaEnderecoController {

	@Autowired
	private PessoaEnderecoService pessoaEnderecoService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<PessoaEndereco> getAll(Pageable pageable) {
		return pessoaEnderecoService.getAll(pageable);
	}

}
