package com.fshan.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.fshan.graphql.entity.Dog;
import com.fshan.graphql.exception.DogNotFoundException;
import com.fshan.graphql.repository.DogRepository;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();

        for(Dog dog : allDogs) {
            if(dog.getBreed().equals(breed)) {
                dogRepository.delete(dog);
                deleted = true;
            }
        }

        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
