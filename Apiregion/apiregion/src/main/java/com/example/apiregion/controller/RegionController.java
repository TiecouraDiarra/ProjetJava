package com.example.apiregion.controller;

import com.example.apiregion.modele.Pays;
import com.example.apiregion.modele.Population;
import com.example.apiregion.modele.Region;
import com.example.apiregion.repository.PopulationRepository;
import com.example.apiregion.service.PaysService;
import com.example.apiregion.service.PopulationService;
import com.example.apiregion.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/regions")
@AllArgsConstructor
@Api(value = "hello", description = "Gestion des regions")
public class RegionController {
    @Autowired
    private final RegionService regionService;
    @Autowired
    PaysService ps;

    @Autowired
    PopulationService popS;

    @ApiOperation(value = "Ajouter une region")
    @PostMapping("/ajouter")
    public Region create(@RequestBody Region region, Population population){
        Pays pays = ps.getNomPays(region.getPays());
        if(pays==null || population==null){
            ps.Ajouter(region.getPays());
            //population.setRegion(region);
            popS.Ajouter(population);
        }
        return regionService.creer(region);

        /*Pays p=new Pays();
        p.setNomPays("test");
        ps.Ajouter(p);
        region.setPays(p);
        Pays p = new Pays();
        p.setNomPays(pays.getNomPays());
        ps.Ajouter(p);
        regionService.creer(region);*/

        /*for (int i =0; i<region.getPopulation().size(); i++){
            Population population = popS.getNb_population(region.getPopulation().get(i));
            if (population==null){
                popS.Ajouter(region.getPopulation().get(i));
                //Population pp = popS.Ajouter(region.getPopulation().get(i));
            }
        }*/


    }

    @ApiOperation(value = "Afficher la liste des régions sans pays")
    @GetMapping("/lireSP")
    public Iterable<Object[]> getRegionsSP(){
        return regionService.getRegionsSP();
    }

    @ApiOperation(value = "Afficher la liste des régions avec pays")
    @GetMapping("/lire")
    public List<Region> read(){
        return regionService.Lire();
    }

    /*@GetMapping("/readSP")
    public List<Region> readSP(){
        return regionService.RegionSP();
    }*/

    @ApiOperation(value = "Modifier une region")
    @PutMapping("/modifier/{idRegion}")
    public Region update(@PathVariable Long idRegion, @RequestBody Region region){
        return regionService.modifier(idRegion, region);
    }

    @ApiOperation(value = "Supprimer une region")
    @DeleteMapping("/supprimer/{idRegion}")
    public String delete(@PathVariable Long idRegion){
        return regionService.supprimer(idRegion);
    }
}
