package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Registration;
import com.demo.repository.RegistrationRepository;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
	private RegistrationRepository repo;
	@Test
	public void ob() {
		System.out.println(repo);
	}
	@Test
	public void saveRepository() {
		Registration r=new Registration();
		r.setName("mike");
		r.setEmail("mike@gmail.com");
        r.setMobile("7896545566");
        repo.save(r);
	}
	@Test
	public void deleteRepository() {
		repo.deleteById(2l);
	}
	@Test
	public void getRecord() {
		Optional<Registration>val=repo.findById(1L);
		if(val.isPresent()) {
			Registration r=val.get();
			System.out.println(r.getid());
			System.out.println(r.getname());
			System.out.println(r.getemail());
			System.out.println(r.getmobile());
		}
		else {
			System.out.println("record not found");
		}
	}
	@Test
	public void getAll() {
		Iterable<Registration>i=repo.findAll();
		for(Registration r:i) {
			System.out.println(r.getid());
			System.out.println(r.getname());
			System.out.println(r.getemail());
			System.out.println(r.getmobile());
		}
	}
	@Test
	public void getByEmail() {
		Optional<Registration>o=repo.findByEmail("stallin@gmail.com");
		if(o.isPresent()) {
			Registration r=o.get();
			System.out.println(r.getid());
			System.out.println(r.getname());
			System.out.println(r.getemail());
			System.out.println(r.getmobile());
		}
		}
	@Test
	public void getByEmailOrMobile() {
		Iterable<Registration>i=repo.findByEmailOrMobile("stallin@gmail.com", "7896545566");
	     for(Registration r:i) {
	    	 System.out.println(r.getid());
	 		System.out.println(r.getname());
	 		System.out.println(r.getemail());
	 		System.out.println(r.getmobile());
	     }
	}
	@Test
	public void getByEmailAndMobile() {
		Registration r=repo.findByEmailAndMobile("stallin@gmail.com","7896542345");
		System.out.println(r.getid());
 		System.out.println(r.getname());
 		System.out.println(r.getemail());
 		System.out.println(r.getmobile());
	}
	@Test
	public void getByMobile() {
		Registration r=repo.findByMobile("7896542345");
		System.out.println(r.getid());
		System.out.println(r.getname());
		System.out.println(r.getemail());
 		System.out.println(r.getmobile());
	}
	

}
