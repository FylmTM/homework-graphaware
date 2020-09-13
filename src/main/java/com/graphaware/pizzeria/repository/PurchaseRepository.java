package com.graphaware.pizzeria.repository;

import com.graphaware.pizzeria.model.Purchase;
import com.graphaware.pizzeria.model.PurchaseState;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

	Purchase findFirstByStateEquals(PurchaseState state);

	List<Purchase> findAllByStateEqualsAndCustomer_Id(PurchaseState state, Long customerId);
}
