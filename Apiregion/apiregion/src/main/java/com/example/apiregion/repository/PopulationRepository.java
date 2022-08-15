package com.example.apiregion.repository;

import com.example.apiregion.modele.Population;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopulationRepository extends JpaRepository<Population,Long> {
}
