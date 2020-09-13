package com.graphaware.pizzeria.service;

import com.graphaware.pizzeria.model.PizzeriaUser;
import com.graphaware.pizzeria.model.UserRole;
import com.graphaware.pizzeria.repository.PizzeriaUserRepository;
import com.graphaware.pizzeria.repository.PurchaseRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class ManagementService {
    private final PurchaseRepository purchaseRepository;
    private final PizzeriaUserRepository pizzeriaUserRepository;

    public ManagementService(PurchaseRepository purchaseRepository, PizzeriaUserRepository pizzeriaUserRepository) {
        this.purchaseRepository = purchaseRepository;
        this.pizzeriaUserRepository = pizzeriaUserRepository;
    }

    public long getPurchasesCount() {
        PizzeriaUser currentUser = getCurrentUser();
        if (currentUser.getRoles().stream().noneMatch(userRole -> userRole.equals(UserRole.OWNER))) {
            throw new AccessDeniedException("Access not allowed");
        }
        return purchaseRepository.count();
    }

    private PizzeriaUser getCurrentUser() {
        //todo change current user
        return pizzeriaUserRepository.findById(66L).orElseThrow(IllegalArgumentException::new);
    }
}
