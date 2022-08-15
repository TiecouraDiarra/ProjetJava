package com.example.apiregion.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    private Population population;

    @ManyToOne
    private Pays pays;


}
