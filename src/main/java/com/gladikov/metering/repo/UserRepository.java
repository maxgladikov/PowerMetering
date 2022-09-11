package com.gladikov.metering.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gladikov.metering.model.User;

public interface UserRepository extends CrudRepository<User,String>{
	Optional<User> findByName(String name);
	List<User> findAll();
	Optional<User> findById(Long id);
//	 @Query("DELETE FROM User t where t.id = :id") 
//	Long deleteById(@Param("id") Long id);
	  void delete(User user);
}












