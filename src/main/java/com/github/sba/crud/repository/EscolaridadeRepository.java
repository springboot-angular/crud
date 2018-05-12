package com.github.sba.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQueryDslPredicateExecutor;
import com.github.sba.crud.entity.Escolaridade;

public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Long>,
		QueryDslPredicateExecutor<Escolaridade>, EntityGraphQueryDslPredicateExecutor<Escolaridade> {

}
