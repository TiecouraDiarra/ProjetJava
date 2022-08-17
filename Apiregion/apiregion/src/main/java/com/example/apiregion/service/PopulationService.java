package com.example.apiregion.service;

import com.example.apiregion.modele.Pays;
import com.example.apiregion.modele.Population;
import com.example.apiregion.repository.PopulationRepository;

import java.util.List;

public interface PopulationService {
    Population Ajouter(Population population);
    //Population getNb_population(Population population);
    Population modifier(Long idPopulation, Population population);
    List<Population> Lire();
    String supprimer(Long idPopulation);
}
