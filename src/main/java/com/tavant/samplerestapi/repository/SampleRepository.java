package com.tavant.samplerestapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tavant.samplerestapi.models.Registerusers;



@Repository
public interface SampleRepository extends JpaRepository<Registerusers, String>  {
	 Optional<Registerusers> findByEmail(String email);
//
	   Registerusers findByEmailAndPassword(String mail, String password);
//
	    Optional<Registerusers> findByName(String name);

	    Boolean existsByName(String name);

	    Boolean existsByEmail(String email);

}
