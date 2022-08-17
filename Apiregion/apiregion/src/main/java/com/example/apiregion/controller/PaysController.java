package com.example.apiregion.controller;

import com.example.apiregion.modele.Pays;
import com.example.apiregion.service.PaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/pays")
@AllArgsConstructor
@Api(value = "hello", description = "Gestion des pays")
public class PaysController {
    @Autowired
    private final PaysService paysService;

    @ApiOperation(value = "Ajouter un pays")
    @PostMapping("/ajouter")
    public Pays create(@RequestBody Pays pays){
        return paysService.Ajouter(pays);
    }

    @ApiOperation(value = "Afficher la liste des pays")
    @GetMapping("/Afficher")
    public List<Pays> read(){
        return paysService.Lire();
    }

    @ApiOperation(value = "Modifier un pays ")
    @PutMapping("/modifier/{idPays}")
    public Pays update(@PathVariable Long idPays, @RequestBody Pays pays){
        return paysService.modifier(idPays, pays);
    }

    @ApiOperation(value = "Supprimer un pays")
    @DeleteMapping("/supprimer/{idPays}")
    public String delete(@PathVariable Long idPays){
        return paysService.supprimer(idPays);
    }
}
