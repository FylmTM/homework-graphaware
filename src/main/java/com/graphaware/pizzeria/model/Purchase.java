package com.graphaware.pizzeria.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private PizzeriaUser worker;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private PizzeriaUser customer;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PurchaseState state;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "purchase_pizza",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private List<Pizza> pizzas;

    @NotNull
    private Date creationDate;

    private Date checkoutDate;

    private Double amount;
}
