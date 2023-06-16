package com.fabien.spring.jpa.h2.repository;

import com.fabien.spring.jpa.h2.model.AeroClub;
import com.fabien.spring.jpa.h2.model.Tarifs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarifsRepository extends JpaRepository<Tarifs, Long> {

  Optional<Tarifs> findById(Long id);

}
