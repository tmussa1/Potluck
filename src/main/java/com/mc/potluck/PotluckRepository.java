package com.mc.potluck;

import org.springframework.data.repository.CrudRepository;

public interface PotluckRepository extends CrudRepository<Potluck,Long> {
    Iterable <Potluck> findAllByFoodNameContainingIgnoreCase(String searchTerm);
}
