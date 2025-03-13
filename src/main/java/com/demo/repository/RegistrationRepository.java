package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Registration;

public interface RegistrationRepository extends CrudRepository<Registration,Long> {

	@Query("select r from Registration r where r.email=:e")
	Optional<Registration> findByEmail(@Param("e")String email);
	@Query("select r from Registration r where r.email=:e or r.mobile=:m")
	Iterable<Registration> findByEmailOrMobile(
			@Param("e")String email, 
			@Param("m")String mobile);
    @Query("select r from Registration r where r.mobile=:m")
    Registration findByMobile(@Param("m")String mobile);
	@Query("select r from Registration r where r.email=:e and e.mobile=:e")
    Registration findByEmailAndMobile(
    		@Param("e")String email, 
    		@Param("m")String mobile);
	// @Param annotation is used to bind the method argument with the name argument of the Query annotation.
	
    
}
