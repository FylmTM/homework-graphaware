package com.graphaware.pizzeria.repository;

import com.graphaware.pizzeria.model.Pizza;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long>, PizzaRepositoryCustom {

}
