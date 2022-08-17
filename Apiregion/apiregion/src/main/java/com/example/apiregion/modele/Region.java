package com.example.apiregion.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Region")
@Getter
@Setter
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegion;
    private String code_region;
    private String nom;
    private String domaineAct;
    private String superficie;
    private String langue;

    /*@ManyToOne
    private Population population;*/

    @ManyToOne
    private Pays pays;

    /*@ManyToMany
    @JoinTable(
            name = "region_population",
            joinColumns = @JoinColumn(name = "id_region"),
            inverseJoinColumns = {@JoinColumn(name = "id_population")})
    List<Population> population = new ArrayList<>();*/


}
