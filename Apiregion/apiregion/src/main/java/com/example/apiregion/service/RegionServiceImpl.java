package com.example.apiregion.service;

import com.example.apiregion.modele.Region;
import com.example.apiregion.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService{

    @Autowired
    private final RegionRepository regionRepository;

    @Override
    public Region creer(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> Lire() {
        return regionRepository.findAll();
    }

    public Iterable<Object[]> getRegionsSP() {
        return regionRepository.getRegionsSP();
    }

    @Override
    public Region modifier(Long idRegion, Region region) {
        return regionRepository.findById(idRegion)
                .map(p->{
                    p.setCode_region(region.getCode_region());
                    p.setNom(region.getNom());
                    p.setDomaineAct(region.getDomaineAct());
                    p.setSuperficie(region.getSuperficie());
                    p.setLangue(region.getLangue());
                    return regionRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Region non trouvée !"));
    }

    @Override
    public String supprimer(Long idRegion) {
        regionRepository.deleteById(idRegion);
        return "Region supprimée";
    }
}
