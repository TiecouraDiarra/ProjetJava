package com.example.apiregion.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Population")
@Getter
@Setter
@NoArgsConstructor
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPopulation;
    private Long nb_population;
    private Long annee;

    /*@OneToMany(mappedBy = "population")
    private List<Region> region;*/
}
