package com.example.apiregion.repository;


import com.example.apiregion.modele.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    //@Query("Select idRegion,code_region,nom,domaineAct,superficie,langue FROM region,population WHERE population.id_population=region.id_population")
    @Query(value = "Select id_region,code_region,nom,domaine_act,superficie,langue FROM region", nativeQuery=true)
    Iterable<Object[]> getRegionsSP ();
}
