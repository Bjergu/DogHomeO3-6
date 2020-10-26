package com.eikholm.jpademo10.service.springdatajpa;

import com.eikholm.jpademo10.model.Dog;
import com.eikholm.jpademo10.repositories.DogRepository;
import com.eikholm.jpademo10.service.DogService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DogJPA implements DogService {
    private final DogRepository dogRepository;

    public DogJPA(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public Set<Dog> findAll() {
        Set<Dog> dogs = new HashSet<>();
        dogRepository.findAll().forEach(dogs::add);
        return dogs;
    }

    @Override
    public Dog save(Dog object) {
        return dogRepository.save(object);
    }

    @Override
    public void delete(Dog object) {
        dogRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        dogRepository.deleteById(aLong);
    }

    @Override
    public Optional<Dog> findById(Long aLong) {
        return dogRepository.findById(aLong);
    }
}
