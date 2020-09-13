package com.graphaware.pizzeria.repository;

import com.graphaware.pizzeria.model.Pizza;

import java.util.List;

public interface PizzaRepositoryCustom {

	List<Pizza> getPizzaContainingTopping(String topping);

}
