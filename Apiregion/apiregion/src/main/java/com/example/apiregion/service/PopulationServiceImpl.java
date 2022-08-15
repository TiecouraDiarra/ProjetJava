package com.example.apiregion.service;

import com.example.apiregion.modele.Population;
import com.example.apiregion.repository.PopulationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PopulationServiceImpl implements PopulationService {
    private final PopulationRepository populationRepository;
    @Override
    public Population Ajouter(Population population) {
        return populationRepository.save(population);
    }

    @Override
    public Population modifier(Long idPopulation, Population population) {
        return populationRepository.findById(idPopulation)
                .map(p->{
                    p.setNb_population(population.getNb_population());
                    p.setAnnee(population.getAnnee());
                    return populationRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Population non trouvée !"));
    }

    @Override
    public List<Population> Lire() {
        return populationRepository.findAll();
    }

    @Override
    public String supprimer(Long idPopulation) {
        populationRepository.deleteById(idPopulation);
        return "Population supprimée";
    }
}
