package com.graphaware.pizzeria.repository;

import com.graphaware.pizzeria.model.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PizzaRepositoryImpl implements PizzaRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Pizza> getPizzaContainingTopping(String topping) {

		Query nativeQuery = entityManager.createNativeQuery("select * from pizza where toppings like '%" + topping + "%'", Pizza.class);
		return (List<Pizza>) nativeQuery.getResultList();
	}
}
