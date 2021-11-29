package io.turntabl.userservice.repository;

import io.turntabl.userservice.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
