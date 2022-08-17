package com.example.apiregion.repository;

import com.example.apiregion.modele.Pays;
import com.example.apiregion.modele.Population;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopulationRepository extends JpaRepository<Population,Long> {
    //Population findByPopulation(String nb_population);
}
