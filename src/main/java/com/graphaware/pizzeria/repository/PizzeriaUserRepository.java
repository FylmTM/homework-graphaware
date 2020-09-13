package com.graphaware.pizzeria.repository;

import com.graphaware.pizzeria.model.PizzeriaUser;
import org.springframework.data.repository.CrudRepository;

public interface PizzeriaUserRepository extends CrudRepository<PizzeriaUser, Long> {

    PizzeriaUser findByUsername(String username);
}
