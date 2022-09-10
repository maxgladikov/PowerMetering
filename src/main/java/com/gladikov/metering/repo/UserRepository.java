package com.gladikov.metering.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gladikov.metering.model.User;

public interface UserRepository extends CrudRepository<User,String>{
	Optional<User> findByName(String name);
	List<User> findAll();
	Optional<User> findById(Long id);
}












