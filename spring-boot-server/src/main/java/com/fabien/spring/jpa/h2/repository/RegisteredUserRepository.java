package com.fabien.spring.jpa.h2.repository;

import com.fabien.spring.jpa.h2.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
  List<RegisteredUser> findAll();

  List<RegisteredUser> findByEmail(String email);

  Optional<RegisteredUser> findById(Long id);
}
