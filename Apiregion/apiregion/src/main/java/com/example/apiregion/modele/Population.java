package com.example.apiregion.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Population")
@Getter
@Setter
@NoArgsConstructor
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPopulation;
    private String nb_population;
    private Long annee;


    //@ManyToMany
    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
            ,mappedBy = "population")
    @JsonIgnore
    List<Region> region = new ArrayList<>();*/
    @ManyToOne
    private Region region;
    /*@OneToMany(mappedBy = "population")
    private List<Region> region;*/
}
