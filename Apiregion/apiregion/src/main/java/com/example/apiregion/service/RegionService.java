package com.example.apiregion.service;

import com.example.apiregion.modele.Region;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RegionService {
    Region creer(Region region);
    List<Region> Lire();

    Iterable<Object[]> getRegionsSP();
    //List<Region> RegionSP();
    Region modifier(Long idRegion, Region region);
    String supprimer(Long idRegion);
}
