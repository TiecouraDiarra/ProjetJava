package com.example.apiregion.service;

import com.example.apiregion.modele.Pays;
import com.example.apiregion.modele.Region;

import java.util.List;


public interface PaysService {

    Pays Ajouter(Pays pays);
    Pays modifier(Long idPays, Pays pays);
    List<Pays> Lire();
    String supprimer(Long idPays);
}
