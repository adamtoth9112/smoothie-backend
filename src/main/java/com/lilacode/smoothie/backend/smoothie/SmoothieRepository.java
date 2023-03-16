package com.lilacode.smoothie.backend.smoothie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmoothieRepository extends JpaRepository<Smoothie, Long> {
    Optional<Smoothie> findByName(String name);
}
