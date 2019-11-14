package com.fshan.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fshan.graphql.entity.Dog;
import com.fshan.graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findALlDogNames() {
        return dogRepository.findAll();
    }

    public Iterable<Dog> findDogBreeds(Long id) {
        Iterable<Dog> =

    }

    public Iterable<Dog> findDogBreedById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
