package com.fabien.spring.jpa.h2.repository;

import com.fabien.spring.jpa.h2.model.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarifRepository extends JpaRepository<Tarif, Long> {

    List<Tarif> findAll();

  Optional<Tarif> findById(Long id);

}
