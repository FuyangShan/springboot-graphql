package com.fshan.graphql.repository;

import com.fshan.graphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
