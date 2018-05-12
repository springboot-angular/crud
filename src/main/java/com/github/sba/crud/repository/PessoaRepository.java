package com.github.sba.crud.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;
import com.github.sba.crud.entity.Pessoa;

public interface PessoaRepository
		extends EntityGraphJpaRepository<Pessoa, Long>, EntityGraphQuerydslPredicateExecutor<Pessoa> {

}
