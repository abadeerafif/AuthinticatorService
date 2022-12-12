package com.example.AuthenticatorProject;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface UsersRepo extends MongoRepository<User, String> {

}
