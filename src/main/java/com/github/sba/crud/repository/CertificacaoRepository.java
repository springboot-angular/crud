package com.github.sba.crud.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;
import com.github.sba.crud.entity.Certificacao;

public interface CertificacaoRepository
		extends EntityGraphJpaRepository<Certificacao, Long>, EntityGraphQuerydslPredicateExecutor<Certificacao> {

}
