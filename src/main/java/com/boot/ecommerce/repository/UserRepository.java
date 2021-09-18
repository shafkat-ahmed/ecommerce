package com.boot.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.ecommerce.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	 Optional<User> findByUserName(String userName);

	 @Query("SELECT id from User u where u.userName=:s")
	 int getUserId(@Param("s") String s);

}
