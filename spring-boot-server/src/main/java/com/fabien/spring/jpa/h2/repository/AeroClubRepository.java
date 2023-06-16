package com.fabien.spring.jpa.h2.repository;

import com.fabien.spring.jpa.h2.model.AeroClub;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AeroClubRepository extends JpaRepository<AeroClub, Long> {
  List<AeroClub> findAll();

  List<AeroClub> findByName(String name);

  List<AeroClub> findByOaciContaining(String oaci);

  Optional<AeroClub> findById(Long id);
}
