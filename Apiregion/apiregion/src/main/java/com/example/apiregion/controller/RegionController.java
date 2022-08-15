package com.example.apiregion.controller;

import com.example.apiregion.modele.Region;
import com.example.apiregion.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/regions")
@AllArgsConstructor
@Api(value = "hello", description = "Gestion des regions")
public class RegionController {
    private final RegionService regionService;

    @ApiOperation(value = "Ajouter une region")
    @PostMapping("/ajouter")
    public Region create(@RequestBody Region region){
        return regionService.creer(region);
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
