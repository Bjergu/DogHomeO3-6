package com.eikholm.jpademo10.repositories;

import com.eikholm.jpademo10.model.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
