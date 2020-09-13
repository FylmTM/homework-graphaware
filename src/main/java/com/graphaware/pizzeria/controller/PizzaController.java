package com.graphaware.pizzeria.controller;

import com.graphaware.pizzeria.model.Pizza;
import com.graphaware.pizzeria.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

	@Autowired
	PizzaRepository repo;

	@PostMapping("/pizza")
	public void createPizza(@RequestBody Pizza pizza){
		repo.save(pizza);
	}

	@GetMapping("/pizza")
	public Iterable<Pizza> getPizzas(@RequestParam(value = "topping", required = false) String topping){
		if (topping==null)
			return repo.findAll();
		else
			return repo.getPizzaContainingTopping(topping);
	}
}
