package com.graphaware.pizzeria.controller;

import com.graphaware.pizzeria.model.Pizza;
import com.graphaware.pizzeria.model.Purchase;
import com.graphaware.pizzeria.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	public PurchaseController() {

	}

	@PostMapping("addPizza")
	public ResponseEntity<Purchase> addToBasked(@RequestBody Pizza pizza) {
		Purchase purchase = purchaseService.addPizzaToPurchase(pizza);
		return new ResponseEntity<>(purchase, HttpStatus.OK);
	}

	@PostMapping("submitOrder")
	public ResponseEntity<Void> submitPurchase() {
		purchaseService.confirmPurchase();
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("pickPurchase")
	public ResponseEntity<Purchase> pickPurchase() {
		Purchase purchase = purchaseService.pickPurchase();
		return new ResponseEntity<>(purchase, HttpStatus.OK);
	}

	@PutMapping("completePurchase/{id}")
	public ResponseEntity<Void> completePurchase(@PathVariable("id") long id) {
		purchaseService.completePurchase(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("currentPurchase")
	public ResponseEntity<Purchase> getCurrentPurchase() {
		Purchase purchase = purchaseService.getCurrentPurchase();
		if (purchase != null) {
			return new ResponseEntity<>(purchase, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
}
